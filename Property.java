package Monopoly.system;
import java.util.*;
public abstract class Property extends Lands{
	public abstract int GetPrice();
	protected String name;
	public int BuyPrice(){
		return GetPrice();
	}
	public int Mortage(){
		return GetPrice()/2;
	}
	public int TakeOutMortage(){
		return Mortage()+(int)(Mortage()*0.1);
	}

	protected int Available = 1;

	public int getAvailable() {
		return Available;
	}
	public String getName(){
		return name;
	}



}
