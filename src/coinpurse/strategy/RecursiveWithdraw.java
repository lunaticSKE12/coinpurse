package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		List<Valuable> list = new ArrayList<Valuable>();
		if(amount == 0){
			return list;
		}
		if(valuables.isEmpty()){
			return null;
		}
		list = withdraw(amount - valuables.get(0).getValue(), valuables.subList(1, valuables.size()));
		if(list != null){
			list.add(valuables.get(0));
			return list;
		}
		
		return withdraw(amount, valuables.subList(1, valuables.size()));
	}

}
