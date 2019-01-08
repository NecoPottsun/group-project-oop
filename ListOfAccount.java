package Monopoly.system;
import java.util.ArrayList;
import java.util.Collections;
public class ListOfAccount {
	ArrayList<Account> listofacc = new ArrayList<Account>();
	ArrayList<MoneyAmount> listofmm = new ArrayList<MoneyAmount>();
	public ListOfAccount(){

	}
	public void Add(Account a,MoneyAmount m){
		listofacc.add(a);
		listofmm.add(m);
	}
	public void Remove(Account a,MoneyAmount m){
		listofacc.remove(a);
		listofmm.remove(m);
	}
	public MoneyAmount checkOwners(Property p){
		if(p.Available == 0){
			for(int i = 0; i < listofmm.size();i++){
				MoneyAmount ma = listofmm.get(i);
				if(ma.getOwningList().contains(i))
				{
					return ma;
				}
			
			}
		}
		else{
			System.out.println("Noone owning " +p.getName());
		}
		return null;
	}
	
	public void DisplayOwningLists(){
		for(int i = 0; i < listofmm.size(); i++){
			MoneyAmount ma = listofmm.get(i);
			ma.DisplayList();
		}
	}
	public void DisplayPlayers(){
		for(int i = 0; i < listofacc.size(); i++){
			System.out.println((i+1)+"\n"+listofacc.get(i));
		}
	}
	public void DisplayPlayingPlayers(){
		CheckBankrupt();
		for(int i = 0; i < listofmm.size(); i++){
			System.out.println((i+1)+"\t"+listofmm.get(i));
		}
	}
	public void CheckBankrupt(){
		for(int i = 0; i < listofmm.size(); i++){
			MoneyAmount ma = listofmm.get(i);
			int x =ma.Bankrupt();
			if(x == 1){
				listofmm.remove(ma);
			}
		}
	}
	public void checklistTurn(){
		MoneyAmount ma;
		for(int i = 0 ; i < listofmm.size();i++){
			ma = listofmm.get(i);
			int x = ma.getTurn();
//			if(x == 0){
//				System.out.println(String.format("%s turn",ma.getName()));
//			}
//			else {
//		//		System.out.println(String.format("%s has already roll the dice",ma.getName()));
//	
	
//			}
			ma.setTurn(0);
		}

//		System.out.println("Finish the turn");

		
	}
	public void checkWinner(){
		if(listofmm != null){
			Collections.sort(listofmm);
			DisplayPlayingPlayers();
			System.out.println("---> The winner is " + listofmm.get(0));
		}
	}
	
}
