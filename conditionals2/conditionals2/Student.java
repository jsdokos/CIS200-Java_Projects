package conditionals2;

import java.text.DecimalFormat;

/*************************************************************************************************************
* Calculates a grade for a student based on a given score and a amount of points able to be earned. Then sorts all students
* by overall score.
* 
* Jacob Dokos
* 
* Proj7.java
* 
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
	
	public static double totalLabs;
	public static double totalProj;
	public static double totalExam;
	public static double totalCode;
	public static double totalFinal;
	

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
	
	public double getOverall()
	{
		return overall;
	}
	
	public void setOverall(double newOver)
	{
		if (newOver >= 0)
		overall = newOver;
		else
			return;
	}


	
	
	
	
}
