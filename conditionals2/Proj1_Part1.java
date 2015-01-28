/*************************************************************************************************************
* Proj1_Part1.java
* Jacob Dokos CIS200 - 02L
* Trying if then
*
* Takes input from the user and displays monthly payments with tax and the total payments.
**************************************************************************************************************/ 

import java.util.*;
import java.text.*;

public class Proj1_Part1 
{
	static double rate = .02; //2% financing
	static int term = 6; // amount of time in months
	
	public static void main(String[] args) 
	{
		double price;
		boolean error = true; // boolean to describe if there is an error in the program
		
		Scanner s = new Scanner(System.in); //used to read in data
		DecimalFormat df = new DecimalFormat("#0.00"); // format for displaying final value 
		
		while(error) // assume that there is an error until proven false
		{
			System.out.print("Enter the amount of the purchase: ");
				price = Double.parseDouble(s.nextLine());
			
				if (price <= 0.0)
				{
					System.out.println("ERROR!, Please enter an amount greater than 0.");
				}	
				else
				{	
					error = false;
					System.out.println("Your monthly payment is $" + df.format(((price * rate) + price) / term));		
					System.out.println("Your total payment is $" + df.format((price * rate) + price));
				}
		}
	}

}