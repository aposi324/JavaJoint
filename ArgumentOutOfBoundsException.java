/**
 * @author	Alexander Posipanko
 *  Major:			Software Development
 *	Creation Date:	4/5/2018
 *	Due Date: 		sprint 1: 4/6/2018
 *	Course:			CSC 243-020 Java Programming
 *	Professor Name:	Prof. Demarco
 *	Assignment:		Sprint 1
 *	Filename:		ArgumentOutOfBoundsException.java
 *	Purpose:		Used for error-checking invalid arguments.
  */


package julianaJJ;

public class ArgumentOutOfBoundsException extends Exception {
	String message = "Argument out of bounds exception occurred.";
	public ArgumentOutOfBoundsException() {
		
	}

	public ArgumentOutOfBoundsException(String message) {
		this.message = message;
	}

	public ArgumentOutOfBoundsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ArgumentOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public ArgumentOutOfBoundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return message;
		
	}
}
