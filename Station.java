package Monopoly.system;

public class Station extends Property{
//	private String name;
//	private int position;
	public Station(String name, int p){
		this.name = name;
		position = p;
	}

	public String toString(){
		return String.format("Station: %s [Price = %d$, Rent = (depends),Mortage = %d$, Take out Mortage= %d$]",name,BuyPrice(), Mortage(),TakeOutMortage());
	}
	public int RentValue(MoneyAmount a){
		if(a.getNoOwnStation() == 1){
			return 25;
		}
		if(a.getNoOwnStation() == 2){
			return 50;
		}
		if(a.getNoOwnStation()== 3){
			return 100;
		}
		if(a.getNoOwnStation() == 4){
			return 200;
		}
		return 0;
	}
	@Override
	public int GetPrice() {
		// TODO Auto-generated method stub
		return 200;
	}

}
