import java.util.*;
import java.text.*;

public class proj4 
{

	public static void main(String[] args) 
	{
		boolean[][] used = new boolean[4][13];
		int[][] hand = new int[5][5];
		Random r = new Random();
		int suit;
		int cardval;
		int j = 0;
		
		for (int i = 0; i < 5; i++)
		{
			
			//gets a card and makes sure it's not used already
			do
			{
				suit =  r.nextInt(4);
				cardval =  r.nextInt(13);
				
				//System.out.println(test++);
			}
			while (used[suit][cardval] == true);
			
			// sets the one that have been used to true so it won't be used anymore
			used[suit][cardval] = true;
			

			//need to find the best way to hold the card suit and value
			
			System.out.println(suit + " " + cardval);
			
		}
		
	}

}
