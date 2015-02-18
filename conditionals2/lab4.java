import java.text.*;
import java.util.*;

public class lab4
{
	
	static char[] ANSWERS = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'A'}; // 12 variables
	
	
	public static void main(String[] args) 
	{
		
		DecimalFormat df = new DecimalFormat("#0.0");
		String name;
		char[] grades_input = new char[12];		
		Scanner s = new Scanner(System.in);
		int students = 0;
		double max_grade = 0;
		double low_grade = 13;
		double avg_grade = 0;
		
		// get the number of students in the class
		System.out.print("How many students are in the class? ");
		students = Integer.parseInt(s.nextLine());
		
		for (int i = 1; i <= students; i++)
		{
			int grade = 0;
			System.out.print("\nEnter the name for student " + i + ": ");
			name = s.nextLine();
			
			//gets input through the array
			for (int k = 0; k < grades_input.length; k++)
			{
				System.out.print("Enter the answers for question " + (k+1) + ": ");
				grades_input[k] = s.nextLine().charAt(0);
			}
			
			for (int j = 0; j < grades_input.length; j++)
			{
				if (grades_input[j] == ANSWERS[j])
					grade++;			
			}
			
			//find low score
			if ((grade) < low_grade)
				low_grade = (grade);
			
			//find high score
			if ((grade) > max_grade)
				max_grade = (grade);
			
			avg_grade += (grade);
			
			System.out.println("\n" + df.format(((grade/12.0) * 100.0)) + "\n" + name);
			
		}
		
		System.out.println("The high score is " + max_grade + " and the low score is " + low_grade);
		System.out.println("The average score is: " + df.format((((avg_grade / students) / 12.0) * 100.0)) + "%");


	}

}
