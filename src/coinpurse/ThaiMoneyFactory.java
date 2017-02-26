package coinpurse;

/**
 * ThaiMoneyFactory is class for create Thailand coin and bank note.
 * 
 * @author Napong Dungduangsasitorn
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{

	// currency of coin and bank note.
	public final String COIN_CURRENCY = "Satang";
	public final String DEFAULT_CURRENCY = "Baht";

	/**
	 * createMoney is method for create coin and bank note.
	 * @param value is value of Thailand coin and bank note.
	 * @return coin or bank note of each value.
	 */	
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.25 || value == 0.5){
			return new Coin(value * 100, COIN_CURRENCY);
		}
		else if(value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value, DEFAULT_CURRENCY);
		}
		else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value, DEFAULT_CURRENCY);
		}
		return null;
	}

}