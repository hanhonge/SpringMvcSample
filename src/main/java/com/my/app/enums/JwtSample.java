package com.my.app.enums;

import java.util.HashMap;

public class JwtSample {
	public static void main(String[] args) {
		String token = JwtTokenFactory.DEFAULT.createJwtToken(new HashMap<>());
		System.out.println(
				token
				);
		
		JwtResult jr = JwtTokenFactory.DEFAULT.parseJwtToken(token);
		
		if( jr.isSuccess() ) {
			jr.printClaims();	
		}
	}
}
