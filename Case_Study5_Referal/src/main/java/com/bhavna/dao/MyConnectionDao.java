package com.bhavna.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bhavna.utility.MyConnection;

public class MyConnectionDao {

	public static void viewData() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = MyConnection.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from referral");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
						+ rs.getInt(4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7) + " "
						+ rs.getString(8));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("insert into referral values(?,?,?,?,?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("enter referralId:");
				int id = Integer.parseInt(br.readLine());
				System.out.println("enter firstname:");
				String name = br.readLine();
				System.out.println("enter lastname:");
				String lname = br.readLine();
				System.out.println("enter mobile:");
				int mobile = Integer.parseInt(br.readLine());
				System.out.println("enter email:");
				String email = br.readLine();
				System.out.println("enter userId:");
				int userId = Integer.parseInt(br.readLine());
				System.out.println("enter dateOfReferral:");
				String date = br.readLine();
				System.out.println("enter statusOfReferral:");
				String status = br.readLine();

				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setString(3, lname);
				stmt.setInt(4, mobile);
				stmt.setString(5, email);
				stmt.setInt(6, userId);
				stmt.setString(7, date);
				stmt.setString(8, status);
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

	public static void updateData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("update referral set referralFirstName =? where referalId =?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter id to update referral");
			int id = Integer.parseInt(br.readLine());
			System.out.println("enter firstname:");
			String name = br.readLine();
			stmt.setString(1, name);
			stmt.setInt(2, id);
			int i = stmt.executeUpdate();

			System.out.println("updated");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void deleteData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("delete from referral where referalId =?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter id to delete records");
			int id = Integer.parseInt(br.readLine());
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			System.out.println("deleted");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
