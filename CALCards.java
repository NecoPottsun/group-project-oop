package Monopoly.system;
import java.util.*;
public class CALCards extends Lands{
	ArrayList<ChestAndLucky> list = new ArrayList<ChestAndLucky>();
	Random rand = new Random();
	
	public CALCards(int pos){
		this.position = pos;
		
		ChestAndLucky cal1 = new ChestAndLucky("Receive 50$ consultancy fee. Receive for services 50$." , 50);
		ChestAndLucky cal2 = new ChestAndLucky("Get out of Jail free.",1);
		ChestAndLucky cal3 = new ChestAndLucky("You have won second prize in a beauty contest. Collect 150$.", 150);
		ChestAndLucky cal4 = new ChestAndLucky("Bank error in your favor. Collect $200", 200);
		ChestAndLucky cal5 = new ChestAndLucky("You inherit $100.", 100);
		ChestAndLucky cal6 = new ChestAndLucky("From sale of stock you get $50.", 50);
		ChestAndLucky cal7 = new ChestAndLucky("Holiday Xmas Fund matures. Receive Collect $100", 100);
		ChestAndLucky cal8 = new ChestAndLucky("Doctor's fees. Pay 200$", 200);
		ChestAndLucky cal9 = new ChestAndLucky("School fees. Pay $100", 100);
		ChestAndLucky cal10 = new ChestAndLucky("Hospital Fees. Pay $100.", 100);
		
		list.add(cal1);
		list.add(cal2);
		list.add(cal3);
		list.add(cal4);
		list.add(cal5);
		list.add(cal6);
		list.add(cal7);
		list.add(cal8);
		list.add(cal9);
		list.add(cal10);
		
	}
	public void Add(ChestAndLucky cal){
		list.add(cal);
	}
	public void Remove(ChestAndLucky cal){
		if(list.contains(cal)){
			list.remove(cal);
		}

	}
	public String Display(){
		for(int i = 0 ; i < list.size(); i++){
			ChestAndLucky cal = list.get(i);
			return String.format("%d\t%s",(i+1),cal.getName());
		}
		return null;
	}
	public ChestAndLucky Random(){
		// get random number
		int n = rand.nextInt(list.size());
		return list.get(n);
	}
}
