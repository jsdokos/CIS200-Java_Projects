/*************************************************************************************************************
* Proj1_Part2.java
* Jacob Dokos CIS200 - 02L
* trying another thing
*
* Takes input from the user and displays it back to the user with the added information of the total with tax.
**************************************************************************************************************/ 

import java.util.*;
import java.text.*;

public class Proj1_Part2 
{
	static double tax_rate = .0615;
	
	public static void main(String[] args) 
	{
		// declaring variables
		String brand;
		String model;
		double cost;
		
		Scanner s = new Scanner(System.in);
		DecimalFormat df1 = new DecimalFormat("#,00.00");
		DecimalFormat df2 = new DecimalFormat("#,000.00");
		
		// getting input from user
		System.out.print("What brand of computer do you wish to purchase? ");
			brand = s.nextLine();
		
		System.out.print("Which model? ");
			model = s.nextLine();
		
		System.out.print("Enter the cost of the computer: ");
			cost = Double.parseDouble(s.nextLine());
			
		// outputting information to user
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Sales tax: $" + df1.format((cost * tax_rate)));
		System.out.println("Total Cost: $" + df2.format(((cost * tax_rate) + cost)));
		
	}

}