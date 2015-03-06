

import java.util.*;
import java.io.*;

public class lab5 
{
	public static void main(String[] args) throws IOException 
	{
		int count_file = 0;
		Scanner s_file = new Scanner(new File("words.txt")); // open link to file
		Random r = new Random(); // random num generator
		
		//read in the file-size
		int line = Integer.parseInt(s_file.nextLine());
		
		String[] file_list = new String[line]; // create an array for the file
		
		// read in file to array
		while (s_file.hasNext())
		{
			for (int i = 0; s_file.hasNext(); i++)
			{
				file_list[i] = s_file.nextLine();
				count_file++;
			}
		}
		
		s_file.close(); // done reading file
		
		//randomly chooses a word from the list
		String correct = file_list[r.nextInt(count_file)];
		
		// creates an array the same length as the correct word

		Scanner s = new Scanner(System.in);
		String input;
		int guess = 0;
		
		while (true)
		{
		
			boolean[] used = new boolean[correct.length()];			
			StringBuilder build = new StringBuilder();
			
			int count = 0;
			
			while (count < correct.length())
			{
				int index = r.nextInt(correct.length());
				
				if (used[index] == false)
				{
					build.append(correct.charAt(index));
					used[index] = true;
					count++;
				}
			}
			System.out.println("The jumbled word is " + build.toString());
			System.out.println(correct);//testing
			System.out.print("Please guess the word: ");
			input = s.nextLine();
			
			if (input.equals(correct))
			{
				System.out.println("You have guessed correctly. It took you " + ++guess + " tries.");
				break;
			}
			else
				guess++;
			
		} 
		s.close();
		
	}
}