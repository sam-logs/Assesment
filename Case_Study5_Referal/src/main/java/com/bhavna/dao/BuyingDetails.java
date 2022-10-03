package com.bhavna.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bhavna.utility.MyConnection;

public class BuyingDetails {
	public static void addData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("insert into buyingdetails values(?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("enter customerId:");
				int id = Integer.parseInt(br.readLine());
				System.out.println("enter userId:");
				int userid = Integer.parseInt(br.readLine());
				System.out.println("enter date:");
				String date = br.readLine();
				System.out.println("enter productname:");
				String product = br.readLine();
				

				stmt.setInt(1, id);
				stmt.setInt(2, userid);
				stmt.setString(3, date);
				stmt.setString(4, product);
				
				int i = stmt.executeUpdate();
				System.out.println(i + " records affected");

				System.out.println("Do you want to continue: y/n");
				String s = br.readLine();
				if (s.startsWith("n")) {
					break;
				}
			} while (true);

			System.out.println("Inserted");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void addCustomerData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("insert into customer values(?,?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("enter customerId:");
				int id = Integer.parseInt(br.readLine());
				System.out.println("enter firstname:");
				String fname = br.readLine();
				System.out.println("enter lastname:");
				String lname = br.readLine();
				System.out.println("enter email:");
				String email = br.readLine();
				System.out.println("enter mobile:");
				int mobile = Integer.parseInt(br.readLine());
				

				stmt.setInt(1, id);
				stmt.setString(2, fname);
				stmt.setString(3, lname);
				stmt.setString(4, email);
				stmt.setInt(5, mobile);
				
				int i = stmt.executeUpdate();
				System.out.println(i + " records affected");

				System.out.println("Do you want to continue: y/n");
				String s = br.readLine();
				if (s.startsWith("n")) {
					break;
				}
			} while (true);

			System.out.println("Inserted");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

}
