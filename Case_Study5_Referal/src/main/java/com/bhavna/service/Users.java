package com.bhavna.service;

public class Users {
	int userId;
	String firstName;
	String lastName;
	String address;
	int mobile;
	String email;
	String userName;
	String password;
	int referralPoints;

	public Users(int userId, String firstName, String lastName, String address, int mobile, String email,
			String userName, String password, int referralPoints) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.referralPoints = referralPoints;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", mobile=" + mobile + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", referralPoints=" + referralPoints + "]";
	}

}
