package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Valuable utility methods for practice using Lists and Comparator.
 * @author Napong Dungduangsasitorn
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param valuablelist is a List of value objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuablelist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuablelist, String currency) {
		List<Valuable> valuableList = new ArrayList<Valuable>();
		for(Valuable value : valuablelist){
			if(value.getCurrency().equals(currency)){
				valuableList.add(value);
			}
		}
		return valuableList; // return a list of value references copied from valuablelist.
	}


	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		Collections.sort(valuable, new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		/*sortByCurrency(valuable);
		double sum = 0;
		String currency = valuable.get(0).getCurrency();

		for(Valuable v : valuable){
			if(v.getCurrency().equals(currency)){
				sum += v.getValue();
			}
			else{
				System.out.print(sum + " " + currency + " ");
				sum = 0;
				sum += v.getValue();
				currency = v.getCurrency();

			}
		}
		System.out.print(sum + " " + currency + " ");
		*/
		
		
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter valuable by currency of "+currency);
		List<Valuable> coins = makeInternationalValuable();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Coin> makeInternationalCoins( ) {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */ 
	public static List<Coin> makeCoins(String currency, double ... values) {
		List<Coin> list = new ArrayList<Coin>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}

/**
 * class for compare two coins by currency.
 */

class CompareByCurrency implements Comparator<Valuable>{

	/**
	 * compare two coins
	 * @param arg0 is first coin.
	 * @param aeg1 is second coin.
	 * @return positive if arg0 more than arg1,
	 * 		   negative if arg0 less than arg1,
	 * 		   0 if arg0 and arg1 is equals.
	 */
	@Override
	public int compare(Valuable arg0, Valuable arg1) {

		return arg0.getCurrency().compareTo(arg1.getCurrency());
	}

}
