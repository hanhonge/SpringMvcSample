package com.my.app.enums;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public enum JwtTokenFactory {
	DEFAULT("secretKey", SignatureAlgorithm.HS512, (1000 * 60 * 1));

	private String secretKey;
	private SignatureAlgorithm signAlgorithm;
	private long expireTime;
	
	JwtTokenFactory(String secretKey, SignatureAlgorithm signAlgorithm, long expireTime) {
		this.secretKey = secretKey;
		this.signAlgorithm = signAlgorithm;
		this.expireTime = expireTime;
	}

	/**
	 * 토큰 생성
	 * @param claims 토큰 payload claims
	 * @return
	 */
	public String createJwtToken(Map<String, Object> claims) {
		return Jwts.builder()
				.setId("jwtTokenDefault")
				.setClaims(claims)
				.signWith(signAlgorithm, DatatypeConverter.parseBase64Binary(secretKey))
				.setExpiration(new Date(System.currentTimeMillis() + expireTime))
				.compact();
	}
	
	/**
	 * jwt 토큰 파싱 처리
	 * @param token
	 * @return
	 */
	public JwtResult parseJwtToken(String token) { 
		try {
			
			JwtResult.SUCCESS.setClaims(Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
					.parseClaimsJws(token).getBody());
			
			return JwtResult.SUCCESS;
		} catch(ExpiredJwtException e1) {
			return JwtResult.EXPIRE_TIME;
		} catch(Exception e2) {
			return JwtResult.ETC;
		}
	}
}


