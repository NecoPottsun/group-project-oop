package Monopoly.system;

public class DicesSystem {
	private Dices d,d1,d2;
	private MoneyAmount ma;
	private ListOfLands LandList;
	private int Count = 0;
	private int Total = 0;
	public DicesSystem(Dices d,MoneyAmount ma,ListOfLands LandList){
		this.d = d;
		this.ma = ma;
		this.LandList = LandList;
	}
	public MoneyAmount getMa() {
		return ma;
	}
	public Dices getD() {
		return d;
	}
	public int getCount() {
		return Count;
	}
	public int getTotal() {
		return Total;
	}

	public void setCount(int Count) {
		this.Count = Count;
	}
	public void setTotal(int Total) {
		this.Total = Total;
	}
	public Lands getLand(){
		return LandList.DiceLand(ma, Total);
	}
	public void Action(){
		Total+= d.Sum();
		Dice();
		int y = checkCount();
		checkTotal();
		getLand();
		// check if the dices roll 3 times have the same faces 
		if(y == 1){
		//	jail.getJail(ma);
			ma.setIsonJail(true);
		}

	}

	public int checkCount(){
		if(Count == 3){
			System.out.println("xxxGo To Jailxxx");
			System.out.println(Count);
			Count = 0;
			return 1;
			
		}
		else{
			return 0;
			
		}
	}

	public int Dice(){
		int x = d.checkDices();
		// check the 1st same of 2 dices' faces 
		if(x == 1){
			Count++;
			d.RollDice();
			int y = d.Sum();
			Total += y;
			//check the 2nd
			if(d.checkDices() ==1){
				Count++;
				d.RollDice();
				int z = d.Sum();
				Total += z;
				//check the 3rd
				if(d.checkDices() == 1){
					Count++;
	
					
				}
				else{
					Count = 0;
		
				}
				return z;
				
			}
			else{
			//	System.out.println("abc " + Count)
				Count = 0;
				return y;
//				System.out.println("abc " + Count);
			}	
		}
		else{
			Count = 0;
			return 0;
		}
	}
	public int checkDices(){
		int x = d.checkDices();
		return x;
	}
	public void RollTurn(){
		if(ma.getTurn() == 0){
			System.out.println(String.format("-------%s's turn------",ma.getName()));
			if(ma.getisonJail() == false){
				d.RollDice();
				System.out.println(String.format("---> %s go %d steps",ma.getName(),d.Sum()));
				Action();
				ma.setTurn(1);
			}
			else{
				d.RollDice();
				if(d.checkDices() == 1){
					ma.setTurn(0);
					ma.setIsonJail(false);
					System.out.println(String.format("%s just out of jail", ma.getName()));
					
				}
				else{
					ma.setTurn(1);
					System.out.println(String.format("%s have to wait to the next turn",ma.getName()));
				}
			}
		}
		else{
			System.out.println(String.format("----->It's not %s's turn",ma.getName()));
		}
	}
	public void checkTotal(){
		if(Total >= LandList.Size()){
			Total-= LandList.Size();
		}
	}
}
