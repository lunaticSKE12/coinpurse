package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *  A coin purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  money to remove.
 *  
 *  @author Napong Dungduangsasitorn
 */
public class Purse {

	/**
	 *List of object in purse
	 */
	private List<Valuable> money;
	
	/** Capacity is maximum number of money the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of money you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(capacity);
	}

	/**
	 * Count and return the number of money in the purse.
	 * This is the number of money, not their value.
	 * @return the number of money in the purse
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
	 * Insert a value into the purse.
	 * The value is only inserted if the purse has space for it
	 * and the value has positive value.  No worthless money!
	 * @param value is a Valuable object to insert into purse
	 * @return true if value inserted, false if can't insert
	 */
	public boolean insert( Valuable value ) {
		// if the purse is already full then can't insert anything.
		if(isFull() && value.getValue() <= 0){
			return false;
		}
		money.add(value);
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
	public Valuable[] withdraw( double amount ) {

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

		List<Valuable> temp = new ArrayList<Valuable>();
		if( amount > 0){
			for(int i = money.size()-1 ; i >= 0 ; i--){
				if(money.get(i).getValue() <= amount){
					amount -= money.get(i).getValue();
					temp.add(money.get(i));
				}
			}
		}
		if(amount == 0){
			for(Valuable value : temp){
				
				this.money.remove(value);
			}
			Valuable[] arrayMoney = new Valuable[temp.size()];
			temp.toArray(arrayMoney);

			return arrayMoney;
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