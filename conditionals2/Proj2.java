// Started midnight on 1/31

import java.util.*;
import java.text.*;

public class Proj2 
{
	static double tax = .0625;
	
	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		int userin; // temp variable used to get input from user
		int tick_amt = 0; // holds total amount of games being purchased
		int gamecost = 0; // holds per game cost
		int seats = 0; // amount of tickets being purchased for each game
		boolean parking = false; // if user wants parking
		boolean confirm = false; // if everything was confirmed or not
		boolean error = false;
		
		// display the beginning sequence
		System.out.println("***Welcome to the Royals 2015 Season Ticketing Application! ***");
		System.out.println("	(Application developed by Jacob Dokos) ");
		System.out.println("	 ----Show your Royal Blue Pride!----- \n");
		
		System.out.println("Please select one of the Season Ticket Plans listed below: ");
		System.out.println("1) Full Season Plan (tickets to all 81 regular season games!)");
		System.out.println("2) Half Season Plan (tickets to 40 regular season games)");
		System.out.println("3) Quarter Season Plan (tickets to 20 regular season games) \n");
		
		// has user input a value if not in accepted parameters it makes an error state until the user puts in a valid number
		do
		{
			
			System.out.print("Selection: ");
			userin = Integer.parseInt(s.nextLine());
			
			// changing user input to game amount
			if (userin == 1)
			{
				tick_amt = 81;
				error = false;
			}
			else if (userin == 2)
			{
				tick_amt = 40;
				error = false;
			}
			else if (userin == 3)
			{
				tick_amt = 20; 
				error = false;
			}
			else 
			{
				System.out.println("Not a valid Plan selected. Enter 1-3 only");
				error = true;
			}
		} 
		while (error);
		
		userin = 0; // clearing variable for use next time

		//displays seating options for the user to choose from
		System.out.println("Please select one of the Seating Options listed below:");
		System.out.println("Seating				Per Game");
		System.out.println("1) BATS Crown Club Seats 	    $220");
		System.out.println("2) Diamond Club Box 		     $86");
		System.out.println("3) Dugout Box 			     $48");
		System.out.println("4) Dugout Plaza 	 	     $37");
		System.out.println("5) Field Box 		 	     $34");
		System.out.println("6) Outfield Box 		     $25");
		System.out.println("7) Field Plaza 			     $27");
		System.out.println("8) Loge Infield 		     $34");
		System.out.println("9) Hy-Vee Box 			     $15 \n");

		//gets input from user
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
		else
		{
			System.out.println("Not a valid Seating option. 1-9 only");
			return;
		}
		userin = 0; // clearing variable
		
		// gets input from user on how many seats they are purchasing
		System.out.print("\nHow many seats would you like to purchase? ");
			seats = Integer.parseInt(s.nextLine()); 
			
		System.out.println("\nA single parking pass is available for purchase at a discounted rate of $8 per game (regularly");
		System.out.println("$10). (You will be charge for all games of a given package.) ");
		System.out.print("Would you like to include parking? (Y or N): ");
		
		// input from user on if they want parking
		String struserin;
		struserin = s.nextLine();
		//TODO loop to error check
		if (struserin.charAt(0) == 'Y')
			parking = true;
		else if (struserin.charAt(0) == 'N')
			parking = false;
		
		struserin = " "; // clearing variable
		
		// to clean everything up i will declare some variables for subtotals
		double subtotal = ((tick_amt * gamecost) * seats);
		double totaltax = subtotal * tax;
		double parkingtotal = 8.0 * tick_amt;
		
		
		// displaying header for final values
		System.out.print("\nYou purchased the ");
		if (tick_amt == 81)
			System.out.print("Full Season 81-game plan / " + seats);
		else if (tick_amt == 40)
			System.out.print("Half Season 40-game plan / " + seats);
		else if (tick_amt == 20)
		System.out.print("Quarter Season 20-game plan / " + seats);
		
		if (gamecost == 220)
			System.out.println(" BATS crown club tickets");
		else if (gamecost == 86)
			System.out.println(" Diamond Club tickets");
		else if (gamecost == 48)
			System.out.println(" Dugout Box tickets");
		else if (gamecost == 37)
			System.out.println(" Dugout Plaza tickets");
		else if (gamecost == 34)
			System.out.println(" Field Box tickets");
		else if (gamecost == 25)
			System.out.println(" Outfield Box tickets");
		else if (gamecost == 27)
			System.out.println(" Field Plaza tickets");
		else if (gamecost == 34)
			System.out.println(" Loge Infield tickets");
		else if (gamecost == 15)
			System.out.println(" Hy-Vee Box tickets");
			
			
		//displaying final values	
		System.out.println("Ticket Total: $" + df.format(subtotal));
		System.out.println("Tax: $" + totaltax);
		
		if (parking)
		{
			System.out.println("Parking: $" + df.format(parkingtotal));
			System.out.println("Grand Total: $" + df.format((subtotal + totaltax + parkingtotal)));
		}
		else
			System.out.println("Grand Total: $" + df.format((subtotal + totaltax)));
		
		// input from user on if they would like to confirm the order
		System.out.print("Confirm Order (Y or N)? ");	
		struserin = s.nextLine();
		
		if (struserin.charAt(0) == 'Y' || struserin.charAt(0) == 'y')
			confirm = true;

		if (confirm)
			System.out.println("\nOrder was confirmed. $" + df.format(subtotal + totaltax) + " will be charged to the account on file.");
		else
			System.out.println("Purchase not confirmed. Rerun the application to reselect tickets.");
		
		
		// TODO loop entire program until user wants to quit
	}

}
