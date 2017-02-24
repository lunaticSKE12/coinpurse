package coinpurse;

abstract public class AbstractValuable implements Valuable{
	
	private double value;
	private String currency;
	

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * equals check equals of coin and other coin object.
	 * @param obj the object that use for check equals with coin.
	 * @return return true both coin object is equals.
	 */
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
	   	
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}

	public double getValue() {
		return this.value;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public int compareTo(Valuable o) {
		if (this.getValue() > o.getValue())
			return 1;

		if (this.getValue() < o.getValue())
			return -1;

		return 0;
	}
	
}