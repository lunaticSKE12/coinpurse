package coinpurse;

/**
 * MalayMoneyFactory is class for create Malaysia coin and bank note.
 * 
 * @author Napong Dungduangsasitorn
 *
 */
public class MalayMoneyFactory extends MoneyFactory{
	
	// currency of coin and bank note.
	public final String COIN_CURRENCY = "Sen";
	public final String BANKNOTE_CURRENCY = "Ringgit";

	/**
	 * createMoney is method for create coin and bank note.
	 * @param value is value of malaysia coin and bank note.
	 * @return coin or bank note of each value.
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5){
			return new Coin(value * 100, COIN_CURRENCY);
		}
		else if(value == 1 || value == 2 || value == 5 || value == 10 || 
				value == 20 || value == 50 || value == 100){
			return new BankNote(value, BANKNOTE_CURRENCY);
		}
			
		return null;
	}

}
