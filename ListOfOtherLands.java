package monopoly;
import java.util.*;
public class ListOfOtherLands {
	private ArrayList<OtherLands> listofol = new ArrayList<OtherLands>();
	private OtherLands o1,o2,o3,o4;
	public ListOfOtherLands(){
	
		
		//OtherLands' constructor (name,value,pos
		o1 = new OtherLands("GO",200,0);
		o2 = new OtherLands("Visiting Jail",0,6);
		o3 = new OtherLands("Parking", 0, 12);	
		o4 = new OtherLands("Income Tax", -200,3);
		
		listofol.add(o1);
		listofol.add(o2);
		listofol.add(o3);
		listofol.add(o4);
		
		
	}
	public ArrayList<OtherLands> getList(){
		return listofol;
	}
	public void add(OtherLands ol){
		listofol.add(ol);
	}
	public void remove(OtherLands ol){
		if(listofol.contains(ol)){
			listofol.remove(ol);
		}
		else{
			System.out.println("It's not in the list.");
		}

	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listofol);
	}
	// get other lands by position
	public OtherLands getOL(int x){
		for(int i = 0 ; i < listofol.size(); i ++){
			int pos = listofol.get(i).getPosition();
			if(pos == x){
				return listofol.get(i);
			}
			
		}
		return null;
	}
}
