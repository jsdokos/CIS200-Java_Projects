package conditionals2;

import java.text.DecimalFormat;

/*************************************************************************************************************
* Student.java - Project 7
* Jacob Dokos CIS200 - 02L
* Extra credit wasattempted.
*
* Used to store information about a student. Stores their first, last name and wid along with all grades. 
* There is also a static variable that stores the total points possible for all the students.
**************************************************************************************************************/ 

public class Student 
{
	private String first;
	private String last;
	private String wid;
	private double lab;
	private double project;
	private double exams;
	private double codelab;
	private double final_exam;
	private double overall;
	
	private final double labProj_adj = .15;
	private final double allExam_adj = .30;
	private final double codeLab_adj = .10;
	
	//used by the entire class to know what the total score is.
	public static double totalLabs;
	public static double totalProj;
	public static double totalExam;
	public static double totalCode;
	public static double totalFinal;
	
	/*************************************************************************************************************
	* Description: The default constructor for the student class. Used if the person want to create a blank student.
	* 
	* Parameters: none.
	* 
	* Return: none.
	**************************************************************************************************************/ 
	public Student()
	{
		first = "no name entered";
		last = "no name entered";
		wid = "no WID";
		lab = 0;
		project = 0;
		exams = 0;
		codelab = 0;
		final_exam = 0;
		overall = 0;		
	}
	
	/*************************************************************************************************************
	* Description: Constructor for the class when the student enters all data points. Used to set the variables equal to the 
	* class variables.
	* 
	* Parameters:
	* fir - The first name of the student
	* las - The last name of a student
	* stud_wid - The student's WID
	* lab_score - Score on labs
	* project_score - Score on projects
	* exam_score - Exams scores
	* codelab_score - Codelab score
	* fina_exam_score - Final exam score
	* 
	* Return: None.
	**************************************************************************************************************/ 
	public Student(String fir, String las, String stud_wid, double lab_score, double project_score, double exam_score, double codelab_score, double final_exam_score)
	{
		first = fir;
		last = las;
		wid = stud_wid;
		lab = lab_score;
		project = project_score;
		exams = exam_score;
		codelab = codelab_score;
		final_exam = final_exam_score;
		overall = calcOverall();
		
	}
	
	/*************************************************************************************************************
	* Description: Used to calculate the overall grade of a student based on the total points possible and
	* the student's score.
	* 
	* Parameters: None.
	* 
	* Return: 
	* Ruturns the students overall score.
	**************************************************************************************************************/ 
	private double calcOverall()
	{
		double totalPointsPossible = totalLabs + totalProj + totalExam + totalCode + totalFinal;
		double total;
		
		//           (points earned / points possible) * (weight * total points possible)
		total = ( ((lab / totalLabs) * (labProj_adj * totalPointsPossible)) + 
				((project / totalProj) * (labProj_adj * totalPointsPossible)) + 
				((exams / totalExam) * (allExam_adj * totalPointsPossible)) + 
				((codelab / totalCode) * (codeLab_adj * totalPointsPossible)) + 
				((final_exam / totalFinal) * (allExam_adj * totalPointsPossible)) );
		
		//System.out.println(total + " " + totalPointsPossible);
		return ((total  / totalPointsPossible ) * 100);
	}
	
	/*************************************************************************************************************
	* Description: Displays all the information about the student is an ordered list. Calculates the letter
	* grade based on the students overall score
	* 
	* Parameters: None.
	* 
	* Return:
	* student_ret - the string that will be printed when this function is called. Show's all information about a student.
	**************************************************************************************************************/ 
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#0.0"); 
		char letGrade = '?';
		
		//not sure about the logic here. Might be wasteful
		// should just keep updating the higher it is since 88 > 77
		if (overall <= 58.5)
			letGrade = 'F';
		else if (overall > 58.5)
			letGrade = 'D';
		else if (overall >= 68.5)
			letGrade = 'C';
		else if (overall >= 79.5)
			letGrade = 'B';
		else if (overall >= 89.5)
			letGrade = 'A';
		else
			System.out.println("How did you get here?");
		
		String student_ret = ("\nStudent Name: " + last + ", " + first + 
				"\nWID: " + wid +
				"\nOverall %: " + df.format(overall) + "%" + 
				"\nFinal Grade: " + letGrade);
			
		return student_ret;
	}
	
	/*************************************************************************************************************
	* Description: Gets the overall score without letting the program change it.
	* 
	* Parameters: None.
	* 
	* Return:
	* overall - returns the overall score for the object.
	**************************************************************************************************************/ 
	public double getOverall()
	{
		return overall;
	}


	
	
	
	
}
