
public class test_kevin {

	public static void main(String[] args) 
	{
		int temp = 0;
		int num2 = 1;
		do
		{
			System.out.print(temp + " ");
			temp += num2;
			System.out.print(num2 + " ");
			num2 += temp;
			
		}
		while (num2 < 100000);
	}
	
}
