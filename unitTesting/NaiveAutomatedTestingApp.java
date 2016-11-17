import math.MyMath;
import math.WrongInputException;




public class NaiveAutomatedTestingApp {
	
	
	
	public static void main(String args[]) throws WrongInputException {
		//A test that does not expose the error
		MyMath sut = new MyMath();
		
		{
			int[] input = {1, 2, 4, 2};
			int expectedOutput = 4;
			
			int actual =sut.getMax(input);
			
			if (expectedOutput == actual)
				System.out.println("Test succeeded");
			else 
				System.out.println("Test failed");
		}
		{
			int[] input = {1, 4, 2, 2};
			int expectedOutput = 4;
			
			int actual =sut.getMax(input);
			
			if (expectedOutput == actual)
				System.out.println("Test succeeded");
			else 
				System.out.println("Test failed");
		}
		{
			int[] input = {4, 2, 2, 2};
			int expectedOutput = 4;
			
			int actual =sut.getMax(input);
			
			if (expectedOutput == actual)
				System.out.println("Test succeeded");
			else 
				System.out.println("Test failed");
		}
		
		
		
		
	}
}
