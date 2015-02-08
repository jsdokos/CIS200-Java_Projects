import java.util.Scanner;


public class Proj3 {

	public static void main(String[] args) 
	{
		// TODO change back to 0
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		//translated variables
		int x1trans = 0;
		int y1trans = 0;
		int x2trans = 0;
		int y2trans = 0;

		int rownum = 9;
		
		Scanner s = new Scanner(System.in);
		
		//getting input from user
		//TODO implement error checking
		System.out.print("Enter x1: ");
		x1 = Integer.parseInt(s.nextLine());
		
		System.out.print("Enter y1: ");
		y1 = Integer.parseInt(s.nextLine());
		
		/*System.out.print("Enter x2: ");
		x2 = Integer.parseInt(s.nextLine());
		
		System.out.print("Enter y2: ");
		y2 = Integer.parseInt(s.nextLine());*/

		String[][] table = new String[11][20];
		
		for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 20; j++)
			{
			
			if (j == 0 && rownum != -1)
				table[i][j] = String.valueOf(rownum--); // converts to string
			else if (j == 1 && i < 9)
				table[i][j] = "|"; // displays pipe used in table
			else if (i == 9 && j > 1)
				table[i][j] = "-"; // formatting for lower level
			else if (i == 10 && j % 2 == 1)
				table[i][j] = String.valueOf(1 + rownum++);
			else if (i == 10 && j % 2 == 0)
				table[i][j] = " ";
			else
				table[i][j] = (" ");
			
			//table[i][j] = ("(" + i + "," + j + ") ");
			
			// y1 lookup table
			if (y1 == 0)
				y1trans = 9;
			else if (y1 == 1)
				y1trans = 8;
			else if (y1 == 2)
				y1trans = 7;
			else if (y1 == 3)
				y1trans = 6;
			else if (y1 == 4)
				y1trans = 5;
			else if (y1 == 5)
				y1trans = 4;
			else if (y1 == 6)
				y1trans = 3;
			else if (y1 == 7)
				y1trans = 2;
			else if (y1 == 8)
				y1trans = 1;
			else if (y1 == 9)
				y1trans = 0;
			
			//x1 lookup table
			if(x1 == 0)
				x1trans = 1;
			else if (x1 == 1)
				x1trans = 3;
			else if (x1 == 2)
				x1trans = 5;
			else if (x1 == 3)
				x1trans = 7;
			else if (x1 == 4)
				x1trans = 9;
			else if (x1 == 5)
				x1trans = 11;
			else if (x1 == 6)
				x1trans = 13;
			else if (x1 == 7)
				x1trans = 15;
			else if (x1 == 8)
				x1trans = 17;
			else if (x1 == 9)
				x1trans = 19;
						
			if(i == y1trans && j == x1trans)
				table[i][j] = "*";
			
			//TODO implement lookup table for x2 and y2
			//TODO check to see if x1 and x1 equal each other
			//TODO check to see if points are different
			//TODO make sure points are in acceptable range i.e less than or equal to 9
			//TODO find slope and display it
			//TODO loop program until user quits

			
			System.out.print(table[i][j]);
			
			if (j == 19)
				System.out.print("\n");
			
			//table[i][j] = ("(" + i + ", " + j + ")");
			 

			}
		}
		
	}

}
