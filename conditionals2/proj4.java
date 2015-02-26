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
		
		//int[][] hand = new int[5][2];
		//int[][] hand = { {0,0}, {11,1}, {12,3}, {10,2}, {7,0} };
		int[][] hand = { {0,0}, {3,1}, {1,3}, {1,2}, {1,0} };

		
		//TODO 2d array for display
		/*
		for (int i = 0; i < 5; i++)
		{		
			//gets a card and makes sure it's not used already
			do
			{
				suit =  r.nextInt(4);
				cardval =  r.nextInt(13);
				
			}
			while (used[suit][cardval] == true);
			
			// sets the one that have been used to true so it won't be used anymore
			used[suit][cardval] = true;
			

			hand[i][0] = cardval;
			hand[i][1] = suit;
			
			System.out.println(cardval + " " + suit);
			
		}
		*/
		
		System.out.println(" **Welcome to the 2015 Las Vegas Poker Festival!** " );
		System.out.println("     (Application developed by Jacob Dokos) ");
		System.out.println("Shuffling cards... ");
		System.out.println("Dealing the cards... ");
		System.out.println("Here are your five cards... ");
		//TODO output the cards
		
		boolean swap = true;
		int temp_card;
		int temp_suit;
		

		
		//bubble sort of hand
		//TODO think about outputting cards then bubble sorting
		do
		{
			swap = false;			
			for (int j = 0; j < hand.length - 1; j++)
			{			
				if (hand[j][0] > hand[j+1][0])
				{
					temp_card = hand[j][0];
					temp_suit = hand[j][1];
					
					hand[j][0] = hand[j+1][0];
					hand[j][1] = hand[j + 1][1];
					
					hand[j+1][0] = temp_card;
					hand[j + 1][1] = temp_suit;
					swap = true;
				}				
			}		
		}
		while (swap);
		
		
		/*for (int k = 0; k < 5; k++)
		{
			System.out.println(hand[k][0] + " " + hand[k][1]);
		}
		System.out.println();
		*/
		
		//printing out the cards in english
		String[] str_card = new String[5];
		for (int i = 0; i < 5; i++)
		{
			
			switch(hand[i][0]) 
			{
				case 0:
					str_card[i] = "Ace";
					break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					str_card[i] = Integer.toString(hand[i][0]);
					break;
				case 10:
					str_card[i] = "Jack";
					break;
				case 11:
					str_card[i] = "Queen";
					break;
				case 12:
					str_card[i] = "King";
					break;
				default:
					str_card[i] = "?";
			}
			
			switch(hand[i][1])
			{
				case 0:
					str_card[i] += " of Clubs";
					break;
				case 1:
					str_card[i] += " of Diamonds";
					break;
				case 2:
					str_card[i] += " of Hearts";
					break;
				case 3:
					str_card[i] += " of Spades";
					break;
				default:
					str_card[i] += " of I-dunno";
			}
				
			System.out.println("	" + str_card[i]);
		}
		
		//gets card frequency
		int[] card_freq = new int[13];
		
		for (int i = 0; i < card_freq.length; i++)
		{
			for (int j = 0; j < hand.length; j++)
			{
				if (hand[j][0] == i)
					card_freq[i]++;
			}
		}
		
		//bubble sort for card frequency
		int temp;
		do
		{
			swap = false;			
			for (int j = 0; j < card_freq.length - 1; j++)
			{			
				if (card_freq[j] < card_freq[j + 1])
				{
					temp = card_freq[j];
					card_freq[j] = card_freq[j + 1];
					card_freq[j + 1] = temp;
					swap = true;
				}				
			}		
		}
		while (swap);
		
		//checking for flush
		//checks to see if all suits are the same
		boolean flush = false;
		do
		{
			for (int i = 0; i < hand.length - 1; i++)
			{
				if (hand[i][1] == hand[i + 1][1])
					flush = true;
				else
					flush = false;
			}
		}
		while (flush);
		
		//checks for a flush
		boolean straight = false;
		if (hand[0][0] - hand[4][0] == 4)
			straight = true;
		
		//testing
		/*for (int i = 0; i < 13; i++)
			System.out.print(card_freq[i] + " ");
			*/
		if (flush && hand[0][0] == 12 && hand[1][0] == 11 &&  hand[2][0] == 10 && hand[3][0] == 9 && hand[4][0] == 8)
			System.out.println("You were dealt a Royal Flush!!!!"); // royal flush
		else if (straight && flush)
			System.out.println("You were dealt a straight flush."); // straight flush
		else if (card_freq[0] == 4) 
			System.out.println("You were dealt four of a kind"); // four of a kind
		else if (card_freq[0] == 3 && card_freq[1] == 2)
			System.out.println("You were dealt a full house."); // full house
		else if (straight)
			System.out.println("You were dealt a straight."); // straight
		else if (card_freq[0] == 3 && card_freq[1] != 2)
			System.out.println("You were dealt three of a kind."); // three of a kind
		else if (card_freq[0] == 2 && card_freq[1] == 2 && card_freq[2] == 1)
			System.out.println("You were dealt two pair.");
		else if (card_freq[0] == 1 && card_freq[1] == 1)
			System.out.println("You were dealt a pair.");
		
		System.out.println("High card is a(n) " + str_card[0] + ".");
		
		

		

		
	}
}
