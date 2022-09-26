package main.com.company.Service;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class PhonePurchase implements Serializable {
	Scanner sc = new Scanner(System.in);

	public void phoneBuy() {

		System.out.println("Welcome! Do you want to buy new phone");
		String data = sc.next();
		if (data.contains("yes")) {
			System.out.println("Do you have referral!");
			String input = sc.next();
			if (input.contains("yes")) {
				System.out.println("Enter Referral Code");
				String code = sc.next();
				if (code.equalsIgnoreCase(ReferralCode.referral)) {
					ReferralCode.points = 1000;
					System.out.println("Your Code has been Successfully Applied!!hoorah");
					System.out.println("\nYou have won a Coupoun Code");
					ReferralCode.createCoupounCode();
					System.out.println("You have won Coupon code, Do you want to use it:");
					String response = sc.next();
					if (response.contains("yes")) {
						System.out.println("Please Enter Coupon Code: ");
						String offer = sc.next();
						if (ReferralCode.Code.equalsIgnoreCase(offer)) {
							System.out.println("20% discount applied!! ");
						}
					}
				}
			} else {
				System.out.println("Continuing Without Referral! You won't be available for discounts!");
			}
		} else {
			System.out.println("Please visit us Next time!!");
		}
	}

	public void updatedPoints() {
		ReferralCode.points += 1000;
	}

}
