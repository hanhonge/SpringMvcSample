package com.my.app.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;

public class JwtSample {
	public static void main(String[] args) {
		
		Map<String, Object> claims = new HashMap<>();
		//토큰 생성일자 설정
		claims.put(Claims.ISSUED_AT, new Date(System.currentTimeMillis()));
		claims.put("key1", "val1");
		String token = JwtTokenFactory.DEFAULT.createJwtToken(claims);
		System.out.println(
				token
				);
		
		JwtResult jr = JwtTokenFactory.DEFAULT.parseJwtToken(token);
		
		if( jr.isSuccess() ) {
			jr.printClaims();	
		}
	}
}
