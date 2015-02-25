import java.util.*;
import java.text.*;

public class proj4 
{

	public static void main(String[] args) 
	{
		boolean[][] used = new boolean[4][13];
		Random r = new Random();
		int suit;
		int cardval;
		
		int[] hand_suit = new int[5];
		int[] hand_cardval = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			
			//gets a card and makes sure it's not used already
			do
			{
				suit =  r.nextInt(4);
				cardval =  r.nextInt(13);
				
				// puts card in 'hand'
				hand_suit[i] = suit;
				hand_cardval[i] = cardval;
			}
			while (used[suit][cardval] == true);
			
			// sets the one that have been used to true so it won't be used anymore
			used[suit][cardval] = true;
			
			System.out.println(suit + " " + cardval);
			
		}
		//TODO output the cards
		
		//bubble sorts the cards and suits
		
		boolean swap = true;
		int temp;
		
		//puts the suits in order
		do
		{
			swap = false;
			for(int i = 0; i < hand_suit.length - 1; i++)
			{
				if (hand_suit[i] > hand_suit[i + 1])
				{
					temp = hand_suit[i];
					hand_suit[i] = hand_suit[i + 1];
					hand_suit[i + 1] = temp;
					swap = true;
				}
			}
		}
		while(swap);
		
		//puts the cards in order
		do
		{
			swap = false;
			for(int i = 0; i < hand_cardval.length - 1; i++)
			{
				if (hand_cardval[i] > hand_cardval[i + 1])
				{
					temp = hand_cardval[i];
					hand_cardval[i] = hand_cardval[i + 1];
					hand_cardval[i + 1] = temp;
					swap = true;
				}
			}
		}
		while(swap);
		
		System.out.println();
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(hand_suit[i]+ " " + hand_cardval[i]);
		}
		
	}

}
