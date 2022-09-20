package main.com.company.Service;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

@SuppressWarnings("serial")
public class ReferralCode implements Serializable{
	private String name;
	private int number;
	public static String referral;
	public static int points;
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
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static String getReferral() {
		return referral;
	}

	public static void setReferral(String referral) {
		ReferralCode.referral = referral;
	}

	public ReferralCode(String name, int number, String referral) {
		this.name = name;
		this.number = number;
		ReferralCode.referral = referral;
	}

	public void display() {
		System.out.println(name + " " + number + " " + referral);
	}
	

	

}
