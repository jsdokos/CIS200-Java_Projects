import java.text.DecimalFormat;

/**
This file provided to the student for modification
The Payroll class stores data about an employee's pay
*/

public class Payroll
{  
	private String name;          // Employee name
	private int idNumber;         // ID number
	private double payRate;       // Hourly pay rate
	private double hoursWorked;   // Number of hours worked

   /**
      The constructor initializes an object with the
      employee's name and ID number.
      @param n The employee's name.
      @param i The employee's ID number.
   */
   public Payroll(String n, int i)
   {
      name = n;
      idNumber = i;
   }
   
	/*************************************************************************************************************
	* Description: Contructor to create a blank student for the user to add information into
	* 
	* Parameters: none
	* 
	* Return: none
	**************************************************************************************************************/ 
   public Payroll()
   {
     name = "";
     idNumber = 0000000;
     payRate = 00.00;
     hoursWorked = 0;
   }

   /**
      The setName sets the employee's name.
      @param n The employee's name.
   */
   public void setName(String n)
   {
		   name = n;
   }

   /**
      The setIdNumber sets the employee's ID number.
      @param i The employee's ID number.
   */
   public void setIdNumber(int i)
   {
	   
      idNumber = i;
      //TODO error checking char or double
   }

   /**
      The setPayRate sets the employee's pay rate.
      @param p The employee's pay rate.
   */
   public void setPayRate(double p)
   {
      payRate = p;
      //TODO error checking char
   }

   /**
      The setHoursWorked sets the number of hours worked.
      @param h The number of hours worked.
   */
   public void setHoursWorked(double h)
   {
      hoursWorked = h;
      //TODO error checking char
   }

   /**
      The getName returns the employee's name.
      @return The employee's name.
   */
   public String getName()
   {
      return name;
   }

   /**
      The getIdNumber returns the employee's ID number.
      @return The employee's ID number.
   */
   public int getIdNumber()
   {
      return idNumber;
   }

   /**
      The getPayRate returns the employee's pay rate.
      @return The employee's pay rate.
   */
   public double getPayRate()
   {
      return payRate;
   }

   /**
      The getHoursWorked returns the hours worked by the
      employee.
      @return The hours worked.
   */
   public double getHoursWorked()
   {
      return hoursWorked;
   }

   /**
      The getGrossPay returns the employee's gross pay.
      @return The employee's gross pay.
   */
   public double getGrossPay()
   {
      return hoursWorked * payRate;
   }
   
	/*************************************************************************************************************
	* Description: return all the information about and object in a string to be outputted to the screen
	* 
	* Parameters: none
	* 
	* Return: 
	* temp - used to gather all the information about an object to be returned
	**************************************************************************************************************/ 
   public String toString() 
   {
	   String temp = "";
	   DecimalFormat df = new DecimalFormat("#0.00"); // format for displaying final value 
	   
	   temp = "Employee Name: " + name + "\nID Number: " + idNumber + "\nPay: $" + df.format(getGrossPay()); // + "\n"
	   return temp;
	   
   }
} // end class

