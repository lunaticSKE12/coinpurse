package coinpurse;

/**
 * Banknote with a monetary value and currency
 *  
 * @author Napong Dungduangsasitorn
 *
 */
public class BankNote extends AbstractValuable{

	private static long nextSerialNumber = 1000000;
	
	//serial number of banknote.
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * @param value is value of banknote.
	 */
	BankNote( double value ){
		super(value, DEFAULT_CURRENCY);
		this.serialNumber = nextSerialNumber++;

	}

	/**
	 * A banknote with given value and currency.
	 * @param value is value of banknote.
	 * @param currencyis currency of banknote.
	 */
	BankNote( double value , String currency){
		super(value, currency);
		this.serialNumber = nextSerialNumber++;

	}

	/**
	 * getSerial is return serial of banknote
	 * @return serial number of banknote
	 */
	public long getSerial(){
		return this.serialNumber;
	}

	/**
     * toString show info of banknote.
     * @return string that show value, currency and serial number.
	 */
	public String toString(){
		return this.getValue() + " " + this.getCurrency() + " note [ " + this.serialNumber + " ]";
	}

	

}
