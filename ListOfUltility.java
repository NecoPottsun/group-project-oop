package monopoly;
import java.util.*;
public class ListOfUltility {
	private ArrayList<Ultility> listofu = new ArrayList<Ultility>();
	private Ultility u1,u2;
	public ListOfUltility(){
		
		// Ultility's constructor (name ,pos)
		u1 = new Ultility("Water Factory",8);
		u2 = new Ultility("Electric Company",20);
		
		listofu.add(u1);
		listofu.add(u2);
		
		Sorting();
	}
	public ArrayList<Ultility> getList(){
		return listofu;
	}
	public void Display(){
		for(int i = 0 ; i< listofu.size() ; i++){
			System.out.println(listofu.get(i));
		}
	}
	public void add(Ultility u){
		listofu.add(u);
	}
	public void remove(Estate e){
		if(listofu.contains(e)){
			listofu.remove(e);
		}
		else{
			System.out.println("It's not in the list.");
		}

	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listofu);
		//DisplayLands();
	}
	
	//get ultility by position
	public Ultility getUltility(int x){
		for(int i = 0 ; i < listofu.size(); i ++){
			int pos = listofu.get(i).getPosition();
			if(pos == x){
				return listofu.get(i);
			}
			
		}
		return null;
	}

}
