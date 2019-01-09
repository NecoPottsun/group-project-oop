package Monopoly.system;

public class Dices {
	private int a;
	private int b;
	private Dice d1,d2;
	MoneyAmount ma;
	private int count =0;
	public Dices(){
		
	}


	public void RollDice(){
		d1 = new Dice();
		d2 = new Dice();
		int a = d1.getDice();
		int b = d2.getDice();
		this.a = a;
		this.b = b;
		String.format(Display());
	}
	public int Sum(){
		return a+b;
	}
	public String Display(){
	//System.out.println(String.format("dice 1: %d\tdice 2: %d",a,b));
		return String.format("dice 1: %d\tdice 2: %d",a,b);
	}
	public int checkDices(){
		if(a==b){
			return 1;
		}
		
		return 0;
	}
	
}
