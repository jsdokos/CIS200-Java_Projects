/*************************************************************************************************************
* Proj5.java
* Jacob Dokos CIS200 - 02L 2:30pm MTW
*
* Takes a command line argument from the user to know the starting position of the board
* then updates the board based on these rules:
* 1) Any live cell with fewer than two live neighbors dies of loneliness
* 2) Any live cell with more than three live neighbors dies of overcrowding
* 3) Any dead cell with exactly three live neighbors comes to life
* 4) Any live cell with two or three neighbors stays alive
* 5) Any dead cell that does not have exactly three live neighbors remains dead 
* 
* Continues infinitely until the user quits the program 
**************************************************************************************************************/ 


import java.io.*;
import java.util.*;

public class proj5 
{

	// used so that the program can know the size of the array
	static int size1; 
	static int size2;

	/*************************************************************************************************************
	* Controls the main part of the program. Reads in the board then displays and updates the board 
	* until the user exits the program
	* 
	* args = used to get a command-line argument from user for the location of the file
	**************************************************************************************************************/ 

	public static void main(String[] args) throws IOException 
	{
		//TODO catch the error
		if (args.length < 1)
		{
			System.out.println("You have not specified a file. Please try again.");
			return;
		}
		else
		{
			//int[][] board = readBoard(args[0]);
			int[][] board = readBoard("life6.txt");
			while ("pigs" != "fly")
			{
				try 
				{
					Thread.sleep(300);
				}
				catch (InterruptedException e) {}
	
				System.out.print(boardDisplay(board));
				board = update(board);
			}
		}
	}

	/*************************************************************************************************************
	* Description: Reads the board in from a file. Take the first two lines as the size of the array.
	* then reads it into an array that will be updated
	* 
	* Input: filename - the location of the file for the method to read in
	* 
	* Output: cells - the array holding the board that will be displayed to the user
	**************************************************************************************************************/ 
	
	public static int[][] readBoard(String filename) throws IOException 
	{
		
		Scanner s_file = new Scanner(new File(filename)); // open link to file
		
		// getting the file size
		size1 = Integer.parseInt(s_file.nextLine());
		size2 = Integer.parseInt(s_file.nextLine());
		
		int[][] cells = new int[size1][size2];
			
		String line;
		//translate the file to an array
		for (int i = 0; i < size1; i++)
		{
			line = s_file.nextLine();
			for(int j = 0; j < size2; j++)
			{
				cells[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		s_file.close();
		
		return cells;			
	}

	/*************************************************************************************************************
	* Description:  Translates the board from 1s and 0s to '*' and '.' respectively for display to the user
	* 
	* Input: cells - the board in 1s and 0s that can be parsed and translated to show the user
	* 
	* Output: board - string to display the board to the user
	**************************************************************************************************************/ 
	
	public static String boardDisplay(int[][] cells) throws IOException 
	{
		String board = "";
		for (int i = 0; i < size1; i++)
		{
			if (i > 0)
				board += "\n";
			for(int j = 0; j < size2; j++)
			{
				if (cells[i][j] == 0)
					board += ".";
				else if (cells[i][j] == 1)
					board += "*";
				else 
					board += "?";
			}
		}
		board += "\n";
		
		return board;		
	}
	
	/*************************************************************************************************************
	* Description: tells the program how many alive neighbors a cell has
	* 
	* Input: cells - the main board for the program
	* 		 row - so the the program can tell what row it should be checking for alive neighbors
	* 		 col - used to tell the program what column it should check in conjunction with the row
	* 
	* Output: alive - returns the number of alive neighbors for the cell and a given row and column
	**************************************************************************************************************/ 
	
	public static int neighbors(int[][] cells, int row, int col) throws IOException 
	{
		 int alive = 0;

		 if (col != 0 && row != 0) {
		 if (cells[row - 1][col - 1] == 1) //top left 1
			 alive++; }
		 
		 if (row != 0) {
		 if (cells[row - 1][col] == 1) //top 2
			 alive++; }
		 
		 if (col != size2 - 1 && row != 0) {
		 if (cells[row - 1][col + 1] == 1) // top right 3
			 alive++; }
		 
		 if (col != 0) {
		 if (cells[row][col - 1] == 1) //left 4
			 alive++; }
		 
		 if (col != size2 - 1) {
		 if (cells[row][col + 1] == 1) //right 5
			 alive++; }
		 
		 if (col != 0 && row != size1 - 1) {
		 if (cells[row + 1][col - 1] == 1) // bottom left 6
			 alive++; }
		 
		 if (row != size1 - 1) {
		 if (cells[row + 1][col] == 1) // bottom 7
			 alive++; }
		 
		 if (col != size2 - 1 && row != size1 - 1) {
		 if (cells[row + 1][col + 1] == 1) // bottom right 8
			 alive++; }
		 
		//return # of live neighbors
		 return alive; //haha	
	}
	
	/*************************************************************************************************************
	* Description: updates the array by calling neighbors() to if in the next cycle it should be alive or dead
	* then makes the change in a second array
	* 
	* Input: cells - the main array for the program. Says what the board looked like in the previous generation.
	* 
	* Output: new2 - an updated array for the next generation (I.E display) 
	**************************************************************************************************************/ 
	
	public static int[][] update(int[][] cells) throws IOException 
	{
		//return next gen of array	
		int[][] new2 = new int[size1][size2];	
	
		for (int i = 0; i < size1; i++)
		{
			for(int j = 0; j < size2; j++)
			{
				if (cells[i][j] == 0 && neighbors(cells, i, j) == 3)
					new2[i][j] = 1;
				else if(cells[i][j] == 1 && neighbors(cells, i, j) >= 2 && neighbors(cells, i, j) <= 3)
					new2[i][j] = 1;
				else 
					new2[i][j] = 0;
			}
		}
	
		return new2;
	}
	
}