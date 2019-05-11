import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		runMakerOfChange(kb);
		
		System.out.print("I have given you correct change. Would you like to make another transaction? (Y/N): ");
		String contOrStop = kb.next();
		do {
			runMakerOfChange(kb);
		} while (contOrStop.equalsIgnoreCase("Y"));
		
		
		kb.close();
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

//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.
	private static void makeChange(double price, double finalTender) {
//		System.out.println("*makes change*"); USED THIS TO MAKE SURE EXECUTING DURING CORRECT SITUATIONS
		if (price < finalTender) {
			double change = (finalTender - price) + 0.0001;
			if ((change / 20) >= 1) {
				double num20s = change / 20;
//				System.out.println(num20s); //prints out correct double
				int qty20s = (int) (num20s);
				System.out.println("Here are " + qty20s + " $20 bills");
				change = ((num20s - qty20s) * 20); // helps factor in the lack of precision when dealing with
													// doubles
				System.out.printf("change left = %.2f\n", change); // prints out the remaining change left to two
			} // decimal places

			if ((change / 10) >= 1) {
				double num10s = change / 10;
				int qty10s = (int) (num10s);
				System.out.println("Here are " + qty10s + " $10 bills.");
				change = ((num10s - qty10s) * 10);
				System.out.printf("Change left = %.2f\n", change);
			}
			if ((change / 5) >= 1) {
				double num5s = change / 5;
				int qty5s = (int) (num5s);
				System.out.println("Here are " + qty5s + " $5 bills.");
				change = ((num5s - qty5s) * 5);
				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / 1) >= 1) {
				double num1s = change / 1;
				int qty1s = (int) (num1s);
				System.out.println("Here are " + qty1s + " $1 bills.");
				change = ((num1s - qty1s) * 1);
				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / .25) >= 1) {
				double numQtrs = change / .25;
				int qtyQtrs = (int) (numQtrs);
				System.out.println("here are " + qtyQtrs + " quarters.");
				change = ((numQtrs - qtyQtrs) * 0.25);
				System.out.printf("change left = %.2f\n", change);
			}
			if ((change / .1) >= 1) {
				double numDimes = change / .1;
				int qtyDimes = (int) (numDimes);
				System.out.println("Here are " + qtyDimes + " dimes.");
				change = ((numDimes - qtyDimes) * .1);
				System.out.printf("Remaining change = %.2f\n", change);
			}
			if ((change / .05) >= 1) {
				double numNicks = change / .05;
				int qtyNicks = (int) (numNicks);
				System.out.println("Here are " + qtyNicks + " nickels.");
				change = ((numNicks - qtyNicks) * .05);
				System.out.printf("Remaining change = %.2f\n", change);
			}
			if ((change / .01) >= 1) {
				double numPenns = change / .01;
				int qtyPenns = (int) (numPenns);
				System.out.println("Here are " + qtyPenns + " pennies.");
				change = ((numPenns - qtyPenns) * .05);
				System.out.printf("Remaining change = %.2f\n", change);
			}
		}
	}

	public static double getPrice(Scanner kb) {
		System.out.print("Welcome to Check-Out!\nHow much is your item (please omit any '$' signs): ");

		double price = kb.nextDouble();

		return price;
	}

	public static double getTender(Scanner kb) {
		System.out.print("Please enter the amount tendered: ");
		double tender = kb.nextDouble();

		return tender;
	}

	public static double payMe(Scanner kb, double price, double tender) {
//	
		while (tender < price) {
			System.out.println("Please insert more money; how much more did you insert?");
			double nextTender = kb.nextDouble();
			tender += nextTender;
//			System.out.println(tender);
		}
		return tender;
	}

}
