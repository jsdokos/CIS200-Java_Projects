
import java.util.*;
import java.text.*;
public class test 
{

	public static void main(String[] args) 
	{
		/*
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(200); //0
		tree.add(22); //1
		tree.add(50); //2
		tree.add(20); //3
		tree.add(175); //4
		tree.add(90); //5
		
		//System.out.println(tree.first());
		
		Iterator<Integer> iterator = tree.iterator();
		System.out.print("Tree set data: ");
	 
		// Displaying the Tree set data
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		
		HashMap<Integer, String> temp = new HashMap<Integer, String>();
		
		temp.put(85, "poop");
		temp.put(420, "ayyyy lmao");
		
		System.out.println(temp.get(420));
		Iterator<Integer> i = temp.keySet().iterator();
		
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
		*/
	
		Scanner s = new Scanner(System.in);
		String[][] array = new String[10][10];
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				array[i][j] = "-";
			}
		}
	
		
		while ("pigs" != "fly")
		{
			
			for (int i = 0; i < 10; i++)
			{
				if (i != 0)
				System.out.println();
				
				for (int j = 0; j < 10; j++)
				{
					System.out.print(array[i][j]);
				}
			}
			
			System.out.println("\n");
			
			System.out.print("Row: ");
			int row = Integer.parseInt(s.nextLine());
			System.out.print("Col: ");
			int col = Integer.parseInt(s.nextLine());
			
			
			array[row-1][col-1] = "*";
			
	
			
		}
		
		
		
		
		
		
		
	}
} 

