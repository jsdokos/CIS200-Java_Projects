import java.util.*;

public class PayrollApp {
	
	private static ArrayList<Payroll> list = new ArrayList<Payroll>();
	
	
	/*************************************************************************************************************
	* Gets information for the Payroll object then displays them afterwards allows the user to remove one then
	* add another one, then display the resulting list
	* 
	* Jacob Dokos
	* 
	* Project 9
	**************************************************************************************************************/ 
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean rerunprog = false;
		
		do
		{
			addToList(); // method to add to array
			String struserin = " ";
			
			//gets input from user if they want to continue program
			System.out.print("\nRun program again? (y/n) ");		
				struserin = s.nextLine(); 
			
			if (struserin.charAt(0) == 'Y' || struserin.charAt(0) == 'y')
			{
				rerunprog = true;
				System.out.print("\n");
			}
			else if (struserin.charAt(0) == 'N' || struserin.charAt(0) == 'n')
				rerunprog = false;
			
			
		} while (rerunprog);
		
		
		//display all the employees
		displayList();

		String temp = "";
		
		boolean validID = false;
		do
		{
			System.out.print("Please enter an ID number: ");
			temp = s.nextLine();
			//if you find the ID # then remove it
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i).getIdNumber() == Integer.parseInt(temp) )
				{
					list.remove(i);
					validID = true;
				}		
			}
			if (!validID)
				System.out.println("Please enter a valid ID number");
			
		} while (!validID);
		//get input from user

		
		//add in one more employee then display them all
		addToList();
		displayList();
	}
	
	/*************************************************************************************************************
	* Description: Used to display all the objects in the arraylist to the screen
	* 
	* Parameters: none
	* 
	* Return: none
	**************************************************************************************************************/ 
	public static void displayList()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).toString());
			System.out.println();
		}
		
		
	}
	
	/*************************************************************************************************************
	* Description: Gets input from the user to add to the array list. 
	* 
	* Parameters: none
	* 
	* Return: none
	**************************************************************************************************************/ 
	public static void addToList()
	{
		Payroll temp = new Payroll();
		Scanner s = new Scanner(System.in);
		boolean success = false;
		while (!success)
		{
			System.out.print("What is the employees name? ");
			try
			{
				temp.setName(s.nextLine());
				if (temp.getName().length() == 0)
					throw new Exception();
				success = true;
			}
			catch (Exception e)
			{
				System.out.println("You must enter a valid name, please try again. ");
				
			}
		}
		success = false;
		while (!success)
		{	
			System.out.print("What is the employees ID? ");
			try
			{
				temp.setIdNumber(Integer.parseInt(s.nextLine())); 
				success = true;

			}
			catch (ClassCastException f)
			{
				System.out.println("Invalid character, please try again. ");
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid character, please try again. ");
			}
		}
		success = false;
		while (!success)
		{
			System.out.print("What is the employees Pay Rate? ");
			try
			{
				temp.setPayRate(Double.parseDouble(s.nextLine()));
				success = true;

			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid character, please try again. ");
			}
		}
		success = false;
		while (!success)
		{	
			System.out.print("What is the employees hours worked? ");
			try
			{
				temp.setHoursWorked(Double.parseDouble(s.nextLine()));
				success = true;

			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid character, please try again. ");
			}
		}
		
		list.add(temp);
		
	}

}
