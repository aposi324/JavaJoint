/**
 * @author	Alexander Posipanko
 *  Major:			Software Development
 *	Creation Date:	4/5/2018
 *	Due Date: 		sprint 1: 4/6/2018
 *	Course:			CSC 243-020 Java Programming
 *	Professor Name:	Prof. Demarco
 *	Assignment:		Sprint 1
 *	Filename:		DinnerEvent.java
 *	Purpose:		Used to manage dinner events.
  */


package julianaJJ;

import java.util.Arrays;

public class DinnerEvent extends Event {

	
	private String[] entreeMenu = { "chicken", "fish", "beef", "pork", "past", "vegan"};
	private int menuSize = entreeMenu.length;
	
	private boolean[] entreeChoice = { true , false , false , false , false , false };
	private int numEntreeChoices = 2;
	
	private String[] sidesMenu = { "soup", "salad", "greenBeans", "bakedPotato", "pasta", "appleSauce"};
	private int sidesChoice = 0;
	
	private String[] dessertMenu = {"Chocolate Mousse", "Cheesecake", "Sherbert", "Ice Cream", "Lava Cake", "Carrot Cake"};
	private int dessertChoice = 0;
	
	public DinnerEvent() {
		//Event.numEvents = Event.numEvents + 1;
		eventNum = numEvents;
		menuType = "Dinner";
	}
	
	public int getMenuSize() {
		return menuSize;
	}
	
	public String[] getMenu() {
		return entreeMenu;
	}
	
	public String[] getDessertMenu() {
		return dessertMenu;
	}
	
	public String[] getSidesMenu() {
		return sidesMenu;
	}
	
	public int getNumEntreeChoices() {
		return numEntreeChoices;
	}
	
	public boolean[] getEntreeChoices() {
		return entreeChoice;
	}
	
	public int getSidesChoice() {
		return sidesChoice;
	}
	
	public int getDessertChoice() {
		return dessertChoice;
	}
	
	public void setEntreeChoices(int choices[]) {
		int count = 0;
		for (int i = 0; i < getMenuSize(); i++) {
			entreeChoice[i] = false;
		}
		for (int i = 0; i < choices.length; i++) {
			entreeChoice[i] = true;
		}
	}
	
	public void setNumEntreeChoices(int num) throws ArgumentOutOfBoundsException{
		if (num < 1) {
			throw (new ArgumentOutOfBoundsException("There must at least one choice of entree."));
		} else if (num > 3) {
			throw (new ArgumentOutOfBoundsException("there must be three or fewer choices of entree."));
		} else {
			numEntreeChoices = num;
		}
	}
	
	public void setSideChoice(int num) throws ArgumentOutOfBoundsException{
		if (num < 0 || (num > getSidesMenu().length - 1)) {
			throw (new ArgumentOutOfBoundsException("Invalid menu choice"));
		}
		sidesChoice = num;
	}
	
	public void setDessertChoice(int num) throws ArgumentOutOfBoundsException{
		if (num < 0 || num > (getDessertMenu().length - 1)) {
			throw (new ArgumentOutOfBoundsException("Invalid menu choice"));
		}
		dessertChoice = num;
	}
	
	public String toString() {
		String retStr = super.toString();
		retStr += "Entree choices: ";
		
		boolean[] entreeChoices = Arrays.copyOf(getEntreeChoices(), getEntreeChoices().length);

		for (int i = 0 ; i < getMenuSize() ; i++) {
			if (entreeChoices[i] == true) {
				retStr += getMenu()[i] + " ";
			}
			retStr += System.lineSeparator();
		}
		
		retStr += "Side: " + getSidesMenu()[getSidesChoice()];
		return retStr;
	}
	
	
	
	

}
