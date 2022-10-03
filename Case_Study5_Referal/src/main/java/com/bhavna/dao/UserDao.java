package com.bhavna.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bhavna.utility.MyConnection;

public class UserDao {
	public static void addData() {
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("enter userId:");
				int id = Integer.parseInt(br.readLine());
				System.out.println("enter firstname:");
				String name = br.readLine();
				System.out.println("enter lastname:");
				String lname = br.readLine();
				System.out.println("enter address:");
				String address = br.readLine();
				System.out.println("enter mobile:");
				int mobile = Integer.parseInt(br.readLine());
				System.out.println("enter email:");
				String email = br.readLine();			
				System.out.println("enter username:");
				String user = br.readLine();
				System.out.println("enter password:");
				String password = br.readLine();
				System.out.println("enter referralpoint:");
				int points = Integer.parseInt(br.readLine());

				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setString(3, lname);
				stmt.setString(4, address);
				stmt.setInt(5, mobile);
				stmt.setString(6, email);
				stmt.setString(7, user);
				stmt.setString(8, password);
				stmt.setInt(9, points);
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
	
	public static void viewData() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = MyConnection.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getInt(5) + " " + rs.getString(6) + " " + rs.getString(7) + " "
						+ rs.getString(8)+" "+rs.getInt(9));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
