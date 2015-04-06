package conditionals2;

import java.io.*;

/*************************************************************************************************************
* Calculates a grade for a student based on a given score and a amount of points able to be earned. Then sorts all students
* by overall score.
* 
* Jacob Dokos
* 
* Proj7.java
* 
**************************************************************************************************************/ 

import java.util.*;

public class StudentApp {
	
	private static Student[] stud_list = new Student[20]; // list of students that the user can enter
	
	public static void main(String[] args) throws IOException 
	{
		//TODO add in methods to free up main
		Scanner s = new Scanner(System.in);
		
		//Scanner s_file = new Scanner(new File("proj7.txt")); // open link to file

		
		System.out.print("What is the max point possible for Labs? ");
		Student.totalLabs = Double.parseDouble(s.nextLine());
		
		System.out.print("What is the max point possible for Projects? ");
		Student.totalProj = Double.parseDouble(s.nextLine());
		
		System.out.print("What is the max point possible for Exams? ");
		Student.totalExam = Double.parseDouble(s.nextLine());
		
		System.out.print("What is the max point possible for CodeLab? ");
		Student.totalCode = Double.parseDouble(s.nextLine());
		
		System.out.print("What is the max point possible for Final Exam? ");
		Student.totalFinal = Double.parseDouble(s.nextLine());
		

		
		int count = 0; // used in for loop
		do
		{
			String[] stud = new String[8];
			/*
			 * 0 - First
			 * 1 - Last
			 * 2 - WID
			 * 3 - Labs
			 * 4 - Projects
			 * 5 - Exams
			 * 6 - Codelab
			 * 7 - Final
			 */
			
			System.out.print("What is the student's first name? ");
			stud[0] = s.nextLine();
			
			System.out.print("What is the student's last name? ");
			stud[1] = s.nextLine();
			
			System.out.print("What is the student's WID? ");
			stud[2] = s.nextLine();
			
			System.out.print("What is the student's grade for Labs? ");
			stud[3] = s.nextLine();
			
			System.out.print("What is the student's grade for Projects? ");
			stud[4] = s.nextLine();
			
			System.out.print("What is the student's grade for Exams? ");
			stud[5] = s.nextLine();
			
			System.out.print("What is the student's grade for CodeLab? ");
			stud[6] = s.nextLine();
			
			System.out.print("What is the student's grade for the Final Exam? ");
			stud[7] = s.nextLine();
			
			stud_list[count++] = new Student(stud[0], stud[1], stud[2], Double.parseDouble(stud[3]), Double.parseDouble(stud[4]), Double.parseDouble(stud[5]), Double.parseDouble(stud[6]), Double.parseDouble(stud[7]) );
			
			

			
		}
		while (runAgain() && count < 20 );
		//used when reading in from file
		//while (rerunprog && count < 20 && s.hasNextLine() );
		
		s.close();
		
		swapStudent(count);				
		
	}
	
	private static void swapStudent(int count)
	{
		double temp_pos;
		double temp_val;
		boolean swap = false;
		double[][] swapArray = new double[count][2];
		
		//filling the array
		for (int i = 0; i < swapArray.length; i++)
		{
			swapArray[i][0] = i;
			swapArray[i][1] = stud_list[i].getOverall();
		}
		
		//bubble sort the array by overall score
		do
		{
			swap = false;
			for (int  j = 0; j < swapArray.length - 1; j++)
			{
				if (swapArray[j][1] < swapArray[j + 1][1])
				{
					temp_pos = swapArray[j][0];
					temp_val = swapArray[j][1];
					
					swapArray[j][0] = swapArray[j + 1][0];
					swapArray[j][1] = swapArray[j + 1][1];
					
					swapArray[j + 1][0] = temp_pos;
					swapArray[j + 1][1] = temp_val;
					swap = true;
				}				
			}			
		}
		while (swap);	
		
		//may not be needed
		/*
		int[] intSwap = new int[swapArray.length];
		for (int i = 0; i < intSwap.length; i++)
		{
			intSwap[i] = (int) swapArray[i][0];
		}
		*/
		printStudent(swapArray);
	}
	
	
	private static void printStudent(double[][] list)
	{
		Scanner s_enter = new Scanner(System.in);
		for (int i = 0; i < list.length; i++)
		{
			System.out.print( stud_list[ (int) list[i][0] ] );
			System.out.print("\tPress enter to display next student... ");
			s_enter.nextLine(); // used to wait for enter key
			
		}
		s_enter.close();
		
	}
	
	private static boolean runAgain()
	{
		Scanner s = new Scanner(System.in);
		boolean rerunprog = false;
		String struserin = " ";
		
		//gets input from user if they want to continue program
		System.out.print("\nRun program again? (y/n) ");		
			struserin = s.nextLine();
		
		if (struserin.charAt(0) == 'Y' || struserin.charAt(0) == 'y')
		{
			rerunprog = true;
			System.out.print("\n");
		}
		else if (struserin.charAt(0) == 'N' || struserin.charAt(0) == 'n')
			rerunprog = false;
		
		s.close();
		return rerunprog;
	}
	

	
}
