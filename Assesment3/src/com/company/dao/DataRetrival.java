package com.company.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import main.com.company.bean.ReferralCode;

public class DataRetrival {
	Scanner sc = new Scanner(System.in);

	public void addData() {
		System.out.println("Enter Number of Referrals:");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Name: ");
			String name = sc.next();
			System.out.println("Enter Number: ");
			int number = sc.nextInt();
			System.out.println("Enter Referral Code: ");
			String referral = sc.next();
			ReferralCode code = new ReferralCode(name, number, referral);
			ArrayList<ReferralCode> list = new ArrayList<>();
			list.add(code);

			try {
				FileOutputStream fout = new FileOutputStream(
						new File("C:\\Users\\Saumya.Prabhakar\\Documents\\Folder\\Referral.txt"));
				ObjectOutputStream out = new ObjectOutputStream(fout);
				out.writeObject(code);
				out.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("succesfully serialized");

			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream("C:\\Users\\Saumya.Prabhakar\\Documents\\Folder\\Referral.txt"));
				ReferralCode details = (ReferralCode) in.readObject();
				System.out.println(details.getName() + " " + details.getNumber() + " " + ReferralCode.referral + " "
						+ ReferralCode.points++);
				in.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
