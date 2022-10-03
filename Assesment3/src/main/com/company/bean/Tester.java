package main.com.company.bean;

import java.util.Scanner;

import com.company.dao.*;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ReferralCode code;
			System.out.println("\t\t\t\t\t!!!Welcome to DPhone corporation!!!  ");
			System.out.println("Press 1 for login to the System");
			System.out.println("Press 2 if you are New User ");
			System.out.println("Press 3 to view,edit or delete your referral");

			System.out.println("Enter your choice \n");
			int choice = sc.nextInt();

			if (choice == 1) {
				// for login
				System.out.println("Enter your username");
				String username = sc.next();
				System.out.println("Enter Password: ");
				String password = sc.next();
				LoginPage login = new LoginPage(username, password);
				login.display();
			} else if (choice == 2) {
				// for registering
				System.out.println("Enter Your Name: ");
				String name = sc.next();
				System.out.println("Enter Your Email: ");
				String email = sc.next();
				System.out.println("Enter Your Gender: ");
				String gender = sc.next();
				System.out.println("Enter Your PhoneNumber: ");
				int number = sc.nextInt();
				Register register = new Register(email, name, gender, number);
				register.display();
			}

			else if (choice == 3) {

				DataRetrival add = new DataRetrival();
				add.addData();

				System.out.println("press 6 to write output to a file");
				System.out.println("Press 7 to view referral details: ");
				System.out.println("Press 8 to delete details");
				System.out.println("Press 9 to edit referral details");
				int choices = sc.nextInt();
				

				 if (choices == 7) {
					ViewReferral view = new ViewReferral();
					view.referralView();

				} else if (choices == 8) {
					DataDeletion delete = new DataDeletion();
					delete.deleteData();
				}

				else if (choices == 9) {
					DataUpdation update = new DataUpdation();
					update.updateData();
				}

			} else {
				System.out.println("invalid Choice");
			}

		}

	}
}
