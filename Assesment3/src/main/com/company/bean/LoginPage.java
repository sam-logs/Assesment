package main.com.company.bean;

public class LoginPage {

	// creating login page for user with following data members;
	private String userName;
	private String password;

	public String getName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginPage(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// displaying after successfully login.
	public void display() {
		System.out.println("You have Succesfully logged in User: " + userName);
	}

}
