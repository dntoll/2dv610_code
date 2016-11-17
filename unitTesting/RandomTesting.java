import java.util.Random;

import math.MyMath;




public class RandomTesting {
	
		public static void main(String args[]) {
			//A test that does not expose the error
			MyMath sut = new MyMath();
			Random r = new Random();
			int successes = 0;
			int fails = 0;
			int errors = 0;
			int tries = 100;
			int maxArraySize = Integer.MAX_VALUE-5;
			
			System.out.println("Random testing of MyMath.getMax()");
			System.out.println("Conducting " + tries + " tests on arrays of size " + maxArraySize);
			
			for (int t = 0; t< tries; t++) {
				int numberOfInputs = r.nextInt(maxArraySize); 
				int[] input = new int[numberOfInputs];
				int expectedOutput = Integer.MIN_VALUE;
				
				
				for(int i = 0; i < numberOfInputs; i++) {
					input[i] = r.nextInt();
					if (input[i] > expectedOutput) {
						expectedOutput = input[i];
					}
				}
				int actual = 0;
				try {
					actual =sut.getMax(input); //exercise the SUT
					 
					if (expectedOutput == actual)
						successes++;
					else 
						fails++;
				} catch (Exception e) {
					errors++;
				}
			}
			System.out.println("Successes: " +  successes + " Fails: " + fails + " Errors " + errors);
			System.out.println("Reliability for arrays up to " + maxArraySize +" items is = " + 100.0f * (float)successes / (float)(successes + fails + errors) + "%");
		}
	
}
