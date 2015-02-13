import java.text.DecimalFormat;
import java.util.Scanner;





//TODO loop program until user quits
//TODO header of file

public class Proj3 {

	public static void main(String[] args) 
	{
		boolean rerunprog = true;
		do
		{
			// TODO change back to 0
			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;
			
			//translated variables DELETE
			/*int x1trans = 0;
			int y1trans = 0;
			int x2trans = 0;
			int y2trans = 0;*/
	
			int rownum = 9;
			int[] y_array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
			int[] x_array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
			double slope  = 0;
			double y_intercept = 0;
			boolean input_error = false;
			
			DecimalFormat df = new DecimalFormat("#0.00");
			Scanner s = new Scanner(System.in);
			do
			{
				//getting input from user
				//TODO implement error checking
				System.out.print("Enter x1: ");
				x1 = Integer.parseInt(s.nextLine());
				
				System.out.print("Enter y1: ");
				y1 = Integer.parseInt(s.nextLine());
				
				System.out.print("Enter x2: ");
				x2 = Integer.parseInt(s.nextLine());
				
				System.out.print("Enter y2: ");
				y2 = Integer.parseInt(s.nextLine());
				
				if (x1 == x2 && y1 == y2)
				{
					System.out.println("Point values must be different. \n");
					input_error = true;
				}
				else if (x1 == x2)
				{
					System.out.println("Line between points must have a slope\n(i.e x1 and x2 must differ)\n");
					input_error = true;
				}
				else if (x1 > 9 || x1 < 0)
				{
					System.out.println("All points must be between (0,0) and (9,9). \n");
					input_error = true;
				}
				else if (x2 > 9 || x2 < 0)
				{
					System.out.println("All points must be between (0,0) and (9,9). \n");
					input_error = true;
				}
				else if (y1 > 9 || y1 < 0)
				{
					System.out.println("All points must be between (0,0) and (9,9). \n");
					input_error = true;
				}
				else if (y2 > 9 || y2 < 0)
				{
					System.out.println("All points must be between (0,0) and (9,9). \n");
					input_error = true;
				}
				else 
					input_error = false;
				
			} 
			while (input_error);
			
			// calculating slope and y intercept
			slope = ((double)(y2-y1)/(double)(x2-x1));
			y_intercept = (y1 - slope * x1);
			System.out.println("\ny = " + df.format(slope) + "x + " + df.format(y_intercept) + "\n");
	
	
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
					
					if(i == y_array[y1] && j == x_array[x1])
						table[i][j] = "*";			
	
					
					if(i == y_array[y2] && j == x_array[x2])
						table[i][j] = "*";
					
					
					System.out.print(table[i][j]);
					
					if (j == 19)
						System.out.print("\n");
					
				}
			}
		
			String struserin = " ";
			
			System.out.print("\nRun program again? (y/n) ");
			
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
