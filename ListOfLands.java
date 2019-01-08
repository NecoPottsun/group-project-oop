package Monopoly.system;


import java.util.*;
public class ListOfLands{
	private ArrayList<Lands> listoflands = new ArrayList<Lands>();
	private Color brown,skyblue,pink,orange,red,yellow,green,blue;
	private Estate e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20;
	private Station s1,s2,s3,s4;
	private OtherLands ol1,ol2,ol3;
	private Jail jail;
	
	public ListOfLands(){
		Color brown = new Color("Brown",50);
		Color skyblue = new Color("Sky blue", 50);
		Color pink = new Color("Pink",100);
		Color orange = new Color("Orange", 100);
		Color red = new Color("Red",150);
		Color yellow = new Color("Yellow",150);
		Color green = new Color("Green", 200);
		Color blue = new Color("Blue",250);
		
		// Estate's constructor Color,name,price,rent price,house price, position
		Estate e1 = new Estate(brown,"Pho Co",60,3,brown.getHouseprice(),1);
		Estate e2 = new Estate(skyblue, "Buu Dien Ha Noi", 100, 6,skyblue.getHouseprice(),5);   
		Estate e3 = new Estate(pink,"Quang truong ba dinh",140,10,pink.getHouseprice(),7);
		Estate e4 = new Estate(pink,"Van Mieu", 160,12,pink.getHouseprice(),8);
		Estate e5 = new Estate(orange,"Trang An",200,16,orange.getHouseprice(),11);
		Estate e6 = new Estate(red,"Hoi An",240, 20,red.getHouseprice(),13);
		Estate e7 = new Estate(yellow,"Dinh Doc Lap",260,22,yellow.getHouseprice(),15);
		Estate e8 = new Estate(yellow,"Nha tho Duc Ba",260,22,yellow.getHouseprice(),17);
	//	Estate e19 = new Estate(green,"Duong Nguyen Hue", 300,26,green.getHouseprice(),20);
		Estate e9 = new Estate(green,"Bitexco", 320,28,green.getHouseprice(),19);
		Estate e10 = new Estate(blue,"Truong Sa",350,35,blue.getHouseprice(),24);
	
		// Station's constructor name , position
		Station s1 = new Station("Ha Noi station", 4);
		Station s2 = new Station("Vinh station",9);
		Station s3 = new Station("Da Nang station",16);
		Station s4 = new Station("Sai Gon station",22);
		
		
		// Ultility
		Ultility u1 = new Ultility("Electric Company",8);
		Ultility u2 = new Ultility("Water Factory",20);
		//Community Chest And Lucky 
		CALCards c1 = new CALCards(2);
		CALCards c2 = new CALCards(10);
		CALCards c3 = new CALCards(14);
		CALCards c4 = new CALCards(21);
		
		//Other Lands
		OtherLands ol1 = new OtherLands("GO",200,0);
		OtherLands ol2 = new OtherLands("Visiting Jail",0,6);
		OtherLands ol3 = new OtherLands("Parking", 0, 12);	
		Jail jail = new Jail(18);
		
		
		listoflands.add(e2);
		listoflands.add(e1);
		listoflands.add(e3);
		listoflands.add(e4);
		listoflands.add(e5);
		listoflands.add(e6);
		listoflands.add(e7);
		listoflands.add(e8);
		listoflands.add(e9);
		listoflands.add(e10);
		listoflands.add(s1);
		listoflands.add(s2);
		listoflands.add(s3);
		listoflands.add(s4);
		listoflands.add(u1);
		listoflands.add(u2);
		listoflands.add(c1);
		listoflands.add(c2);
		listoflands.add(c3);
		listoflands.add(c4);
		listoflands.add(ol1);
		listoflands.add(ol2);
		listoflands.add(ol3);
		listoflands.add(jail);
		Sorting();

	}
	public void add(Lands l){
		listoflands.add(l);
	}
	public void remove(Lands l){
		if(listoflands.contains(l)){
			listoflands.remove(l);
		}
		else{
			System.out.println("It's not in the list.");
		}
	}
	public void DisplayLands(){
		for(int i = 0; i < listoflands.size(); i++){
			System.out.println((i+1)+"\t"+listoflands.get(i));
		}
	}
	public Lands Search(String name){
		for(int i = 0; i < listoflands.size(); i++){
			Lands l1 = listoflands.get(i);
			if(name.equalsIgnoreCase(l1.getName())){
				//System.out.println((i+1)+"\t"+l1.toString());
				return l1;
			}
		}
		return null;
	}
//	public Lands SearchJail(){
//		return Search(jail);
//	}
	public int Size(){
		return listoflands.size();
	}
	public Lands DiceLand(MoneyAmount ma,int x){
		for(int i = 0 ; i < listoflands.size(); i++){
			Lands l1 = listoflands.get(i);
			if(l1.getPosition() == x){
				System.out.println(String.format("%s is standing on %s",ma.getName(),l1.getName()));
				return l1;
			}
		}
		return null;
		
	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listoflands);
		//DisplayLands();
	}

}
