
import java.util.*;
public class test 
{

	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		double total = Double.parseDouble(s.nextLine());
		int day = Integer.parseInt(s.nextLine());
		
		s.close();
		
		total *= 7;
		total -= 1;
		total *= 13;
		total += day;
		total *= 11;
		
		
		
		
	}
} 

