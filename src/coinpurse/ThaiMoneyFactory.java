package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	
	
	@Override
	public Valuable createMoney(double value) {
		if(value == 1)
			return new Coin(1);
		else if(value == 2)
			return new Coin(2);
		else if(value == 5)
			return new Coin(5);
		else if(value == 10)
			return new Coin(10);
		else if(value == 20)
			return new BankNote(20);
		else if(value == 50)
			return new BankNote(50);
		else if(value == 100)
			return new BankNote(100);
		else if(value == 500)
			return new BankNote(500);
		else if(value == 1000)
			return new BankNote(1000);
		return null;
	}
	
}