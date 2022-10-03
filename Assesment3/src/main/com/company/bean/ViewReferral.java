package main.com.company.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ViewReferral {
	Scanner sc = new Scanner(System.in);
	public void referralView() {
		ArrayList<ReferralCode> list = new ArrayList<>();
		Iterator<ReferralCode> itr = list.iterator(); // Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			ReferralCode view = (ReferralCode) itr.next();
			System.out.println("Name:" + view.getName() + " " + "Mobile No.: " + view.getNumber() + " "
					+ "ReferralCode: " + ReferralCode.referral + " " + "Bonus Point: "
					+ ReferralCode.points);
			System.out.println("\nPress 4 to purchase new phone");
			int next = sc.nextInt();
			if (next == 4) {
				PhonePurchase obj = new PhonePurchase();
				obj.phoneBuy();

				System.out.println("\nAfter purchase Referral Point of user:");
				try {
					FileOutputStream fout = new FileOutputStream(
							new File("C:\\Users\\Saumya.Prabhakar\\Documents\\Folder\\Referral.txt"));
					ObjectOutputStream out = new ObjectOutputStream(fout);
					out.writeObject(list);
					out.close();

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("\nsuccessfully serialized");

				// deserialize
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(
							"C:\\Users\\Saumya.Prabhakar\\Documents\\Folder\\Referral.txt"));
					ReferralCode details = (ReferralCode) in.readObject();
					System.out.println("Name:" + details.getName() + " " + "Mobile No."
							+ details.getNumber() + " " + "ReferralCode: " + ReferralCode.referral + " "
							+ "Bonus Point: " + ReferralCode.points);
					in.close();

				} catch (Exception e) {
					System.out.println(e);
				}

			}

		}
	}

}
