package com.bhavna.bean;

import java.security.SecureRandom;
import java.util.Random;

public class CoupounCode {
public static  String Code;
	
	public static String createCoupounCode() {
		int codeLength=6;
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new SecureRandom();
		for (int i = 0; i < codeLength; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		 Code = sb.toString();
		System.out.println(Code);
		return Code;
		
	}

}
