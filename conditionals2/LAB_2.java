/*************************************************************************************************************
* LAB_2.java
* Jacob Dokos CIS200 - 02L
* 
*
* File for lab on 1/28/15. File to find the GPA given a number of classes and a grade.
**************************************************************************************************************/ 

import java.text.DecimalFormat;
import java.util.*;


public class LAB_2 
{

	public static void main(String[] args)
	{
		
		double gpa = 0;
		
		double credit1;
		String grade_input;
		char grade1;
		double score1 = 0;
		int totalcred = 0;
		int count = 0;
		boolean error = false;
		DecimalFormat df = new DecimalFormat("#0.00"); // format for displaying final value
		
		Scanner s = new Scanner(System.in);
		
		while ((count < 4) && (error != true))
		{
			System.out.print("How many credits was the class worth? ");
				credit1 = Integer.parseInt(s.nextLine());
			
			System.out.print("What grade did you recieve? ");
				grade_input = s.nextLine();
				grade1 = grade_input.charAt(0);
				
			if (grade1 == 'A' || grade1 == 'a')
				score1 = (4.0 * credit1);
			else if (grade1 == 'B' || grade1 == 'b')
				score1 = (3.0 * credit1);
			else if (grade1 == 'C' || grade1 == 'c')
				score1 = (2.0 * credit1);
			else if (grade1 == 'D' || grade1 == 'd')
				score1 = (1.0 * credit1);
			else if (grade1 == 'F' || grade1 =='f')
				score1 = 0.0;
			else
			{
				System.out.println("Invalid Grade");
				error = true;
			}
			
			totalcred += (credit1);
			gpa += (score1);
			
			//System.out.println(gpa + " " + score1 + " " + totalcred); // error checking
			count++;
		}
		
		if (error != true)
		System.out.println("Your GPA is: " + df.format((gpa / totalcred)));
		
	}
}
