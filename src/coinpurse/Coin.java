package coinpurse;
/**
 * a coin with a monetary value and currency
 * @author Napong Dungduangsasitorn
 */
public class Coin extends AbstractValuable{
	
	 public static final String DEFAULT_CURRENCY = "Baht";
    
    /**
     * A coin with given value using the default currency.
     * @param value is value of coin.
     */
    public Coin( double value ) {
    	super(value , DEFAULT_CURRENCY);
    }
    
    /**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currencyis currency of coin.
     */
    public Coin( double value, String currency ) {
    	super(value, currency);
 
    }

    /**
     * toString show info of coin.
     * @return string that show value and currency.
     */
    public String toString() { return String.format(this.getValue() + " " + this.getCurrency()) + " coin"; }



}