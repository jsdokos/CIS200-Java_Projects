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

	public static void main(String[] args) 
	{
		double rate = .02; //2% financing
		int term = 6; // amount of time in months
		double price;
		boolean error = true;
		
		Scanner s = new Scanner(System.in); //used to read in data
		DecimalFormat df = new DecimalFormat("#0.00"); // format for displaying final value 
		
		while(error)
		{
			System.out.print("Enter the amount of the purchase: ");
				price = Double.parseDouble(s.nextLine());
			
				if (price <= 0.0)
				{
					System.out.println("ERROR!, Please enter an amount greater than 0.");
					System.out.println("\n\n\n\n\n\n\n\n\n"); // add more new lines
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