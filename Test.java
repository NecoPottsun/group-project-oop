package Monopoly.system;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

	//	System.out.println(e1);
		
		ListOfLands list = new ListOfLands();


//		list.Sorting();
		Account a1 = new Account("NecoPotts",1600,0);
		Account a2 = new Account("Duyen",1600,0);
		MoneyAmount m1 = new MoneyAmount(a1);
		MoneyAmount m2 = new MoneyAmount(a2);
//		CALCards callist = new CALCards(3);
//		
//		m1.ChestAndLucky(callist.random());
		
	//	System.out.println(m1.getFreeJailCard());

//		System.out.println(list.Size());
		Dices d = new Dices();
		DicesSystem ds1 = new DicesSystem(d,m1,list);
		DicesSystem ds2 = new DicesSystem(d,m2,list);
//		for(int i = 0 ; i < 5; i++){
//			ds.action();
//		}
		ListOfAccount listofacc = new ListOfAccount();
		listofacc.Add(a1, m1);
		listofacc.Add(a2, m2);
//		Jail jail = new Jail(24);
//		jail.getJail(m1);
//		ds2.RollTurn();
//		listofacc.checklistTurn();
//		ds2.RollTurn();
//		jail.getOutJail(m1);
//		ds1.RollTurn();
//		ds1.RollTurn();
		Estate l1 = (Estate) list.Search("bitexco");
		m1.Buy(l1);
		m1.UpgradeHouse(l1);
		m1.UpgradeHouse(l1);
		m1.UpgradeHouse(l1);
		m1.UpgradeHouse(l1);
		m1.UpgradeHouse(l1);
		System.out.println(m1.DisplayList());
	}

}
