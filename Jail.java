package Monopoly.system;
import java.util.*;
public class Jail extends Lands{
	public Jail(int pos){
		position = pos;
	}
	public void checkposition(MoneyAmount ma){
		if(ma.getPosition() == position){
			getJail(ma);
		}
	}
	public void getJail(MoneyAmount ma){
//		if(d.checkCount() == 1 ){
		if(ma.getisonJail() == true){
			ma.setTurn(1);
			System.out.println(String.format("%s is in the jail",ma.getName()));
		}
//		}
	}
	public void payJail(DicesSystem d1,MoneyAmount ma){
		Scanner sc = new Scanner(System.in);
		if(ma.getFreeJailCard() != 0){
			System.out.println("Do you want to use Get Jail Free card to go out the jail ?\t1.Yes\t2.No");
			int c = sc.nextInt();
			switch(c){
				case 1: 
					System.out.println(ma.getName()+ " just out jail");
					ma.setTurn(0);
					ma.setIsonJail(false);
					
					break;
				default:
					System.out.println(String.format("%s denied to use , have to roll the dices again with the same faces or pay 500$",ma.getName()));
					ma.setTurn(0);
					d1.RollTurn();
					
					break;
			}
			
		}
		else{
			System.out.println(String.format("Do you want to go out the jail for 500$?\t1.Yes\t2.No"));
			int c = sc.nextInt();
			switch(c){
				case 1:
					ma.JailFee();
					System.out.println(ma.getName()+ "just out jail");
					ma.setTurn(0);
					d1.RollTurn();
					ma.setIsonJail(false);
					break;
				default: 
					System.out.println(String.format("%s denied to pay, have to roll the dices again with the same faces",ma.getName()));
					ma.setTurn(0);
					d1.RollTurn();
				
					break;
			}
		}
	}
	public void getOutJail(MoneyAmount ma){
		ma.setTurn(0);
		ma.setIsonJail(false);
		System.out.println(String.format("%s just out of jail", ma.getName()));
	}
}
