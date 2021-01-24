package eecs2030.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tester {

	static ArrayList<Coin> piggyBank = new ArrayList<Coin>();
	public static void main(String[] args) {
//		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
//				Coin.NICKEL, Coin.NICKEL, 
//				Coin.DIME, Coin.DIME,
//				Coin.QUARTER, Coin.QUARTER,
//				Coin.LOONIE, Coin.LOONIE,
//				Coin.TOONIE, Coin.TOONIE);
//		Owner w = new Owner("Lola");
//		OwnedPiggyBank b = new OwnedPiggyBank(w);
//		b.add(coins);
//		List<Coin> exp = Arrays.asList(Coin.QUARTER);
////		List<Coin> got = b.removeCoins(w, 25);
////		Collections.sort(got);
////		System.out.println(got);
//		System.out.println(exp);
//		System.out.println(coins);
//		System.out.println(coins.get(0).getValue());
//		System.out.println(b);
		
//		if (value == 1) {
//			coins = Arrays.asList(Coin.PENNY);
//			this.piggyBank.addAll(coins);
//		}
//		else if(value > 1 && value < 5) {
//			coins = Arrays.asList(Coin.PENNY);
//			for (int i = 0; i <= value; i++) {
//				coins = Arrays.asList(Coin.PENNY);
//				this.piggyBank.addAll(coins);
//			}
//		}
//		else if (value == 5) {
//			coins = Arrays.asList(Coin.NICKEL);
//			this.piggyBank.addAll(coins);
//		}
//		else if(value > 5 && value < 10) {
//			coins = Arrays.asList(Coin.PENNY);
//			for (int i = 0; i <= value; i++) {
//				coins = Arrays.asList(Coin.PENNY);
//				this.piggyBank.addAll(coins);
//			}
//		}
//
//		else if (value == 10) {
//			coins = Arrays.asList(Coin.DIME);
//			this.piggyBank.addAll(coins);
//		}
//		else if (value == 25) {
//			coins = Arrays.asList(Coin.QUARTER);
//			this.piggyBank.addAll(coins);
//		}
//		else if (value == 100) {
//			coins = Arrays.asList(Coin.LOONIE);
//			this.piggyBank.addAll(coins);
//		}
//		else if (value == 200) {
//			coins = Arrays.asList(Coin.TOONIE);
//			this.piggyBank.addAll(coins);
//		}
		int value = 682;
		int q200 = ((value / 2) / 200) * 2;
		double r200 = (value / 4) % 200;
		int q100 = (int) Math.ceil(r200 / 100);
		double r100 = r200 % 100;
		

		
		System.out.println("q200: " + q200 + " r200: " + r200);
		System.out.println("q100: " + q100 + " r100: " + r100);
		System.out.println("removeCoins returned the wrong list of coins expected:<[penny, penny, nickel,\n nickel, dime, dime, quarter, quarter, loonie, loonie, toonie, toonie]> but was:\n<[penny, penny, nickel, quarter, toonie]>");
		ArrayList<Coin> piggy = new ArrayList<Coin>();
		System.out.println(piggy.size());
	}
	
	public static List<Coin> removeCoins(int value) {
		List<Coin> coins = Arrays.asList();
		if (value == 1) {
			coins = Arrays.asList(Coin.PENNY);
			piggyBank.addAll(coins);
		}
		else if((value > 1 && value < 5) /*|| ((value / 1) > 1 && (value / 1) < 5) || ((value % 1) > 1 && (value % 1) < 5)*/) {
			for (int i = 1; i <= value; i++) {
				coins = Arrays.asList(Coin.PENNY);
				piggyBank.addAll(coins);
			}
		}
		else if (value == 5) {
			coins = Arrays.asList(Coin.NICKEL);
			piggyBank.addAll(coins);
		}
		else if((value > 5 && value < 10)) {
			coins = Arrays.asList(Coin.NICKEL);
			piggyBank.addAll(coins);
			coins = removeCoins(value % 5);
			piggyBank.addAll(coins);
		}
		return piggyBank;
	}

}
