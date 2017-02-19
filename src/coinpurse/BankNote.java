package coinpurse;

/**
 * 
 * @author Napong Dungduangsasitorn
 *
 */
public class BankNote implements Valuable{

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	
	BankNote( double value ){
		this.value = value;
		this.serialNumber = nextSerialNumber++;
		
	}
	
	BankNote( double value , String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
		
	}
	
	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	public long getSerial(){
		return this.serialNumber;
	}
	
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
	
	public String toString(){
		return this.value + "-" + this.currency + " note [ " + this.serialNumber + " ]";
	}

}
