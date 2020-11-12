package com.my.app.jwt;

import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;

/**
 * jwt 토큰 파싱 처리 결과를 처리 한다.
 * 
 * @author 권한혁
 *
 */
public enum JwtResult {
	 SUCCESS("0000", "성공")
	,EXPIRE_TIME("9999", "토큰 만료")
	,ETC("9998", "토큰 오류");
	
	@Getter
	private String id;
	@Getter
	private String msg;
	
	@Getter @Setter
	private Claims claims;
	
	JwtResult(String id, String msg) {
		this.id = id;
		this.msg = msg;
	}
	
	public boolean isSuccess() {
		return "0000".equals(id);
	}
	
	public void printClaims() {
		claims.forEach((s, o) -> System.out.println(s + ":" + o.toString()));
	}
}
