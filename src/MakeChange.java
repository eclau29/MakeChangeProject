import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		String contOrStop;
		do {
			runMakerOfChange(kb);
			contOrStop = contOrStop(kb);
			
		} while (contOrStop.equalsIgnoreCase("Y"));
		if (contOrStop.equalsIgnoreCase("n")) {
			System.out.println("Thank you for shopping with us! Come back soon :)");
		}
		
		
		kb.close();
	}
	public static String contOrStop (Scanner kb) {
		
		System.out.print("Would you like to make another transaction? (Y/N): ");
		String answer = kb.next();
		
		return answer;
	}

	public static void runMakerOfChange(Scanner kb) {
 System.out.println("Welcome to Maker of Change!");

		double price = getPrice(kb);
		double tender = getTender(kb);
		double finalTender = payMe(kb, price, tender);
//System.out.println(payMe(kb, price, tender)); //this is just to make sure I know how much money is tendered
		if (price == finalTender) {
			System.out.println("Exact change?!? You're the best! :D");
		} else {
			makeChange(price, finalTender);
		}
	}

	private static void makeChange(double price, double finalTender) {
		if (price < finalTender) {
			double change = (finalTender - price) + 0.0001; // gives a change value that factors in the lack of precision when dealing with doubles
			if ((change / 20) >= 1) {
				double num20s = change / 20;
				int qty20s = (int) (num20s);
				System.out.println("Here are " + qty20s + " $20 bills");
				change = ((num20s - qty20s) * 20); 
				System.out.printf("change left = %.2f\n", change); // prints out the remaining change left to two decimal places
			} 

			if ((change / 10) >= 1) {
				double num10s = change / 10;
				int qty10s = (int) (num10s);
				System.out.println("I am giving you " + qty10s + " $10 bill(s).");
				change = ((num10s - qty10s) * 10);
//				System.out.printf("Change left = %.2f\n", change);
			}
			if ((change / 5) >= 1) {
				double num5s = change / 5;
				int qty5s = (int) (num5s);
				System.out.println("I am giving you " + qty5s + " $5 bill(s).");
				change = ((num5s - qty5s) * 5);
//				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / 1) >= 1) {
				double num1s = change / 1;
				int qty1s = (int) (num1s);
				System.out.println("I am giving you " + qty1s + " $1 bill(s).");
				change = ((num1s - qty1s) * 1);
//				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / .25) >= 1) {
				double numQtrs = change / .25;
				int qtyQtrs = (int) (numQtrs);
				System.out.println("I am giving you " + qtyQtrs + " quarter(s).");
				change = ((numQtrs - qtyQtrs) * 0.25);
//				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / .1) >= 1) {
				double numDimes = change / .1;
				int qtyDimes = (int) (numDimes);
				System.out.println("I am giving you " + qtyDimes + " dime(s(.");
				change = ((numDimes - qtyDimes) * .1);
//				System.out.printf("Remaining change = %.2f\n", change);
			}
			if ((change / .05) >= 1) {
				double numNicks = change / .05;
				int qtyNicks = (int) (numNicks);
				System.out.println("I am giving you " + qtyNicks + " nickel(s).");
				change = ((numNicks - qtyNicks) * .05);
//				System.out.printf("Remaining change = %.2f\n", change);
			}
			if ((change / .01) >= 1) {
				double numPenns = change / .01;
				int qtyPenns = (int) (numPenns);
				System.out.println("I am giving you " + qtyPenns + " penny/pennies.");
				change = ((numPenns - qtyPenns) * .05);
//				System.out.printf("Remaining change = %.2f\n", change);
			}
		}
	}

	public static double getPrice(Scanner kb) {
		System.out.print("How much is your item? (please omit any '$' signs): ");

		double price = kb.nextDouble();

		return price;
	}

	public static double getTender(Scanner kb) {
		System.out.print("Please enter the amount tendered: ");
		double tender = kb.nextDouble();

		return tender;
	}

	public static double payMe(Scanner kb, double price, double tender) {
		while (tender < price) {
			System.out.println("Please insert more money; how much more did you insert?");
			double nextTender = kb.nextDouble();
			tender += nextTender;
		}
		return tender;
	}

}
