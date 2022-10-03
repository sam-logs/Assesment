package com.company.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import main.com.company.bean.ReferralCode;

public class DataUpdation {
	Scanner sc = new Scanner(System.in);
	private DataRetrival data;

	public void updateData() {

		ArrayList<ReferralCode> list = new ArrayList<>();
		list.get();
		System.out.println("Enter Name: ");
		String editName = sc.next();
		System.out.println("Enter Number: ");
		int editNumber = sc.nextInt();
		System.out.println("Enter Referral Code: ");
		String editReferralCode = sc.next();
		ReferralCode editCode = new ReferralCode(editName, editNumber, editReferralCode);
		list.set(0, editCode);
		Iterator<ReferralCode> itr = list.iterator(); // Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			ReferralCode view = (ReferralCode) itr.next();
			System.out.println(view.getName() + " " + view.getNumber() + " " + ReferralCode.referral);
		}

	}

}
