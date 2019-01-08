package Monopoly.system;

public class Color {
	private String name;
	private int houseprice;
	public Color(String name, int hp){
		this.name = name;
		houseprice = hp;
	}
	public String getName() {
		return name;
	}
	public int getHouseprice() {
		return houseprice;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHouseprice(int houseprice) {
		this.houseprice = houseprice;
	}
	public String toString(){
		return name;
	}
	
}
