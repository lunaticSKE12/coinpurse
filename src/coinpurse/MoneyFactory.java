package coinpurse;

abstract public class MoneyFactory {
	
	private static MoneyFactory factory = null;
	
	public static MoneyFactory getinstance(){
		if(factory == null){
			factory = new ThaiMoneyFactory();
		}
		return factory;
		
	}
	
	public Valuable createMoney(double value){
		try{
			return createMoney(value);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException();
		}
	}
	
	public static Valuable createMoney(String value){
		double price = Double.parseDouble(value);
		try{
			return createMoney(value);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException();
		}
	}

}
