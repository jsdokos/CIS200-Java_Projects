/*************************************************************************************************************
* Proj4.java
* Jacob Dokos CIS200 - 02L
*
* Grabs cards from a deck and then out puts the cards to the screen
* tells the user what hand they have
* Extra credit has been completed
**************************************************************************************************************/ 



import java.util.*;

public class proj4 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		boolean rerunprog = true; // boolean for the program to know if it needs to rerun
		do
		{
			boolean[][] used = new boolean[4][13]; // used to make sure that a card is only used once
			
			Random r = new Random();
			int suit; // temp variable for the suit of a card
			int cardval; // temp variable for the card value
			
			int[][] hand = new int[5][2]; // hand for player 1 
			int[][] hand2 = new int[5][2]; // hand for player 2

			//fills the hand for both players
			for (int i = 0; i < 10; i++)
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
				
				if(i < 5)
				{
					hand[i][0] = cardval; // filling player 1 hand
					hand[i][1] = suit;
				}
				else
				{
					hand2[i-5][0] = cardval; // filling player 2 hand
					hand2[i-5][1] = suit;
				}
				
			}		
			
			// introduction text
			System.out.println(" **Welcome to the 2015 Las Vegas Poker Festival!** " );
			System.out.println("     (Application developed by Jacob Dokos) ");
			System.out.println("Shuffling cards... ");
			System.out.println("Dealing the cards... ");
			//System.out.println("Here are your five cards... ");
			
			//variables for bubble sort
			boolean swap = true;
			int temp_card;
			int temp_suit;
						
			//bubble sort of hand = player 1
			do
			{
				swap = false;			
				for (int j = 0; j < hand.length - 1; j++)
				{			
					if (hand[j][0] < hand[j+1][0])
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
			
			//bubble sort of hand = player 2
			do
			{
				swap = false;			
				for (int j = 0; j < hand2.length - 1; j++)
				{			
					if (hand2[j][0] < hand2[j+1][0])
					{
						temp_card = hand2[j][0];
						temp_suit = hand2[j][1];
						
						hand2[j][0] = hand2[j+1][0];
						hand2[j][1] = hand2[j + 1][1];
						
						hand2[j+1][0] = temp_card;
						hand2[j+1][1] = temp_suit;
						swap = true;
					}				
				}		
			}
			while (swap);
			
			
			//translate the cards into english
			String[] str_card = new String[5];
			String[] str_card2 = new String[5];
			for (int i = 0; i < 5; i++)
			{
			//player 1	
				switch(hand[i][0]) 
				{
					case 0://2
					case 1://3
					case 2://4
					case 3://5
					case 4://6
					case 5://7
					case 6://8
					case 7://9
					case 8://10
						str_card[i] = Integer.toString(hand[i][0] + 2);
						break;
					case 9:
						str_card[i] = "Jack";
						break;					
					case 10:
						str_card[i] = "Queen";
						break;
					case 11:
						str_card[i] = "King";
						break;
					case 12:
						str_card[i] = "Ace";
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
				
				//player 2
				switch(hand2[i][0]) 
				{
					case 0://2
					case 1://3
					case 2://4
					case 3://5
					case 4://6
					case 5://7
					case 6://8
					case 7://9
					case 8://10
						str_card2[i] = Integer.toString(hand2[i][0] + 2);
						break;
					case 9:
						str_card2[i] = "Jack";
						break;					
					case 10:
						str_card2[i] = "Queen";
						break;
					case 11:
						str_card2[i] = "King";
						break;
					case 12:
						str_card2[i] = "Ace";
						break;
					default:
						str_card2[i] = "?";
				}
				
				switch(hand2[i][1])
				{
					case 0:
						str_card2[i] += " of Clubs";
						break;
					case 1:
						str_card2[i] += " of Diamonds";
						break;
					case 2:
						str_card2[i] += " of Hearts";
						break;
					case 3:
						str_card2[i] += " of Spades";
						break;
					default:
						str_card2[i] += " of I-dunno";
				}
			}
			
			//outputs the cards in the hand randomly
			//boolean array for each player
			boolean[] card_shown = new boolean[5];
			boolean[] card_shown2 = new boolean[5];
			
			//randomly outputs the cards for each player
			System.out.println("Player 1:");
			for(int i = 0; i < 5; i++)
			{
				int card_temp;
				do
				{
					card_temp = r.nextInt(5);
					if (card_shown[card_temp] == false)
						System.out.println("	" + str_card[card_temp]);			
				}
				while (card_shown[card_temp] == true); 
				
				card_shown[card_temp] = true;
				
			}
			System.out.println("Player 2:");
			//player 2
			for(int i = 0; i < 5; i++)
			{
				int card_temp;
				do
				{
					card_temp = r.nextInt(5);
					if (card_shown2[card_temp] == false)
						System.out.println("	" + str_card2[card_temp]);			
				}
				while (card_shown2[card_temp] == true); 
				
				card_shown2[card_temp] = true;
			}
			
			//gets card frequency of each hand
			int[] card_freq = new int[13];
			
			for (int i = 0; i < card_freq.length; i++)
			{
				for (int j = 0; j < hand.length; j++)
				{
					if (hand[j][0] == i)
						card_freq[i]++;
				}
			}
			
			int[] card_freq2 = new int[13];
			
			for (int i = 0; i < card_freq2.length; i++)
			{
				for (int j = 0; j < hand2.length; j++)
				{
					if (hand2[j][0] == i)
						card_freq2[i]++;
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
			
			do
			{
				swap = false;			
				for (int j = 0; j < card_freq2.length - 1; j++)
				{			
					if (card_freq2[j] < card_freq2[j + 1])
					{
						temp = card_freq2[j];
						card_freq2[j] = card_freq2[j + 1];
						card_freq2[j + 1] = temp;
						swap = true;
					}				
				}		
			}
			while (swap);
			
			
			//checking for flush
			//checks to see if all suits are the same	
			boolean flush = false;
			boolean flush2 = false;
			for (int i = 0; i < 5; i++)
			{
				if (hand[0][1] == i && hand[1][1] == i && hand[2][1] == i && hand[3][1] == i && hand[4][1] == i)
					flush = true;

				//player2
				if (hand2[0][1] == i && hand2[1][1] == i && hand2[2][1] == i && hand2[3][1] == i && hand2[4][1] == i)
					flush2 = true;
			}
			
			//checks for a flush
			boolean straight = false;
			boolean straight2 = false;
			
			if (hand[0][0] - hand[4][0] == 4 && card_freq[0] <= 1)
				straight = true;
			//player 2
			if (hand2[0][0] - hand2[4][0] == 4 && card_freq2[0] <= 1)
				straight2 = true;
			
			// used to determine who wins
			int handstr = 0;
			int handstr2 = 0;
			System.out.println("Player 1: ");
			
			if (flush && hand[0][0] == 12 && hand[1][0] == 11 &&  hand[2][0] == 10 && hand[3][0] == 9 && hand[4][0] == 8)
			{
				System.out.println("You were dealt a Royal Flush!!!!"); // royal flush
				handstr = 11;
			}
			else if (straight && flush)
			{
				System.out.println("You were dealt a straight flush."); // straight flush
				handstr = 10;
			}
			else if (card_freq[0] == 4) 
			{
				System.out.println("You were dealt four of a kind"); // four of a kind
				handstr = 9;
			}
			else if (card_freq[0] == 3 && card_freq[1] == 2)
			{
				System.out.println("You were dealt a full house."); // full house
				handstr = 8;
			}
			else if (flush)
			{
				System.out.println("You were dealt a flush."); //flush
				handstr = 7;
			}
			else if (straight)
			{
				System.out.println("You were dealt a straight."); // straight
				handstr = 6;
			}
			else if (card_freq[0] == 3 && card_freq[1] != 2)
			{
				System.out.println("You were dealt three of a kind."); // three of a kind
				handstr = 5;
			}
			else if (card_freq[0] == 2 && card_freq[1] == 2 && card_freq[2] == 1)
			{
				System.out.println("You were dealt two pair."); //two pair
				handstr = 4;
			}
			else if (card_freq[0] == 2 && card_freq[1] == 1 && card_freq[2] == 1 && card_freq[3] == 1)
			{
				System.out.println("You were dealt a pair."); //pair
				handstr = 3;
			}
			
			System.out.println("High card is a(n) " + str_card[0] + "."); // tell the high card no matter what
			
			System.out.println("Player 2: ");
			//Player 2			
			if (flush2 && hand2[0][0] == 12 && hand2[1][0] == 11 &&  hand2[2][0] == 10 && hand2[3][0] == 9 && hand2[4][0] == 8)
			{
				System.out.println("You were dealt a Royal Flush!!!!"); // royal flush
				handstr2 = 11;
			}
			else if (straight2 && flush2)
			{
				System.out.println("You were dealt a straight flush."); // straight flush
				handstr2 = 10;
			}
			else if (card_freq2[0] == 4) 
			{
				System.out.println("You were dealt four of a kind"); // four of a kind
				handstr2 = 9;
			}
			else if (card_freq2[0] == 3 && card_freq2[1] == 2)
			{
				System.out.println("You were dealt a full house."); // full house
				handstr2 = 8;
			}
			else if (flush2)
			{
				System.out.println("You were dealt a flush."); //flush
				handstr2 = 7;
			}
			else if (straight2)
			{
				System.out.println("You were dealt a straight."); // straight
				handstr2 = 6;
			}
			else if (card_freq2[0] == 3 && card_freq2[1] != 2)
			{
				System.out.println("You were dealt three of a kind."); // three of a kind
				handstr2 = 5;
			}
			else if (card_freq2[0] == 2 && card_freq2[1] == 2 && card_freq2[2] == 1)
			{
				System.out.println("You were dealt two pair."); //two pair
				handstr2 = 4;
			}
			else if (card_freq2[0] == 2 && card_freq2[1] == 1 && card_freq2[2] == 1 && card_freq2[3] == 1)
			{
				System.out.println("You were dealt a pair."); //pair
				handstr2 = 3;
			}
			
			System.out.println("High card is a(n) " + str_card2[0] + "."); // tell the high card no matter what
			
			if (handstr > handstr2)
				System.out.println("Player 1 has won the game. ");
			else if (handstr < handstr2)
				System.out.println("Player 2 has won the game. ");
			else if (handstr == handstr2)
				System.out.println("There is a draw ");

			
			String struserin = " ";
			
			//gets input from user if they want to continue program
			System.out.print("\nPlay Again? (Y or N)? ");		
				struserin = s.nextLine();
			
			if (struserin.charAt(0) == 'Y' || struserin.charAt(0) == 'y')
			{
				rerunprog = true;
				System.out.print("\n");
			}
			else if (struserin.charAt(0) == 'N' || struserin.charAt(0) == 'n')
				rerunprog = false;

	}

	while (rerunprog);

	}
}
