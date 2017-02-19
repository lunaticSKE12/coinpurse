package coinpurse;

/**
 * Banknote with a monetary value and currency
 *  
 * @author Napong Dungduangsasitorn
 *
 */
public class BankNote implements Valuable{


	private static long nextSerialNumber = 1000000;
	//value of banknote
	private double value;
	//currency of banknote
	private String currency;
	//serial number of banknote.
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * @param value is value of banknote.
	 */
	BankNote( double value ){
		this.value = value;
		this.serialNumber = nextSerialNumber++;

	}

	/**
	 * A banknote with given value and currency.
	 * @param value is value of banknote.
	 * @param currencyis currency of banknote.
	 */
	BankNote( double value , String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;

	}

	/**
	 * getVakue method return value of banknote. 
	 * @return value of banknote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * getCurrency method return currency of banknote.
	 * @return currency of banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * getSerial is return serial of banknote
	 * @return serial number of banknote
	 */
	public long getSerial(){
		return this.serialNumber;
	}

	/**
     * equals check equals of banknote and other banknote object.
     * @param obj the object that use for check equals with banknote.
     * @return return true both banknote object is equals.
     */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj.getClass() != this.getClass()){
			return false;
		}
		BankNote other = (BankNote) obj;

		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());

	}

	/**
     * toString show info of banknote.
     * @return string that show value, currency and serial number.
	 */
	public String toString(){
		return this.value + "-" + this.currency + " note [ " + this.serialNumber + " ]";
	}

}
