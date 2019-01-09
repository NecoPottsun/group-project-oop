package monopoly;
import java.util.*;
public class ListOfEstate {
	private Estate e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
	private Color brown,skyblue,pink,orange,red,yellow,green,blue;
	private ArrayList<Estate> listofestate = new ArrayList<Estate>();
	public ListOfEstate(){
		brown = new Color("Brown",50);
		skyblue = new Color("Sky blue", 50);
		pink = new Color("Pink",100);
		orange = new Color("Orange", 100);
		red = new Color("Red",150);
		yellow = new Color("Yellow",150);
		green = new Color("Green", 200);
		blue = new Color("Blue",250);
		
		// Estate's constructor Color,name,price,rent price,house price, position
		e1 = new Estate(brown,"Pho Co",60,3,brown.getHouseprice(),1);
		e2 = new Estate(skyblue, "Buu Dien Ha Noi", 100, 6,skyblue.getHouseprice(),5);   
		e3 = new Estate(pink,"Quang truong ba dinh",140,10,pink.getHouseprice(),7);
		e4 = new Estate(orange,"Trang An",200,16,orange.getHouseprice(),11);
		e5 = new Estate(red,"Hoi An",240, 20,red.getHouseprice(),13);
		e6 = new Estate(yellow,"Dinh Doc Lap",260,22,yellow.getHouseprice(),15);
		e7 = new Estate(yellow,"Nha tho Duc Ba",260,22,yellow.getHouseprice(),17);
		e8 = new Estate(green,"Bitexco", 320,28,green.getHouseprice(),19);
		e9 = new Estate(blue,"Truong Sa",350,35,blue.getHouseprice(),23);
	
		
		
		listofestate.add(e1);
		listofestate.add(e2);
		listofestate.add(e3);
		listofestate.add(e4);
		listofestate.add(e5);
		listofestate.add(e6);
		listofestate.add(e7);
		listofestate.add(e8);
		listofestate.add(e9);
		
		Sorting();
	}
	
	public ArrayList<Estate> getList(){
		return listofestate;
	}

	public void Display(){
		for(int i = 0 ; i< listofestate.size() ; i++){
			System.out.println(listofestate.get(i));
		}
	}
	public void add(Estate e){
		listofestate.add(e);
		Sorting();
	}
	public void remove(Estate e){
		if(listofestate.contains(e)){
			listofestate.remove(e);
		}
		else{
			System.out.println("It's not in the list.");
		}

	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listofestate);
		//DisplayLands();
	}
	// get the estate by position
	public Estate getEstate(int x){
		for(int i = 0 ; i < listofestate.size(); i ++){
			int pos = listofestate.get(i).getPosition();
			if(pos == x){
				return listofestate.get(i);
			}
			
		}
		return null;
	}

}