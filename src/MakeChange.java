import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		double price = getPrice(kb);
		double tender = getTender(kb);
		double finalTender = payMe(kb, price, tender);
//System.out.println(payMe(kb, price, tender)); //this is just to make sure I know how much money is tendered
		if (price == finalTender) {
			System.out.println("Exact change?!? You're the best! :D");
		} else {
			makeChange(price, finalTender);
		}

		kb.close();
	}

	private static void makeChange(double price, double finalTender) {
//		System.out.println("*makes change*"); USED THIS TO MAKE SURE EXECUTING DURING CORRECT SITUATIONS
		if ( price < finalTender) {
			double change = finalTender - price;
//		System.out.println(change);; USED TO MAKE SURE CHANGE CALCULATION IS CORRECT
			
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
//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.

}
