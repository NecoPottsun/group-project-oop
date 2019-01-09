package monopoly;
import java.util.*;
public class ListOfStation {
	private Station s1,s2,s3,s4;
	private ArrayList<Station> listofstation = new ArrayList<Station>();
	public ListOfStation(){
//		Station's constructor name , position
		s1 = new Station("Ha Noi station", 4);
		s2 = new Station("Vinh station",9);
		s3 = new Station("Da Nang station",16);
		s4 = new Station("Sai Gon station",22);
		
		listofstation.add(s1);
		listofstation.add(s2);
		listofstation.add(s3);
		listofstation.add(s4);
		Sorting();
	}
	public ArrayList<Station> getList(){
		return listofstation;
	}
	public void remove(Station s){
		if(listofstation.contains(s)){
			listofstation.remove(s);
		}
		else{
			System.out.println("It's not in the list.");
		}

	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listofstation);
	}
	public void Display(){
		for(int i = 0; i < listofstation.size();i++){
			System.out.println(listofstation.get(i));
		}
	}
	
	// get the station by position
	public Station getStation(int x){
		for(int i = 0 ; i < listofstation.size(); i ++){
			int pos = listofstation.get(i).getPosition();
			if(pos == x){
				return listofstation.get(i);
			}
			
		}
		return null;
	}

}
