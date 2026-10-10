package myPack;

import java.util.Scanner;

@SuppressWarnings("serial")
class AcountBlokException extends Exception {
	public AcountBlokException(String sms) {
		super(sms);
	}
}

public class Paymentsimulator {
	public static boolean timer() {
		for (int i = 0; i <= 5; i++) {
			try {
				System.out.println("Please wait verifying pin...");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean recharge() {
		for (int i = 0; i <= 5; i++) {
			try {
				System.out.println("Processing...");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean mini() {
		for (int i = 0; i <= 5; i++) {
			try {
				System.out.println("Please wait a moment...");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean minis() {
		for (int i = 0; i <= 5; i++) {
			try {
				System.out.println("Adding amount...");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean minii() {
		for (int i = 0; i <= 5; i++) {
			try {
				System.out.println("Sending.......");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------ MINI GOOGLE PAY -----------");
		long amount = 00000L;
		long add = 00000L;
		int i = 0;
		int pin;
		long send = 00000L;
		int rechargeamount = 0;
		while (true) {
			System.out
					.println("1.Check balance\n2.Add money\n3.Send money\n4.Mobile recharge\n5.Mini statement\n6.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				do {
					System.out.println("Enter your pin");
					pin = sc.nextInt();
					timer();

					if (pin != 111111) {
						System.out.println("Wrong pin");
					} else {
						// checking balance after adding money than still shwoing 0
						System.out.println("Pin Matched Successfully");
						System.out.println("Your balance is" + " " + amount);

					}
					i++;
					if (i == 3) {
						try {
							throw new AcountBlokException("Account blocked");
						} catch (AcountBlokException e) {
							e.printStackTrace();
							return;
						}

					}
				} while (pin != 111111);

				break;
			case 2:
				System.out.println("Enter the amount you want to add");
				add = sc.nextLong();
				System.out.println("Enter your pin");
				pin = sc.nextInt();
				amount += add;
				if (add > 0) {
					minis();
					System.out.println("Money added successfully into your account" + " " + add);
				} else {
					System.out.println("Invalid Input");
				}
				break;
			case 3:
				System.out.println("Enter the mobile number");
				long mobile = sc.nextLong();
				int j = 0;
				int count = 0;
				while (j < mobile) {
					long digit = mobile % 10;
					count++;
					mobile /= 10;
				} // after entering 3 pin exceptions
				if (count == 10) {
					System.out.println("Enter the amount you want to send");
					send = sc.nextLong();
//					System.out.println("Enter the pin");
//					pin = sc.nextInt();
					amount -= send;
					if (send < add) {
						System.out.println("Enter the pin");
						pin = sc.nextInt();
						if (pin != 111111) {
							System.out.println("Invalid Pin");
						} else {
							minii();
							System.out.println("Amount sended successfully");
							System.out.println("Available balance is" + " " + (add - send - rechargeamount));
						}
					} else {
						System.out.println("Insufficient Balance");
					}
				} else {
					System.out.println("Invalid Phone Number");
				}
				break;
			case 4:
				System.out.println("Enter the phone number");
				long phone = sc.nextLong();
				int co = 0;
				int k = 0;
				while (k < phone) {
					long digi = phone % 10;
					co++;
					phone /= 10;
				}

				if (co == 10) {
					System.out.println("Enter the recharge amount");
					rechargeamount = sc.nextInt();
					recharge();
					if (rechargeamount < amount) {
						System.out.println("Recharge Successful");
						amount -= rechargeamount;
					} else {
						System.out.println("Insufficient Balance");
					}
				} else {
					System.out.println("Invalid mobile number");
				}
				break;
			case 5:
				mini();
				System.out.println("~~~~~~~~~~~~~~~ MINI STATEMENT ~~~~~~~~~~~~~~");
				System.out.println("Added" + "              : " + add);
				System.out.println("Recharge" + "           : " + rechargeamount);
				System.out.println("Send" + "               : " + send);
				amount = add - rechargeamount - send;
				System.out.println("Available Balance" + "  : " + amount); // total
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
			case 6:
				System.out.println("🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶 THANK YOU FOR USING GOOGLE PAY 🎶🎶🎶🎶🎶🎶🎶🎶🎶🎶");
				return;
			}

		}
	}

}
