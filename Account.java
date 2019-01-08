package Monopoly.system;


public class Account { 
	private String Name;
	private int Money;
	private int position;
	public Account(String name,int m, int pos){
		this.Name = name;
		Money = m;
		position = pos;
		
		
	}
	public String getName() {
		return Name;
	}
	public int getMoney() {
		return Money;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setMoney(int money) {
		Money = money;
	}

	public String toString(){
		return String.format("Name: %s\nMoney: %d\n--------------",Name,Money);
	}
	
}
