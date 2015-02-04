
import java.util.*;

public class lab3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean class_done = false; // bool for determinig whether to continue
		String sectionname;
		String strinput;
		double count = 0; // counting for one section
		double average = 0; // average score for one sections
		double topscore = 0; // top score in one section
		double lowscore = 100; // lowest score in one section
		double totalscore = 0; // total score in one section
		double input = 0; // used as temp to get input from user
		double high_sect_score = 0;
		double sect_tot_count = 0; // total number of scores entered
		double sect_tot_total = 0; // totoal of all score among all sections
		
		do
		{
			System.out.print("Please enter the section name: ");
			sectionname = s.nextLine();
			
		
			// getting input for one sections
			while (input >= 0)
			{
				System.out.print("Please enter a number: ");
				input = Double.parseDouble(s.nextLine()); // gets input 
				count++; // adds onto saying you got input
				totalscore += input;
				
				if  (input > topscore) // checks to see if it is the top score
					topscore = input;
				
				if (input < lowscore && input > 0) // finds low score
					lowscore = input;	
				
				if (input < 0) // getting rid of the negative number input
				{
					totalscore += Math.abs(input);
					count--;
				}
				
			}
			
			average = totalscore / count;
			
			if (topscore > high_sect_score) // finds highest score over all sections
				high_sect_score = topscore;
			
			sect_tot_count += count;
			sect_tot_total += totalscore;
			
			//System.out.println("Total count: " + sect_tot_count + "\nTotal score over all sections: " + sect_tot_total); // error checking
			
			
			//System.out.println(input); // testing
			System.out.println("\n" + sectionname);
			System.out.println("Number of scores entered: " + count);
			System.out.println("Top score: " + topscore);
			System.out.println("Low score: " + lowscore);
			System.out.println("Average: " + average);
			
			// getting input from user on if they want to continue
			System.out.print("Do you want to continue? (Y or N) ");
			strinput = s.nextLine();
			
			if (strinput.charAt(0) == 'Y')
				class_done = true;
			else if (strinput.charAt(0) == 'N')
				class_done = false;
			
			// setting variables to default for next class
			count = 0;
			average = 0;
			topscore = 0;
			lowscore = 100;
			totalscore = 0;
			input = 0;
			
			
		}
		while (class_done);
		
		System.out.println("\nHighest score over all sections: " + high_sect_score);
		System.out.println("Average over all sections: " + (sect_tot_total / sect_tot_count)); // displays average overall sections
		
	}

}
