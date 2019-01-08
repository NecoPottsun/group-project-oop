package Monopoly.system;

public class Ultility extends Property{

	public Ultility(String name, int p){
		this.name = name;
		position = p;
	}

	public String toString(){
		return String.format("Ultility: %s [Price = %d$, Rent = (depends),Mortage = %d$, Take out Mortage = %d$]",name,BuyPrice(),Mortage(),TakeOutMortage());
	}
	public int RentValue(MoneyAmount a){
		Dices d = new Dices();
		d.RollDice();
		int r;
		if(a.getNoOwnUltility() == 1){
			r = d.Sum()*4;
			System.out.println(a.getName() + " owns " + a.getNoOwnUltility()+ " ultility. The rent price will be equal with 4 times total of dices " + r + "$");
			return r;
 		}
		if(a.getNoOwnUltility()== 2){
			r = d.Sum()*10;
			System.out.println(a.getName() + " owns " + a.getNoOwnUltility()+ " ultilities. The rent price will be equal with 10 times total of dices "+ r + "$");
			return r;
		}
		
		System.out.println(a.getName() + " doesn't own any ultility");
		return 0;
	}
	@Override
	public int GetPrice() {
		// TODO Auto-generated method stub
		return 150;
	}
}
