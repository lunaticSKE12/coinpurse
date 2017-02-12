package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Napong Dungduangsasitorn
 */
public class Purse {

	/** Collection of objects in the purse. */
	private ArrayList<Coin> money = new ArrayList<Coin>();

	/** Capacity is maximum number of coins the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse.
	 * This is the number of coins, not their value.
	 * @return the number of coins in the purse
	 */
	public int count() { 
		return this.money.size(); 
	}

	/** 
	 *  Get the total value of all items in the purse.
	 *  @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for(int i = 0 ; i < money.size() ; i++){
			balance += money.get(i).getValue();
		}

		return balance; 
	}

	/**
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */

	public int getCapacity() { return this.capacity; }

	/** 
	 *  Test whether the purse is full.
	 *  The purse is full if number of items in purse equals
	 *  or greater than the purse capacity.
	 *  @return true if purse is full.
	 */
	public boolean isFull() {
		if(count() >= getCapacity())
			return true;
		return false;
	}

	/** 
	 * Insert a coin into the purse.
	 * The coin is only inserted if the purse has space for it
	 * and the coin has positive value.  No worthless coins!
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert( Coin coin ) {
		// if the purse is already full then can't insert anything.
		if(!isFull() && coin.getValue() <= 0){
			return false;
		}
		money.add(coin);
		return true;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of Coins withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Coin[] withdraw( double amount ) {

		/*
		 * See lab sheet for outline of a solution, 
		 * or devise your own solution.
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		if ( amount <= 0 )
		{	// failed. Don't change the contents of the purse.
			return null;
		}

		Collections.sort(money);
		if( amount > 0){
			ArrayList<Coin> temp1 = (ArrayList<Coin>) money.clone();
			Collections.sort(temp1);
			ArrayList<Coin> temp2 = new ArrayList<Coin>();
			for(int i = temp1.size()-1 ; i >= 0 ; i--){
				if(temp1.get(i).getValue() <= amount){
					amount -= temp1.get(i).getValue();
					temp2.add(temp1.get(i));
				}
			}

			if(amount != 0){
				return null;
			}

			for(int i = 0 ; i < temp2.size() ; i++){
				for(int j = 0 ; j< money.size() ; j++){
					if(temp2.get(i).equals(money.get(j))){
						money.remove(j);
						break;
					}
				}
			}
			Coin[] arrayCoin = new Coin[temp2.size()];
			temp2.toArray(arrayCoin);

			return arrayCoin;
		}

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return null; 
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		return String.format("%d coins with value %.1f", this.count(), this.getBalance());
	}

}