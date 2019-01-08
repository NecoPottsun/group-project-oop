package Monopoly.system;

public abstract class Lands implements Comparable<Lands>{
	protected int position;
	protected String name;
	public int getPosition() {
		return position;
	}
	public String getName(){
		return name;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(Lands nextLand) {
		//ascending
		return getPosition()-nextLand.getPosition();
	}


}
