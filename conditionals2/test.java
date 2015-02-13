
public class test 
{

	public static void main(String[] args) 
	{
		
		int i;
		for(int j=1;j<10;j++) 
		{
			for(i=1;i>0;i++)
			{ 
				System.out.print(i); 
		 
				if(i==j) { break; }
			} 
			i--;
			
			while(i>0) 
			{ 
				System.out.print(i--); 
			                   
				if(i==0) 
				break; 
			} 
		  System.out.println();
		} 
	} 
} 

