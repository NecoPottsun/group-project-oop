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
	
		ListOfAccount listofacc = new ListOfAccount();
	
		Account a1 = new Account("NecoPotts", 1500);
		Account a2 = new Account("Duyen",1500);
		MoneyAmount ma1 = new MoneyAmount(a1);
		MoneyAmount ma2 = new MoneyAmount(a2);
		
		listofacc.add(a1,ma1);
		listofacc.add(a2,ma2);
		
		things t = new things(listofacc,list);
	//	list.DisplayPos();
	//	System.out.println(t1.getListoflands().getListofs().getList().get(4).toString());
//		ListOfStation listofs = new ListOfStation();
//		ListOfEstate listofe = new ListOfEstate();

		list.DisplayPos();
		
//		System.out.println(t.Buy(ma1, 16));
//		System.out.println(t.Buy(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		System.out.println(t.UpgradeHouse(ma1, 5));
//		
//		System.out.println(t.PayRent(ma2, 5));
//		System.out.println(ma2.getMoney());
//		System.out.println(t.doAction(ma2, 0));
		
		Dices d = new Dices();
		DicesSystem ds = new DicesSystem(d,ma1,list);
		System.out.println(ds.RollTurn());
		System.out.println(list.getList().get(8).getName());
	
	//	list.getListofu().Display();
		//System.out.println(list.getListofu().getUltility(8));
		
	}

}
