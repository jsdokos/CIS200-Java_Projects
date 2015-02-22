
import java.util.*;

public class test 
{

	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		double price;
		
		do
		{
			price = Double.parseDouble(s.nextLine());
			
			if (price <= 0 || price >= 1000)
			{
				System.out.println("Invlaid input\nPlease re-enter a price");
			}
			
		}
		while (price <= 0 || price >= 1000);
	} 
} 

