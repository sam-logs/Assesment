package main.com.company.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReferralCode implements Serializable {
	private String name;
	private int number;
	public static String referral;
	public static int points;

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

}
