package monopoly;

import java.util.ArrayList;
import java.util.Collections;


public class ListOfLands{
	private ArrayList<Lands> listoflands = new ArrayList<Lands>();
	private Jail jail;
	private ListOfEstate listofe;
	private ListOfStation listofs;
	private ListOfChestAndLucky listofc;
	private ListOfOtherLands listofol;
	private ListOfUltility listofu;
	public ListOfLands(){
		listofe = new ListOfEstate();
		
		for(int i = 0; i < listofe.getList().size() ; i++){
			listoflands.add(listofe.getList().get(i));
		}
		
		listofs = new ListOfStation();
		
		for(int i = 0; i < listofs.getList().size(); i++){
			listoflands.add(listofs.getList().get(i));
		}
		
		listofc = new ListOfChestAndLucky();
		
		for(int i = 0; i < listofc.getList().size() ; i++){
			listoflands.add(listofc.getList().get(i));
		}
		
		listofol = new ListOfOtherLands();
		
		for(int i = 0; i < listofol.getList().size();i++){
			listoflands.add(listofol.getList().get(i));
		}
		
		listofu = new ListOfUltility();
		
		for(int i = 0; i < listofu.getList().size();i++){
			listoflands.add(listofu.getList().get(i));
		}
		
		jail = new Jail(18);
		listoflands.add(jail);

		Sorting(); 
	}
	public ArrayList<Lands> getList(){
		return listoflands;
	}

	public Jail getJail() {
		return jail;
	}
	public ListOfEstate getListofe() {
		return listofe;
	}
	public ListOfStation getListofs() {
		return listofs;
	}
	public ListOfChestAndLucky getListofc() {
		return listofc;
	}
	public ListOfOtherLands getListofol() {
		return listofol;
	}

	public ListOfUltility getListofu() {
		return listofu;
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
	public void DisplayPos(){
		for(int i = 0; i < listoflands.size();i++){
			System.out.println(String.format("%s\tPosition = %d",listoflands.get(i).getName(),listoflands.get(i).getPosition()));
		}
	}
	public void Sorting(){
		// Sorting position's lands ascending
		Collections.sort(listoflands);
		//DisplayLands();
	}
	public Lands getLands(int x){
		for(int i = 0 ; i < listoflands.size(); i ++){
			int pos = listoflands.get(i).getPosition();
			if(pos == x){
				return listoflands.get(i);
			}
			
		}
		return null;
	}

}