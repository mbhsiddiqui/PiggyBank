package eecs2030.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. 
 * A piggy bank owns a collection (or possibly collections) of coins,
 * but does not own the coins themselves. In other words,
 * the piggy bank and its collection of coins form a composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins
 * from the piggy bank. The piggy bank does own its owner.
 * In other words, the piggy bank and its owner form an
 * aggregation.
 */
public class OwnedPiggyBank {
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */

	private ArrayList<Coin> piggyBank;

	/*
	 * The owner of this piggy bank.
	 */

	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner
	 * and its collection of coins is empty.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		piggyBank = new ArrayList<Coin>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy
	 * bank will have the same owner and the same number and type of coins as
	 * the other piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.owner;
		this.piggyBank = new ArrayList<Coin>(other.piggyBank.size());
		for (int i = 0; i < other.piggyBank.size(); i++) {
			this.piggyBank.add(i, other.piggyBank.get(i));
		}

	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning
	 * the owner of this piggy bank allows any user to remove coins
	 * from the piggy bank (because any user can get the owner
	 * of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}

	/**
	 * Allows the current owner of this piggy bank to give this
	 * piggy bank to a new owner.
	 * 
	 * @param currentOwner the current owner of this piggy bank
	 * @param newOwner the new owner of this piggy bank
	 * @throws IllegalArgumentException if currentOwner is not the
	 * current owner of this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) {
		if(this.owner.getID() == currentOwner.getID()) {
			this.owner = newOwner;
		}
		else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		this.piggyBank.addAll(coins);

	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		return this.piggyBank.contains(coin);

	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value
	 * of the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank,
	 * then the coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy
	 *         bank, or null if user is not the owner of this piggy bank
	 * @pre. the piggy bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		if(this.owner.getID() == user.getID()) {
			this.piggyBank.remove(coin);
			return coin;
		}
		else {
			return null;
		}

	}

	/**
	 * Allows the owner of this piggy bank to remove
	 * the smallest number of coins whose total value in cents is equal
	 * to the specified value in cents from this piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to
	 * the owner of this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal
	 *         to the specified value in cents from this piggy bank 
	 * @pre. the piggy bank contains a group of coins whose total value is equal
	 *         to specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> coins = Arrays.asList();
		//ArrayList<Coin> piggy = new ArrayList<Coin>();
		if(this.owner.getID() == user.getID()) { // ID check START
			this.piggyBank.clear();

			if((value >= 1 && value < 5) /*|| ((value / 1) > 1 && (value / 1) < 5) || ((value % 1) > 1 && (value % 1) < 5)*/) {
				for (int i = 0; i < value; i++) {
					coins = Arrays.asList(Coin.PENNY);
					this.piggyBank.addAll(coins);
				}
			}
			else if((value >= 5 && value < 10)) {
				int quotient = value / 5;
				int remainder = value % 5;
				coins = removeCoins(user, remainder);
				if (quotient != 0 && remainder == 0) {
					for (int i = 0; i < quotient; i++) {
						coins = Arrays.asList(Coin.NICKEL);
						this.piggyBank.addAll(coins);
					}
				}
				else {
					coins = Arrays.asList(Coin.NICKEL);
					this.piggyBank.addAll(coins);
				}
			}
			else if((value >= 10 && value < 25)) {
				int quotient = value / 10;
				int remainder = value % 10;
				coins = removeCoins(user, remainder);
				if (quotient != 0 && remainder == 0) {
					for (int i = 0; i < quotient; i++) {
						coins = Arrays.asList(Coin.DIME);
						this.piggyBank.addAll(coins);
					}
				}
				else {
					coins = Arrays.asList(Coin.DIME);
					this.piggyBank.addAll(coins);
				}
				
			}
			else if((value >= 25 && value < 100)) {
				int quotient = value / 25;
				int remainder = value % 25;
				coins = removeCoins(user, remainder);
				if (quotient != 0 && remainder == 0) {
					for (int i = 0; i < quotient; i++) {
						coins = Arrays.asList(Coin.QUARTER);
						this.piggyBank.addAll(coins);
					}
				}
				else {
					coins = Arrays.asList(Coin.QUARTER);
					this.piggyBank.addAll(coins);
				}
			}
			else if((value >= 100 && value < 200)) {
				int quotient = (int) (Math.ceil(value)) / 100;
				int remainder = value % 100;
				coins = removeCoins(user, remainder);
				if (quotient != 0 && remainder == 0) {
					for (int i = 0; i < quotient; i++) {
						coins = Arrays.asList(Coin.LOONIE);
						this.piggyBank.addAll(coins);
					}
				}
				else {
					coins = Arrays.asList(Coin.LOONIE);
					this.piggyBank.addAll(coins);
				}
			}
			else if(value >= 200) {
				int quotient = value / 200;
				int remainder = value % 200;
				coins = removeCoins(user, remainder);
				if (quotient != 0 && remainder == 0) {
					for (int i = 0; i < quotient; i++) {
						coins = Arrays.asList(Coin.TOONIE);
						this.piggyBank.addAll(coins);
					}
				}
				else {
					coins = Arrays.asList(Coin.TOONIE);
					this.piggyBank.addAll(coins);
				}
			}

		} // ID check END
		else {
			this.piggyBank.clear();
		}
		return this.piggyBank;
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list
	 * has its coins in sorted order (from smallest value to largest value;
	 * i.e., pennies first, followed by nickels, dimes, quarters, loonies, and
	 * toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		if(this.piggyBank.size() == 0) {
			this.piggyBank.clear();
			return this.piggyBank;
		}
		else {
			for(int i = 1; i < this.piggyBank.size(); i++) { // for loop START
				if((i+1) >= this.piggyBank.size()) {
					break;
				}
				else {
					if(this.piggyBank.get(i - 1).getValue() > this.piggyBank.get(i).getValue()) {
						this.piggyBank.set((i - 1), this.piggyBank.get(i));
					}
					else if(this.piggyBank.get(i).getValue() > this.piggyBank.get(i + 1).getValue()) {
						this.piggyBank.set((i), this.piggyBank.get(i + 1));
					}
					else {
						return this.piggyBank;
					}
				}
			} // for loop END
		}
		return this.piggyBank;

	}
}
