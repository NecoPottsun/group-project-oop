package Monopoly.system;

import java.util.*;

public class Dice {
	Random Rand = new Random();
	private int n = Rand.nextInt(6)+1;
	private int x;
	public Dice(){
		this.x = n;
	}
	public int getDice(){
		return x;
	}
}