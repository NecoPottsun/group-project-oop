package Monopoly.system;

public class ChestAndLucky{
	private String Name;
	private int Value;

	public ChestAndLucky(String n , int v)
	{
		Name = n;
		Value = v;
	}
	public String getName() {
		return Name;
	}
	public int getValue() {
		return Value;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setValue(int Value) {
		this.Value = Value;
	}
	public String toString(){
		return Name;
	}
}
