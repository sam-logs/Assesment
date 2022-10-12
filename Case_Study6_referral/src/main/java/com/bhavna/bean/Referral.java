package com.bhavna.bean;

public class Referral {
	private int id;
	private String name;
	private int referrals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReferrals() {
		return referrals;
	}

	public void setReferrals(int referrals) {
		this.referrals = referrals;
	}

	public Referral(int id, String name, int referrals) {
		super();
		this.id = id;
		this.name = name;
		this.referrals = referrals;
	}

	public Referral() {
		super();
	}

}
