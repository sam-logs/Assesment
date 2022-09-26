package com.assesment2.ashaSoftware;

import java.util.*;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\tWelcome to Food Ordering System!!!  ");
		System.out.println("Press 1 for login to the System");
		System.out.println("Press 2 if you are New User ");
		System.out.println("Press 3 to search Hotels Nearby you");
		System.out.println("Enter your choice \n");
		int choice = sc.nextInt();

		if(choice == 1) {
			//for login 
			System.out.println("Enter your username");
			String username = sc.next();
			System.out.println("Enter Password: ");
			String password = sc.next();
			CustomerLogin cl = new CustomerLogin(username, password);
			cl.display();
		}
		else if(choice == 2) {
			//for registering
			System.out.println("Enter Your Name: ");
			String name = sc.next();
			System.out.println("Enter Your Email: ");
			String email =sc.next();
			System.out.println("Enter Your Gender: ");
			String gender = sc.next();
			System.out.println("Enter Your PhoneNumber: ");
			int number =sc.nextInt();
			RegisterCustomer rc = new RegisterCustomer(email, name, gender, number);
			rc.display();
		}
		else if(choice == 3) {
			//for searching nearby
			HotelSearch obj = new HotelSearch();
			if(Distance.distance() <= 1.5) {
				
				obj.findHotel();
			}else {
				obj.distanceHotels();
			}
			
		//	System.out.println("Didn't get your hotels! find more");
			//for searching farby

//			int more =sc.nextInt();
//			if(more == 4) {
//				obj.distanceHotels();
			}
		}
	}

