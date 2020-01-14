package julianaJJ;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

	public static void main(String[] args) {
		java.util.Vector<Event> events = new Vector<Event>();
		//events.add(createEvent());
		//System.out.println(events.get(0));
		/*
		events.add(new Event());
		events.get(0).setDate(11, 26, 1995, 12, 30);
		events.add(new Event());
		events.get(1).setDate(11, 25, 1995, 12, 30);
		System.out.println(events.get(0));
		System.out.println(events.get(1));
		Collections.sort(events, new SortByDate());
		System.out.println("Should be sorted.");
		System.out.println(events.get(0));
		System.out.println(events.get(1));
		*/
		Scanner scan = new Scanner(System.in);

		do {
			openMenu();
			int choice = scan.nextInt();
			switch (choice) {
				case 0:	//Create blank event (quick);
					events.add(new Event());	//testing
					break;
				case 1:	//create new event
					events.add(createEvent());
					break;
				case 2: //Sort events (descending)
					Collections.sort(events, new SortByDate());
					break;
				case 3:	//sort events (descending) 
					Collections.sort(events, new SortByDate());
					Collections.reverse(events);
					break;
				case 4:	
					break;
				case 5: //List all events
					for (int i = 0; i < events.size(); i++ ) {
						System.out.println(events.get(i));
					}
					break;
				case 6: 	//Print specific event
					break;
				case 9: 	
					scan.close(); 
					System.out.println("Goodbye!"); 
					System.exit(0); 
					break;
			}
		} while (true);

	}	
	static void openMenu() {
		System.out.println("Select an option");
		System.out.println("1) Add new event");
		System.out.println("2) Sort Events by date (ascending order)");
		System.out.println("3) Sort Events by date (descending order)");
		System.out.println("4) List all events");
		System.out.println("5) Print all events (Detailed)");
		System.out.println("6) Print specific event");
		System.out.println("9) Exit.");
	}
	
	static Event createEvent(){
		boolean success = false;
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		//Event event = new Event();
		int choice;
		Event event;
		String input = "";
		//Get input for the type of menu
		do {
			success = false;
			System.out.println("What type of menu do you want for your event?"  + System.lineSeparator() + "1:) Social" + System.lineSeparator() + 
					"2:) Brunch" + System.lineSeparator() + "3:) Dinner");
			choice = intScan.nextInt();
			if (choice == 3 || choice == 2 || choice == 1) {
				success = true;
			} else {
				System.out.println("Invalid Response.  Try again.");

			}
		} while (!success);

		switch (choice) {
			case 1: 
				event = new SocialEvent(); 
				success = true; 
				break;
			case 2:
				event = new BrunchEvent(); 
				success = true; 
				break;
			case 3: 
				event = new DinnerEvent();
				success = true; 
				chooseMenu((DinnerEvent) event);
				break;
			default: 
				event = new BrunchEvent();			
		}
		System.out.println("num events: " + Event.getNumEvents());
		
		
		//Get input for the event type
		do {
			success = false;
			System.out.println("What type of event is this?" +  System.lineSeparator() + "1:) Wedding" + System.lineSeparator() + "2:) Birthday" +
								System.lineSeparator() + "3:) Corporate");
			choice = intScan.nextInt();
			switch (choice) {
				case 1: event.setEventType("Wedding"); success = true; break;
				case 2: event.setEventType("Birthday"); success = true; break;
				case 3: event.setEventType("Corporate"); success = true; break;
			}
			if (!success) {
				System.out.println("Invalid Response.  Try again.");
			}
		} while (!success);
		
		System.out.println("Enter the name of the event: ");
		input = scan.nextLine();
		event.setName(input);

		//Get input for the event location
		do {
			System.out.println("What loation?" + System.lineSeparator() + "1:) Java Joint" + System.lineSeparator() + 
					"2:) Shorty's"+ System.lineSeparator() +  "3:) Stokesay Castle");
			choice = intScan.nextInt();
			success = false;
			switch (choice){
				case 1: 
					try {
						event.setLocation("Java Joint"); 
					} catch (Exception ex){}
					success = true;
					break;
				case 2: 
					try {
						event.setLocation("Shorty's"); 
					} catch (Exception ex) {}
					success = true;
					break;
				case 3: 
					try {
					event.setLocation("Stokesay Castle");
					} catch (Exception ex) {}
					success = true;
					break;
				} 
			if (!success) {
				System.out.println("Invalid response.  Try again.");
			}
		}while (!success);
		
		
		//Get input for the number of people who will attend the event
		do {
			success = true;
			System.out.println("How many people will attend the event? ");
			int numGuests;
			//numGuests = Integer.parseInt(scan.nextLine()); //by parsing an int from newline, we get rid of the carriage return character.
			numGuests = intScan.nextInt();
			try {
				event.setNumGuests(numGuests);
			} 
			catch (ArgumentOutOfBoundsException e) {
				System.out.println(e);
				success = false;
			}
		} while (!success);
		
		System.out.println("Enter a summary of your event: ");
		input = scan.nextLine();
		event.setSummary(input);
		
		System.out.println("Enter the event date and time in this formate: mm dd yyyy hour(military) minute): ");
		int day = intScan.nextInt();
		int month = intScan.nextInt();
		int year = intScan.nextInt();
		int hour = intScan.nextInt();
		int minute = intScan.nextInt();
		event.setDate(day, month, year, hour, minute);
		
		
		System.out.println("Enter your name: ");
		input = scan.nextLine();
		event.customer.setName(input);
		
		System.out.println("Enter your email: ");
		input = scan.nextLine();
		event.customer.setEmail(input);
		
		System.out.println("Enter your phone number: ");
		input = scan.nextLine();
		event.customer.setPhone(input);
		
		//System.out.println(event);
		scan.close();
		intScan.close();
		return event;
	}
	
	static void chooseMenu(DinnerEvent event) {
		Scanner scan = new Scanner(System.in);
		boolean success = true;
		int choice; 
		
		
		//
		//		Entree Choice Input
		//
		//Get input for the amount of entree choices
		do {
			System.out.println("How many entree choices?");
			choice = scan.nextInt();
			success = true;
			try {
				event.setNumEntreeChoices(choice);
			} catch (ArgumentOutOfBoundsException ex) {
				System.out.println(ex);
				System.out.println("Try again: ");
				success = false;
			}
		} while (!success);
		
		String[] menu = event.getMenu();
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + ")" + menu[i] + "\t");
		}
		System.out.println("Enter number for the choices of entree.  You have " + event.getNumEntreeChoices() + " entrees to choose.");
		int[] entreeChoices = new int[event.getNumEntreeChoices()];
		
		for (int i = 0; i < event.getNumEntreeChoices(); i++) {
			entreeChoices [i] = scan.nextInt();
		}
		event.setEntreeChoices(entreeChoices);
		System.out.println();
		
		//
		//		Side Choice Input
		//
		do {
			success = true;
			//print menu
			System.out.println("Choose a side: ");
			String[] sides = event.getSidesMenu();
			for (int i = 0; i < sides.length; i++) {
				System.out.println(i + ") " + sides[i]);
			}
			System.out.println("");	//print menu fin
			
			choice = scan.nextInt();
			try {
				event.setSideChoice(choice);
			} catch(ArgumentOutOfBoundsException ex) {
				System.out.println(ex + System.lineSeparator() + "Try again.");
				success = false;
			}
		} while (!success);
		
		//
		//		Dessert Choice Input
		//
		do {
			success = true;
			//print menu
			System.out.println("Choose a dessert: ");
			String[] desserts = event.getDessertMenu();
			for (int i = 0; i < desserts.length; i++) {
				System.out.println(i + ") " + desserts[i]);
			}
			System.out.println("");	//print menu fin
			
			choice = scan.nextInt();
			try {
				event.setDessertChoice(choice);
			} catch(ArgumentOutOfBoundsException ex) {
				System.out.println(ex + System.lineSeparator() + "Try again.");
				success = false;
			}
		} while (!success);
		scan.close();
	}	
}	//End class

