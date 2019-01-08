package Monopoly.system;
import java.util.ArrayList;


public class MoneyAmount implements Comparable<MoneyAmount>{
	private Account a;
	private int debt = 0;
	private int Money;
	private int totalMoney;
	private static int NoOwnStation = 0;
	private static int NoOwnUltility = 0;
	private int FreeJailCard = 0;
	private int turn = 0;
	private int position;
	private boolean isonJail = false;
	private ArrayList<Property> OwningList = new ArrayList<Property>();
	public MoneyAmount(Account a){
		this.a = a;
		Money = a.getMoney();
		totalMoney = a.getMoney();
	//	Display(a);
	}
	public String getName(){
		return a.getName();
	}
	public ArrayList<Property> getOwningList() {
		return OwningList;
	}

	public void setOwningList(ArrayList<Property> owningList) {
		OwningList = owningList;
	}


	public int getDebt() {
		return debt;
	}

	public int getMoney() {
		return Money;
	}
	public int gettotalMoney(){
		return totalMoney;
	}
	public static int getNoOwnStation() {
		return NoOwnStation;
	}

	public static int getNoOwnUltility() {
		return NoOwnUltility;
	}
	public int getFreeJailCard(){
		return FreeJailCard;
	}
	public int getTurn(){
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getPosition() {
		return position;
	}
	public boolean getisonJail() {
		return isonJail;
	}
	public void setIsonJail(boolean isonJail) {
		this.isonJail = isonJail;
	}
	public void setPosition(int position){
		this.position = position;
	}
	public String Buy(Estate e){
		// check if it is available 
		int c = checkAvailable(e);
		try{
		if(c == 1){
			// do the buy function
			Money -= e.BuyPrice();
			totalMoney -= e.BuyPrice();
//			System.out.println(String.format("---> %s just bought %s with %d$",a.getName(),e.getName(),e.GetPrice()));
			Display();
			// Add to the owning list 
			OwningList.add(e);
			e.Available = 0;
			return String.format("---> %s just bought %s with %d$",a.getName(),e.getName(),e.GetPrice());
		}
		else if(c == 0){
//			System.out.println(String.format("---> %s cant buy %s",a.getName(),e.getName()));
			return String.format("---> %s cant buy %s",a.getName(),e.getName());
		}
		turn = 1;
		}catch(Exception ex){
//			System.out.println(String.format("Error %s . Can't buy",ex));
			return String.format("Error %s . Can't buy",ex);
		}
		return "Can't buy";
	}
	public String Buy(Station s){
		// check available
		int c = checkAvailable(s);
		try{
		if(c == 1){
			//increase the number of stations that are owned of this account 
			++NoOwnStation;
		//	a.x = x;
			// Do the subtract
			Money -= - s.BuyPrice();
			totalMoney -= s.BuyPrice();
//			System.out.println(String.format("---> %s just bought %s with %d$",a.getName(),s.getName(),s.BuyPrice()));
			Display();
			// add to the owning list
			OwningList.add(s);
			s.Available = 0;
			turn = 1;
			return String.format("---> %s just bought %s with %d$",a.getName(),s.getName(),s.BuyPrice());
			}
		else{
	//		System.out.println(String.format("---> %s cant buy %s",a.getName(),s.getName()));
			turn = 1;
			return String.format("---> %s cant buy %s",a.getName(),s.getName());
			}
		}catch(Exception e){
//			System.out.println(String.format("Error %s.Can't Buy",e));
			turn = 1;
			return String.format("Error %s.Can't Buy",e);
		}	
	}
	public String Buy(Ultility u){
		int c = checkAvailable(u);
		try{
			if(c == 1){
				// increase the number of owning ultility
				++NoOwnUltility;
			//	a.y = y;
				// do the subtract
				Money = Money - u.BuyPrice();
				totalMoney -= u.BuyPrice();
				//System.out.println(String.format("---> %s just bought %s with %d$",a.getName(),u.getName(),u.BuyPrice()));
				Display();
				// add to the list
				OwningList.add(u);
				u.Available = 0;
				turn = 1;
				return String.format("---> %s just bought %s with %d$",a.getName(),u.getName(),u.BuyPrice());
				}
			else{
				//System.out.println(String.format("---> %s cant buy %s",a.getName(),u.getName()));
				turn = 1;
				return String.format("---> %s cant buy %s",a.getName(),u.getName());
				}

			}catch(Exception e){
	//			System.out.println(String.format("Error %s.Can't Buy",e));
				turn = 1;
				return String.format("Error %s.Can't Buy",e);
			}
	}
	public String Mortgage(Property e){
		int c = checkAvailable(e);
		try{
		if(c == 0){
			Money += e.Mortage();
			// increase the debt
			debt -= e.TakeOutMortage();
			totalMoney += e.TakeOutMortage() - e.Mortage();
		//	System.out.println(String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),e.getName(),e.Mortage(),e.TakeOutMortage()));
			Display();
			turn = 1;
			return String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),e.getName(),e.Mortage(),e.TakeOutMortage());
			}
		else if(c == 1){
		//	System.out.println(String.format("--->%s can't sell %s to the bank",a.getName(),e.toString(),e.Mortage()));
			turn = 1;
			return String.format("--->%s can't sell %s to the bank",a.getName(),e.toString(),e.Mortage());
		}
		turn = 1;
		} catch(Exception ex){
			//System.out.println(String.format("Error %s.Can't sell to the bank",ex));
			return String.format("Error %s.Can't sell to the bank",ex);
		}
		return "Can't sell to the bank";
		
	}
//	public String Mortgage(Station s){
//		int c = checkAvailable(s);
//		try{
//		if(c == 0){
//			// decrease the own station to decrease the rent price
//			--NoOwnStation;
//			Money += s.Mortage();
//			debt -= s.TakeOutMortage();
//			totalMoney += s.TakeOutMortage() - s.Mortage();
//			//System.out.println(String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),s.toString(),s.Mortage(),s.TakeOutMortage()));
//			Display();
//			turn = 1;
//			return String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),s.toString(),s.Mortage(),s.TakeOutMortage());
//		}
//		else{
//		//	System.out.println(String.format("--->%s can't sell %s to the bank ",a.getName(),s.toString()));
//			turn = 1;
//			return String.format("--->%s can't sell %s to the bank ",a.getName(),s.toString());
//		}
//	//	turn = 1;
//		}catch(Exception ex){
//			//System.out.println(String.format("Error %s.Can't sell",ex));
//			return String.format("Error %s.Can't sell",ex);
//		}
//		
//	}
//	public String Mortgage(Ultility u){
//		int c = checkAvailable(u);
//		try{
//			if(c == 0){
//				--NoOwnUltility;
//				Money = Money + u.Mortage();
//				debt -= u.TakeOutMortage();
//				totalMoney += u.TakeOutMortage() - u.Mortage();
//			//	System.out.println(String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),u.getName(),u.Mortage(),u.TakeOutMortage()));
//			//	System.out.println("a  " + NoOwnStation + " b  " + x);
//				Display();
//				turn = 1;
//				return String.format("--->%s just sell %s to the bank with %d$. Can take it out with %d$",a.getName(),u.getName(),u.Mortage(),u.TakeOutMortage());
//				}
//			else{
//			//	System.out.println(String.format("--->%s just sell %s to the bank",a.getName(),u.getName()));
//				turn = 1;
//				return String.format("--->%s just sell %s to the bank",a.getName(),u.getName());
//				
//				}
//		} catch(Exception e){
//		//	System.out.println(String.format("Error %s.Can't sell",e));
//			return String.format("Error %s.Can't sell",e);
//		}
//		
//	}
	public void PayRent(MoneyAmount b,Estate l){
		int c = checkAvailable(l);
		if(c == 0){
			// check if this list doesnt have that estate
			if(OwningList.contains(l) != true && b.OwningList.contains(l)){
				int x = l.RentHousePrice();
				// sub money of this account
				Money -= x;
				totalMoney -= x;
				// add money of another account
				b.Money += x;
				b.totalMoney += x;
				System.out.println(String.format("%s is standing in %s have to pay rent for %s with %d$",a.getName(),l.getName(),b.toString(),x));
				Display();
				b.Display();
			}
			else{
				System.out.println(String.format("%s is owning this, don't have to pay rent", a.getName()));
			}
			turn = 1;
		}
		else{
			System.out.println("Noone owns this, don't have to pay rent");
		}
	}
	public void PayRent(MoneyAmount b,Station s){
		int c = checkAvailable(s);
		if(c == 0){
			if(OwningList.contains(s) == false && b.OwningList.contains(s)){
				int x = s.RentValue(b);
				Money -= x;
				totalMoney -= x;
				b.Money += x;
				b.totalMoney += x;
				System.out.println(String.format("%s has %d stations, %s is standing in %s have to pay rent for %s with %d$",b.toString(),b.NoOwnStation,a.getName(),s.toString(),b.toString(),x));
				Display();
				b.Display();
				
			}
			else{
				System.out.println(String.format("%s is owning this, don't have to pay rent", a.getName()));
			}
			turn = 1;
		}
		else{
			System.out.println("Noone owns this, don't have to pay rent");
		}
				
	}
	public void PayRent(MoneyAmount b ,Ultility u){
		int c = checkAvailable(u);
		if(c == 0){
			if(OwningList.contains(u) != true && b.OwningList.contains(u)){
				int x = u.RentValue(b);
				Money -= x;
				totalMoney -= x;
				b.Money += x;
				b.totalMoney += x;
				
				System.out.println(String.format("%s has %d ultilities, %s is standing in %s have to pay rent for %s with %d$",b.toString(),b.NoOwnUltility,a.getName(),u.getName(),b.toString(),x));
				Display();
				b.Display();
			}
			else{
				System.out.println(String.format("%s is owning this, don't have to pay rent", a.getName()));
			}
			turn = 1;
		}
		else{
			System.out.println("Noone owns this, don't have to pay rent");
		}
				
	}
	public void UpgradeHouse(Estate l){
		// check the level of the house
		if(l.checklevel() < 5){
			if(OwningList.contains(l)){
				l.checklevel();
				Money = Money - l.getHousePrice();
				totalMoney -= l.getHousePrice();
				l.setLevel(l.getLevel()+1);
				System.out.println(String.format("--->%s just upgrade house for %s with %d$\n\t%s is now level %d, rent price =%d$",a.getName(),l.getName(),l.getHousePrice(),l.getName(),l.checklevel(),l.RentHousePrice()));
				// build hotel
				if(l.checklevel() == 5){
						l.setLevel(l.getLevel()+1);
						System.out.println(String.format("--->%s has a Hotel now",l.getName()));

					
				}
				Display();
			}
			else{
				System.out.println(String.format("%s is not belong to %s", l.getName() , a.getName()));
			}
			turn = 1;
		}
		
		
		else {
			l.checklevel();
			System.out.println(String.format("Cannot upgrade %s more",l.getName()));
		}
	}
	public void PayMortgage(Property p){
		if(OwningList.contains(p)){
			Money -= p.TakeOutMortage();
			debt += p.TakeOutMortage();
			totalMoney -= p.TakeOutMortage() - p.Mortage();
			System.out.println(String.format("--->%s just take back his/her %s from the bank with %d$",a.getName(),p.getName(),p.TakeOutMortage()));
			Display();
		}
		else{
			System.out.println(String.format("--->%s is not belong to %s",p.getName(),a.getName()));
		}
		turn = 1;
	}
	public int checkAvailable(Property p){
		if(p.Available == 0 ){
			return 0;
		}
		if(p.Available == 1){
			return 1;
		}
		return 0;
		
	}
	public String Display(){
	//	System.out.println(String.format("Account: %s\tCurrent Money= %d$\tDebt= %d$", a.getName(),Money,debt));
		return String.format("Account: %s\tCurrent Money= %d$\tDebt= %d$", a.getName(),Money,debt);
	}
	public String DisplayList(){
		System.out.printf("----------%s----------\n",a.getName());
		for(int i = 0; i < OwningList.size();i++){
		//	System.out.println(OwningList.get(i)); 
			Property p = OwningList.get(i);
			
			return p.toString();
		}
		return "nothing in the list";
	}
	public String  JailFee(){
		// pay the fee jail with 500
		Money -= 500;
		totalMoney -= 500;
	//	System.out.println(String.format("%s just paid the jail fee with 500$",a.getName()));
		
	//	Display();
		turn = 0;
		return String.format("%s just paid the jail fee with 500$",a.getName());
	}

	public String doAction(OtherLands l){
		// doing for other lands, ex: GO,tax,...
		Money += l.getvalue();
		totalMoney += l.getvalue();
		if(l.getvalue() > 0){
		//	System.out.println(String.format("%s is standing on %s receive %d$",a.getName(),l.getName(),l.getvalue()));
		//	Display();
			turn = 1;
			return String.format("%s is standing on %s receive %d$",a.getName(),l.getName(),l.getvalue());
		}
		else{
			//System.out.println(String.format("%s is standing on %s pay %d$",a.getName(),l.getName(),l.getvalue()));
			//Display();
			turn = 1;
			return String.format("%s is standing on %s pay %d$",a.getName(),l.getName(),l.getvalue());
		}
	
	//	turn = 1;
	}
	public String ChestAndLucky(ChestAndLucky cal){
		// receive a lucky or community chest card
		System.out.println(String.format("%s just received %s", a.getName() , cal.getName()));
	//	return String.format("%s just received %s", a.getName() , cal.getName());
		// receive the free jail card
		if(cal.getValue() == 1){
			FreeJailCard++;
		}
		else{
		
			Money += cal.getValue();
			totalMoney += cal.getValue();
		}
		turn = 1;
		return String.format("%s just received %s", a.getName() , cal.getName());
	}
	public int Bankrupt(){
		if(totalMoney < debt){
		//	System.out.println(String.format("%s is now bankrupt!!!!!",a.getName()));
			return 1;
		}
		return 0;
	}
	public String toString(){
		return String.format("%s\tCurrent Money = %d$\tTotal Money = %d$\tDebt = %d$",a.getName(),Money,totalMoney,debt);
	}
	@Override
	public int compareTo(MoneyAmount nextMA) {
		// TODO Auto-generated method stub
		//descending
		return nextMA.gettotalMoney()-totalMoney;
	}
}
