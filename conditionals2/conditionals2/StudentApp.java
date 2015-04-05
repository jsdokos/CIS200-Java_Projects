package conditionals2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentApp {
	

	public static void main(String[] args) throws IOException 
	{
		//TODO add in methods to free up main
		Scanner s = new Scanner(System.in);
		
		Scanner s_file = new Scanner(new File("proj7.txt")); // open link to file
		boolean rerunprog = false;
		
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
		
		Student[] stud_list = new Student[20];
		
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
			
			
			//TODO make this into a method
			String struserin = " ";
			
			//gets input from user if they want to continue program
			//System.out.print("\nRun program again? (y/n) ");		
				struserin = s.nextLine();
			
			if (struserin.charAt(0) == 'Y' || struserin.charAt(0) == 'y')
			{
				rerunprog = true;
				System.out.print("\n");
			}
			else if (struserin.charAt(0) == 'N' || struserin.charAt(0) == 'n')
				rerunprog = false;
			
		}
		while (rerunprog && count <= 20 && s.hasNextLine() );
		
		
		for (int i = 0; i < count; i++)
		{
			System.out.print(stud_list[i]);
			s.nextLine(); // used to wait for enter key
			
		}
		
		
	}
	
}
