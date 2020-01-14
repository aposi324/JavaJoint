/**
 * @author	Alexander Posipanko
 *  Major:			Software Development
 *	Creation Date:	4/5/2018
 *	Due Date: 		sprint 1: 4/6/2018
 *	Course:			CSC 243-020 Java Programming
 *	Professor Name:	Prof. Demarco
 *	Assignment:		Sprint 1
 *	Filename:		Customer.java
 *	Purpose:		Enter and get data about the customer
 */


package julianaJJ;

public class Customer {

	private String name = null;
	private String email = null;
	private String address = null;
	private String phone = null;
	
	
	public Customer() {
	
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String toString() {
		String retString = "";
		retString += "Customer name: " + getName() + System.lineSeparator();
		retString += "Customer email: " + getEmail() + System.lineSeparator();
		//retString += "Customer Address: " + getAddress() + System.lineSeparator();
		retString += "Customer Phone Number: " + getPhone() + System.lineSeparator();
		return retString;
	}
}
