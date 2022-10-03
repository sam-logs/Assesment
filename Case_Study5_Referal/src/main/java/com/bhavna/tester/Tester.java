package com.bhavna.tester;

import java.util.Scanner;

import com.bhavna.bean.CoupounCode;
import com.bhavna.bean.Login;
import com.bhavna.bean.SignUp;
import com.bhavna.dao.BuyingDetails;
import com.bhavna.dao.MyConnectionDao;
import com.bhavna.dao.UserDao;
import com.bhavna.utility.MyConnection;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			MyConnection.getConnection();

			System.out.println("\t\t\t\t\t!!!Welcome to DPhone corporation!!!  ");
			System.out.println("Press 1 for login to the System");
			System.out.println("Press 2 if you are New User ");
			System.out.println("Press 3 to view,edit or delete your referral");
			System.out.println("Press 4 to purchase phone");
			System.out.println("Press 5 to for user view");

			System.out.println("Enter your choice \n");
			int choice = sc.nextInt();

			if (choice == 1) {
				// for login
				System.out.println("Enter your username");
				String username = sc.next();
				System.out.println("Enter Password: ");
				String password = sc.next();
				Login login = new Login(username, password);
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
				SignUp register = new SignUp(email, name, gender, number);
				register.display();
			} else if (choice == 3) {
				System.out.println("Press 6 to add referral details");
				System.out.println("Press 7 to view referral details: ");
				System.out.println("Press 8 to delete details");
				System.out.println("Press 9 to edit referral details");
				int choices = sc.nextInt();
				if (choices == 6) {
					MyConnectionDao.addData();

				} else if (choices == 7) {
					MyConnectionDao.viewData();

				} else if (choices == 8) {
					MyConnectionDao.deleteData();

				} else if (choices == 9) {
					MyConnectionDao.updateData();

				}

			} else if (choice == 4) {
				System.out.println("Welcome to Dphone,Which Phone do you want!!!!!");
				BuyingDetails.addCustomerData();
				BuyingDetails.addData();
				System.out.println("Your ReferralCode has been Successfully Applied!!hoorah 10% discount applied");
				System.out.println("\nYou have won a Coupoun Code");
				CoupounCode.createCoupounCode();
				System.out.println("You have won Coupon code, Do you want to use it:");
				String response = sc.next();
				if (response.contains("yes")) {
					System.out.println("Please Enter Coupon Code: ");
					String offer = sc.next();
					if (CoupounCode.Code.equalsIgnoreCase(offer)) {
						System.out.println("20% discount applied!! ");
						System.out.println("\nPurchased");
					}

				}
			} else if (choice == 5) {
				System.out.println("Do you want to referr");
				int input = sc.nextInt();

				if (input == 1) {
					System.out.println("Please refer to someone: ");
					UserDao.addData();
				} else {
					System.out.println("\nUser can See their Referral Points and details");
					UserDao.viewData();
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		} /*
			 * finally { try { if (sc != null) sc.close(); } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */
	}
}
