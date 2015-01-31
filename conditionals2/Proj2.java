// Started midnight on 1/31

import java.util.*;
import java.text.*;

public class Proj2 
{
	static double tax = .0625;
	
	public static void main(String[] args) 
	{
		//variable dec
		Scanner s = new Scanner(System.in);
		int userin; // temp variable used to get input from user
		int tick_amt = 0; // holds total amount of games being purchased
		int gamecost = 0; // holds per game cost
		int seats = 0; // amount of tickets being purchased for each game
		boolean parking; // if user wants parking
		boolean confirm; // if everything was confirmed or not
		
		
		// TODO work on tabbing for beginning sequence
		System.out.println("***Welcome to the Royals 2015 Season Ticketing Application! ***");
		System.out.println("(Application developed by Jacob Dokos) ");
		System.out.println("----Show your Royal Blue Pride! ----- \n");
		
		System.out.println("Please select one of the Season Ticket Plans listed below: ");
		System.out.println("1) Full Season Plan (tickets to all 81 regular season games!)");
		System.out.println("2) Half Season Plan (tickets to 40 regular season games)");
		System.out.println("3) Quarter Season Plan (tickets to 20 regular season games) \n");
		
		// TODO add in error checking for ticket selection
		System.out.print("Selection: ");
		userin = Integer.parseInt(s.nextLine());
		
		// changing user input to game amount
		if (userin == 1)
			tick_amt = 81;
		else if (userin == 2)
			tick_amt = 40;
		else if (userin == 3)
			tick_amt = 20;
		else System.out.print("ERROR!");
		
		// TODO work on spacing
		System.out.println("Please select one of the Seating Options listed below:");
		System.out.println("	Seating Per Game");
		System.out.println("1) BATS Crown Club Seats $220");
		System.out.println("2) Diamond Club Box $86");
		System.out.println("3) Dugout Box $48");
		System.out.println("4) Dugout Plaza $37");
		System.out.println("5) Field Box $34");
		System.out.println("6) Outfield Box $25");
		System.out.println("7) Field Plaza $27");
		System.out.println("8) Loge Infield $34");
		System.out.println("9) Hy-Vee Box $15 \n");

		System.out.print("Selection: ");
		userin = Integer.parseInt(s.nextLine());
		
		// changing user input to cost per ticket
		if (userin == 1)
			gamecost = 220;
		else if (userin == 2)
			gamecost = 86;
		else if (userin == 3)
			gamecost = 48;
		else if (userin == 4)
			gamecost = 37;
		else if (userin == 5)
			gamecost = 34;
		else if (userin == 6)
			gamecost = 25;
		else if (userin == 7)
			gamecost = 27;
		else if (userin == 8)
			gamecost = 34;
		else if (userin == 9)
			gamecost = 15;
		else System.out.println("ERROR!2");
		
		System.out.print("How many seats would you like to purchase?");
			seats = Integer.parseInt(s.nextLine());
			
		System.out.println("A single parking pass is available for purchase at a discounted rate of $8 per game (regularly");
		System.out.println("$10). (You will be charge for all games of a given package.) ");
		System.out.print("Would you like to include parking? (Y or N): ");
		
		// TODO parse parking into bool String into bool
		parking = Boolean.parseBoolean(s.nextLine());
		
		// to clean everything up i will declare some variables for subtotals
		double subtotal = ((tick_amt * gamecost) * seats);
		double totaltax = subtotal * tax;
		
		System.out.println("YO you bought sum ticket bitch."); // TODO add ability to detect amount and display accordingly
		System.out.println("Ticket Total: " + subtotal);
		System.out.println("Tax: " + totaltax);
		
		if (parking)
			System.out.println("Parking: " + (8 * tick_amt));
		
		System.out.println("Grand Total: " + (subtotal + totaltax + (8 * tick_amt)));
		
		// TODO confirm order and display amount

		
		
		
			
			
		
		
	}

}
