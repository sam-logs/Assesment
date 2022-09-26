package com.assesment2.ashaSoftware;

public class CustomerLogin {
	//creating login page for user with following data members;
	private String userName;
	private String password;
	public String getName() {
		return userName;
	}
	public void setName(String userNname) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerLogin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	//displaying after successfull login. 
	public void display() {
		System.out.println("You have Succesfully logged in User: "+userName);
	}

}
