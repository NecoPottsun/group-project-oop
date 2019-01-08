package Monopoly.system;

public class OtherLands extends Lands{
	private String name; 
	private int value; 
	public OtherLands(String name, int value, int position){
		this.name = name;
		this.value = value;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public int getvalue() {
		return value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setvalue(int value) {
		this.value = value;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "OtherLands [name=" + name + ", value=" + value + "]";
	}
	
}
