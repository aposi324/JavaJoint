/**
 * @author	Alexander Posipanko
 *  Major:			Software Development
 *	Creation Date:	4/5/2018
 *	Due Date: 		sprint 1: 4/6/2018
 *	Course:			CSC 243-020 Java Programming
 *	Professor Name:	Prof. Demarco
 *	Assignment:		Sprint 1
 *	Filename:		Event.java
 *	Purpose:		Manage events for the catering business.  
  */

package julianaJJ;

import java.util.Comparator;

public class Event {
	
	static int numEvents;
	
	java.util.Calendar date = java.util.Calendar.getInstance();
	
	String eventName = "Event";
	String summary = "No summary defined.";
	String eventType = "generic";
	String menuType = "";
	String location = "";
	
	int numGuests = 5;	//5 guest minimum
	int eventNum;
	int maxGuests = 50;
	
	double pricePerGuest = 32;
	
	Customer customer = new Customer();
	

	public Event(){
		Event.numEvents = Event.numEvents + 1;
;
		eventNum = numEvents;
	}
	
	public Event(String name, int numGuests) {
		Event.numEvents = Event.numEvents + 1;
		eventNum = numEvents;
		eventName = name;
		try {
			setNumGuests(numGuests);
		} 
		catch (ArgumentOutOfBoundsException ex) {
			//Set number of guests to five if there is an exception
			try {
				setNumGuests(5);
			} catch (ArgumentOutOfBoundsException e) {
			}
			System.out.println(ex.toString() + " Setting number of guests to 5.");
		}
	}
	

	//setters
	
	/**
	 *
	 * @param num	The number of guests to attend the event.
	 * @throws ArgumentOutOfBoundsException
	 */
	public void setNumGuests(int num) throws ArgumentOutOfBoundsException {
		if (num < 5) {
			throw new ArgumentOutOfBoundsException ("Error: not enough guests. The minimum is 5.");
		} else if (num > getMaxGuests() ) {
			throw new ArgumentOutOfBoundsException ("Error: too many guests. The limit is " + getMaxGuests());
		} else {
			numGuests = num;
			//set pricing depending on the number of guests.
			if (numGuests >50) {
				setPricePerGuest(32.00);
			} else {
				setPricePerGuest(35.00);
			}
		}
	}

	public void setName(String name) {
		eventName = name;
	}
	
	/**
	 * 
	 * @param month	Month to set.  January = 0, February = 1 , ... , December = 11.
	 * @param day	Day to set.
	 * @param year	Year to set.
	 * @param hrs	Hour to set.
	 * @param min	Minute to set.
	 */
	public void setDate(int month, int day, int year, int hrs, int min) {
		date.set(year, month, day, hrs, min);
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public void setLocation(String location) throws ArgumentOutOfBoundsException {
		location = location.toUpperCase();
		if (location.equals("JAVA JOINT")) {
			setMaxGuests(50);
			this.location = location;
		} else if (location.equals("SHORTY") || location.equals("SHORTY'S") || location.equals("SHORTYS")) {
			setMaxGuests(100);
			this.location = location;
		} else if (location.equals("STOKESAY")) {
			setMaxGuests(300);
			this.location = location;
		} else {
			throw new ArgumentOutOfBoundsException("Invalde location: " + location);
		}
	}
	

	//getters
	public String getDateString() {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("E MM.dd.yyyy 'at' hh:mm a zzz");
		return formatter.format(date.getTime());
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getMenuType() {
		return menuType;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getNumGuests() {
		return numGuests;
	}
	
	public double getPricePerGuest() {
		return pricePerGuest;
	}
	
	public double getTotalPrice() {
		return getPricePerGuest() * getNumGuests();
	}
	
	public int getEventNum() {
		return eventNum;
	}
	
	public int getMaxGuests() {
		return maxGuests;
	}
	
	public static int getNumEvents() {
		return numEvents;
	}
	
	public java.util.Date getDate() {
		return date.getTime();
	}
/**
 * 
 * @return	String summary of the event.
 */
	public String toString() {
		String returnStr = "";
		returnStr += "Event name: " + getEventName() + System.lineSeparator();
		returnStr += "Event type: " + getEventType() + System.lineSeparator();
		returnStr += "Event location: " + getLocation() + System.lineSeparator();
		returnStr += "Menu type: " + getMenuType() + System.lineSeparator();
 		returnStr += "Event num: " + getEventNum() + System.lineSeparator();
		returnStr += "Event Date: " + getDateString() + System.lineSeparator();
		returnStr += "Event type: " + getEventType() + System.lineSeparator();
		returnStr += "Summary: " + getSummary() + System.lineSeparator();
		returnStr += "Number of guests: " + getNumGuests() + System.lineSeparator();
		returnStr += "Total Cost: $" + getTotalPrice() + System.lineSeparator();
		returnStr += "You will be contacted by phone or e-mail within 2 business days to discuss the details." + System.lineSeparator();
		returnStr += customer.toString();
		return returnStr;
	}
	



	//private (helper) methods.
	
	/**
	 * 
	 * @param price	The price per guest attending the event.
	 * @throws ArgumentOutOfBoundsException
	 */
	private void setPricePerGuest(double price) throws ArgumentOutOfBoundsException {
		if (price < 0) {
			throw new ArgumentOutOfBoundsException ("Negative prices are not allowed.");
		}
		pricePerGuest = price;
	}
	
	private void setMaxGuests(int num) {
		this.maxGuests = num;
	}
		
}

class SortByDate implements Comparator<Event>{

	@Override
	public int compare(Event arg0, Event arg1) {
		// TODO Auto-generated method stub
		return arg0.getDate().compareTo(arg1.getDate());
	}
}

