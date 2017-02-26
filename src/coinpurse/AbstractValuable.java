package coinpurse;

/**
 * AbstractValuable is super class of Coin and BankNote for eliminate duplicate cose
 * @author Napong Dungduangsasitorn
 *
 */
abstract public class AbstractValuable implements Valuable{

	// default currency
	public static final String DEFAULT_CURRENCY = "Baht";
	// value of coin and banknote
	private double value;
	// currency of coin and banknote
	private String currency;

	/**
	 * AbstractValuable is Valuable to create initialize value and currency. 
	 * @param value is value of coin or banknote.
	 * @param currency is currency of coin or banknote.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * equals check equals of Valuable and other Valuable object.
	 * @param obj the object that use for check equals with Valuable.
	 * @return return true both Valuable object is equals.
	 */
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Valuable other = (Valuable) obj;

		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}

	/**
	 * getValue method return value of coin or banknote. 
	 * @return value of coin or banknote.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * getCurrency method return currency of coin or banknote.
	 * @return currency of coin or banknote.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * compareTo is compare currency and value.
	 * @param o is Valuable that want to compare.
	 * @return positive if more than, 
	 * 		   negative if less than, 
	 * 		   zero if equal.
	 */
	public int compareTo(Valuable o) {
		if(o == null)
			return -1;

		if(this.getCurrency().equalsIgnoreCase(o.getCurrency())){
			return (int) (this.getValue() - o.getValue());
		}

		return -1;
	}

}