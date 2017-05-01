package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {

		double coin;
		List<Valuable> money = new ArrayList<Valuable>(valuables);
		List<Valuable> withdraw = new ArrayList<Valuable>();
		Valuable[] arr;
		if (amount > 0) {
			for (Valuable v : valuables) {
				if (v.getValue() <= amount) {
					coin = v.getValue();
					withdraw.add(v);
					money.remove(v);
					amount -= coin;
				}
			}
			if (amount == 0) {
				valuables = new ArrayList<Valuable>(money);
			}
			else{
				return null;
			}
			
		} else {
			return null;
		}
		for (int i = 0 ; i < valuables.size() ; i++) {
			System.out.println(valuables.get(i).getValue());
		}
		arr = new Valuable[withdraw.size()];
		return withdraw;
	}

}
