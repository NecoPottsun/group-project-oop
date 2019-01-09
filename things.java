package monopoly;
import java.util.*;
public class things {
	private Account a;
	private MoneyAmount ma;
	private ListOfLands listoflands;
	private ListOfAccount listofa;
	private DicesSystem ds;
	public things(ListOfAccount listofa,ListOfLands listoflands){
		this.listofa = listofa;
		this.listoflands = listoflands;
	}
	public ListOfLands getListoflands() {
		return listoflands;
	}
	public ListOfAccount getListofa() {
		return listofa;
	}
	
	public int check(int x){
//		for(int i = 0; i < listoflands.getList().size() ; i++){
//			if(x == listoflands.getListofe().getList().get(i).getPosition()){
//				return 1;
//			}
//			else if( x == listoflands.getListofs().getList().get(i).getPosition()){
//				return 2;
//			}
//			else if (x == listoflands.getListofu().getList().get(i).getPosition()){
//				return 3;
//			}
//			else if(x == listoflands.getListofol().getList().get(i).getPosition()){
//				return 4;
//			}
//			else if(x == listoflands.getListofc().getList().get(i).getPosition()){
//				return 5;
//			}
//			else if(x == listoflands.getJail().getPosition()){
//				return 6;
//			}
//		}
//		return 0;
		for(int i = 0; i < listoflands.getListofe().getList().size();i++){
			if(x == listoflands.getListofe().getList().get(i).getPosition()){
				return 1;
			}
		}
		for(int i = 0; i < listoflands.getListofs().getList().size();i++){
			if(x == listoflands.getListofs().getList().get(i).getPosition()){
				return 2;
			}
		}
		for(int i = 0; i < listoflands.getListofu().getList().size();i++){
			if(x == listoflands.getListofu().getList().get(i).getPosition()){
				return 3;
			}
		}
		for(int i = 0; i < listoflands.getListofol().getList().size();i++){
			if(x == listoflands.getListofol().getList().get(i).getPosition()){
				return 4;
			}
		}
		for(int i = 0; i < listoflands.getListofc().getList().size();i++){
			if(x == listoflands.getListofc().getList().get(i).getPosition()){
				return 5;
			}
		}
		if( x == listoflands.getJail().getPosition()){
			return 6;
		}
		return 0;
	
	
	
	}
	public String Buy(MoneyAmount ma ,int x){
		int a = check(x);
		if(a == 1){
			return ma.Buy(listoflands.getListofe().getEstate(x));
		}
		else if (a == 2){
			return ma.Buy(listoflands.getListofs().getStation(x));
		}
		else if (a == 3){
			return ma.Buy(listoflands.getListofu().getUltility(x));
		}
		return null;
	}
	public String Mortgage(MoneyAmount ma,int x){
		int a = check(x);
		if(a == 1){
			return ma.Mortgage(listoflands.getListofe().getEstate(x));
		}
		else if (a == 2){
			return ma.Mortgage(listoflands.getListofs().getStation(x));
		}
		else if (a == 3){
			return ma.Mortgage(listoflands.getListofu().getUltility(x));
		}
		return null;
	}
	public MoneyAmount CheckOwner(int x){
		for(int i = 0; i < listofa.getListofmm().size(); i ++){
			MoneyAmount ma = listofa.getListofmm().get(i);
			if(ma.getOwningList().contains(listoflands.getList().get(x))){
				return ma;
			}
		
		}
		return null;
	}
	
	public String PayRent(MoneyAmount ma,int x){
		int a = check(x);
		MoneyAmount ma1 = CheckOwner(x);
		if(a==1){
			return ma.PayRent(ma1,listoflands.getListofe().getEstate(x));
		}
		if(a==2){
			return ma.PayRent(ma1,listoflands.getListofs().getStation(x));
		}
		if(a==3){
			return ma.PayRent(ma1,listoflands.getListofu().getUltility(x));
		}
		return null;
	}
	public String UpgradeHouse(MoneyAmount ma, int x){
		int a = check(x);
		if(a==1){
			return ma.UpgradeHouse(listoflands.getListofe().getEstate(x));
		}
		return null;
	}
	public String doAction(MoneyAmount ma ,int x){
		int a = check(x);
		if(a==4){
			return ma.doAction(listoflands.getListofol().getOL(x));
		}
		return null;
	}
	public String ChestAndLucky(MoneyAmount ma ,int x){
		int a = check(x);
		if(a==5){
			return ma.ChestAndLucky(listoflands.getListofc().getCAL(x));
		}
		return null;
	}
	public String PayJail(MoneyAmount ma,int x){
		int a = check(x);
		if(a==6){
			return ma.JailFee();
		}
		return null;
	}
	
	// the Lands' actions
	public void canDo(MoneyAmount ma){
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < listoflands.getList().size() ; i++){
			int x = listoflands.getList().get(i).getPosition();
			int a = check(x);
			if(a==1 || a == 2 || a == 3){
				System.out.println(String.format("---%s---\n1.Buy\t2.Mortgage",listoflands.getLands(x).getName()));
				int c = sc.nextInt();
				switch (c){
				case 1:
					System.out.print(Buy(ma,x));
					break;
				}
				case2:
					System.out.print(Mortgage(ma,x));
					break;
				
			}
		}
	}
}
