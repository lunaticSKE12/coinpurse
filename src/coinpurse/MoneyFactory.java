package coinpurse;

import java.util.ResourceBundle;

/**
 * MoneyFactory is main factory to choose witch country money and create.
 * @author Napong Dungduangsasitorn
 *
 */
abstract public class MoneyFactory {
	
	// factory use to create MoneyFactory.
	private static MoneyFactory factory = null;
	
	/**
	 * getInstance is instance of MoneyFactory.
	 * @return factory of Thai or Malay MoneyFactory.
	 */
	public static MoneyFactory getInstance(){
		if(factory == null){
			setMoneyFactory();
			//factory = new ThaiMoneyFactory();
		}
		return factory;
	}
	
	/**
	 * createMoney is create money which input value double type.
	 * @param value is value of money which double type.
	 * @return Valuable object
	 * @throws IllegalAccessException if value is invalid.
	 */
	abstract public Valuable createMoney(double value) throws IllegalAccessException;

	/**
	 * createMoney is create money which input value String type. 
	 * @param value is value of money which String type.
	 * @return createMoney is Valuable that prase String to double.
	 * @throws IllegalAccessException
	 */
	public Valuable createMoney(String value)throws IllegalAccessException{
		double money = Double.parseDouble(value);
		return createMoney(money);
	}
	
	static void setMoneyFactory(){
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory instance = null;
		try{
			instance = (MoneyFactory) Class.forName(factoryclass).newInstance();
		}catch(ClassCastException cce){
			//the object could not be cast to type MoneyFactory.
			System.out.println(cce.getMessage() + " is not type MoneyFactory");
		}catch(Exception ex){
			//any other exception means we could not create an object.
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		//if no factory then quit.
		if(instance == null){
			System.exit(1);
		}
	}
}
