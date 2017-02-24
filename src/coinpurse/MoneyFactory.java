package coinpurse;

abstract public class MoneyFactory {
	
	private static MoneyFactory factory = null;
	
	public static MoneyFactory getinstance(){
		if(factory == null){
			factory = new MoneyFactory();
		}
		return factory;
		
	}
	
	public abstract Valuable createMoney(double value){
		
	}
	
	public Valuable createMoney(String value){
		
	}

}
