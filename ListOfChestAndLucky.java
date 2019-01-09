package monopoly;
import java.util.*;
public class ListOfChestAndLucky {
	private ArrayList<CALCards> listofcal = new ArrayList<CALCards>();
	private CALCards c1,c2,c3,c4;
	public ListOfChestAndLucky(){
//		Community Chest And Lucky 
		c1 = new CALCards("Lucky",2);
		c2 = new CALCards("Community Chest",10);
		c3 = new CALCards("Lucky",14);
		c4 = new CALCards("Community Chest",21);
		
		listofcal.add(c1);
		listofcal.add(c2);
		listofcal.add(c3);
		listofcal.add(c4);
		Sorting();
	}
	public ArrayList<CALCards> getList(){
		return listofcal;
	}
	public void remove(CALCards c){
		if(listofcal.contains(c)){
			listofcal.remove(c);
		}
		else{
			System.out.println("It's not in the list.");
		}

	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listofcal);
	}
	public void Display(){
		for(int i = 0 ; i < listofcal.size() ; i ++){
			System.out.println(listofcal.get(i));
		}
	}
	// get the chest community or lucky by position
	public CALCards getCAL(int x){
		for(int i = 0 ; i < listofcal.size(); i ++){
			int pos = listofcal.get(i).getPosition();
			if(pos == x){
				return listofcal.get(i);
			}
			
		}
		return null;
	}
}
