package main.com.company.bean;

public class Register {
	// creating signup form for user with following data members.
	private String email;
	private String name;
	private String Gender;
	private int number;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Register(String email, String name, String Gender, int number) {
		this.email = email;
		this.name = name;
		this.Gender = Gender;
		this.number = number;
	}

	// using display method after successful registration which will be prompt to
	// the user.
	public void display() {
		System.out.println("Thanks for registering with us! " + name);
	}

}
