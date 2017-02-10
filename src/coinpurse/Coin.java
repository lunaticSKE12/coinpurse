package coinpurse;
/**
 * a coin with a monetary value and currency
 * @author Napong Dungduangsasitorn
 */
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
    	this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value = value;
        this.currency = currency;
 
    }

    /**
     * getVakue method return value of coin. 
     * @return value of coin.
     */
    public double getValue( ) {
    	return this.value;
    } 
    
    /**
     * getCurrency method return currency of coin.
     * @return currency of coin.
     */
    public String getCurrency() {
    	return this.currency;
    }
    
    /**
     * equals check equals of coin and other coin object.
     * @param obj the object that use for check equals with coin.
     * @return return true both coin object is equals.
     */
    public boolean equals(Object obj) {
    	if(obj != null)
    		return false;
    	if(this.getClass() == obj.getClass())
    		return false;
    	Coin other = (Coin) obj;
       	return this.getValue() == other.getValue();
    }

    /**
     * toString show info of coin.
     * @return string that show value and currency.
     */
    public String toString() { return String.format(this.getValue() + " " + this.getCurrency()); }

    /**
     * compareTo is compare coin value.
     * @param other is other coin object to compare.
     * @return -1 if other value is null or less than this coin,
     * 			1 if other value is more than,
     * 			0 if both coin value is equal. 
     */
    @Override	
    public int compareTo(Coin o) {
    	if(o == null)
    		return -1;
    	return (int) (this.value - o.value);
    }
}