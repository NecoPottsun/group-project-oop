 package Monopoly.system;

public class Estate extends Property{
	private Color color;
//	private String name;
	private int Price;
	private int Rent;
	private int Level = 0;
	private int HousePrice;
	public Estate(Color c, String n, int p,int r,int hp, int position){
	
		color = c;
		name = n;
		Price = p;
		Rent = r;
		HousePrice = hp;
		this.position = position;
		
	}

	public Color getColor() {
		return color;
	}

//	public String getName() {
//		return name;
//	}

	public int getPrice() {
		return Price;
	}

	public int getRent() {
		return Rent;
	}

	public int getPosition() {
		return position;
	}

	public int getHousePrice() {
		return HousePrice;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setRent(int rent) {
		Rent = rent;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setHousePrice(int housePrice) {
		HousePrice = housePrice;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int Mortage(){
		int x = checklevel();
		int a = x*HousePrice;
		return (Price+a)/2;
	}
	public int RentHousePrice(){
		int x = checklevel();
		if(x == 1){
			return Rent*5;
		}
		if(x == 2){
			return Rent*15;
		}
		if(x == 3){
			return Rent*35;
		}
		if(x == 4){
			return Rent*43;
		}
		if(x == 5){
			return Rent*50;
		}
		
		return Rent;
	}
	public int checklevel(){
		if(Level == 1){
			return 1;
		}
		if(Level == 2){
			return 2;
		}
		if(Level == 3){
			return 3;
		}
		if(Level == 4){
			return 4;
		}
		if(Level >= 5){
			return 5;
		}
		return 0;
	
	}
	public String toString(){
		return String.format("%s: %s[Price: %d$, Rent Price : %d$, House Price : %d$, Mortage: %d$, Take out mortage : %d$]",color,name,this.Price,Rent,HousePrice,Mortage(),TakeOutMortage());
	}

	@Override
	public int GetPrice() {
		// TODO Auto-generated method stub
		return Price;
	}
	

}
