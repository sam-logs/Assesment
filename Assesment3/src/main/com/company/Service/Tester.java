package main.com.company.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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

				System.out.println("Enter number of referrals: ");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("Enter Name: ");
					String name = sc.next();
					System.out.println("Enter Number: ");
					int number = sc.nextInt();
					System.out.println("Enter Referral Code: ");
					String referral = sc.next();
					code = new ReferralCode(name, number, referral);

					ArrayList<ReferralCode> list = new ArrayList<>();
					list.add(code);

					System.out.println("press 6 to write output to a file");
					System.out.println("Press 7 to view referral details: ");
					System.out.println("Press 8 to delete details");
					System.out.println("Press 9 to edit referral details");
					int choices = sc.nextInt();
					if (choices == 6) {
						// serialize
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

						// deserialize
						try {
							ObjectInputStream in = new ObjectInputStream(new FileInputStream(
									"C:\\Users\\Saumya.Prabhakar\\Documents\\Folder\\Referral.txt"));
							ReferralCode details = (ReferralCode) in.readObject();
							System.out.println(details.getName() + " " + details.getNumber() + " "
									+ ReferralCode.referral + " " + ReferralCode.points++);
							in.close();

						} catch (Exception e) {
							System.out.println(e);
						}

					}

					else if (choices == 7) {
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
									out.writeObject(code);
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

					} else if (choices == 8) {
						list.remove(code);
						Iterator<ReferralCode> itr = list.iterator(); // Iterator
						while (itr.hasNext()) {// check if iterator has the elements
							ReferralCode view = (ReferralCode) itr.next();
							System.out.println(view.getName() + " " + view.getNumber() + " " + ReferralCode.referral);
						}

					}

					else if (choices == 9) {
						list.get(i);
						System.out.println("Enter Name: ");
						String editName = sc.next();
						System.out.println("Enter Number: ");
						int editNumber = sc.nextInt();
						System.out.println("Enter Referral Code: ");
						String editReferralCode = sc.next();
						ReferralCode editCode = new ReferralCode(editName, editNumber, editReferralCode);
						list.set(i, editCode);
						Iterator<ReferralCode> itr = list.iterator(); // Iterator
						while (itr.hasNext()) {// check if iterator has the elements
							ReferralCode view = (ReferralCode) itr.next();
							System.out.println(view.getName() + " " + view.getNumber() + " " + ReferralCode.referral);
						}

					}

				}

			} else {
				System.out.println("invalid Choice");
			}
		}

	}

}
