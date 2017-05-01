package coinpurse;

import coinpurse.gui.PurseObserver;
import coinpurse.gui.StatusObserver;
import coinpurse.strategy.RecursiveWithdraw;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Napong Dungduangsasitorn
 */
public class Main {

	private static int CAPACITY = 10;
	
	/**
	 * Configure and start the application.
	 * @param args not used
	 */
	public static void main( String[] args ) {
		// 1. create a Purse
		Purse purse = new Purse(CAPACITY);
		PurseObserver purseObserver = new PurseObserver();
		StatusObserver statusObserver = new StatusObserver();
		purse.setWithdrawStrategy(new RecursiveWithdraw());
		// 2. create a ConsoleDialog with a reference to the Purse object
		purse.addObserver(purseObserver);
		purse.addObserver(statusObserver);
		ConsoleDialog ui = new ConsoleDialog(purse);
		// 3. run the ConsoleDialog
		purseObserver.run();
		statusObserver.run();
		ui.run();
		
		/*MoneyFactory factory = MoneyFactory.getinstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney(1);
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney(2);
		System.out.println(m3.toString());*/
	}
}
