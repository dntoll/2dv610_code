import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import math.MyMath;
import math.WrongInputException;


public class ManualTestingApp {
	
	private MyMath sut;
	private BufferedReader in;
	private String userInput;

	public ManualTestingApp() {
		sut = new MyMath();
		in = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public void run() throws WrongInputException {
		do {
			int[] integerArray = null;
			System.out.println("Enter an integer array separated with space");
			try {
				integerArray = readArrayFromConsole();
				
			} catch (Exception e) {
				
			}
			int actual = sut.getMax(integerArray);
			System.out.println("The max was: " + actual);
		} while (userInput.trim().equalsIgnoreCase("q") == false);
	}

	private int[] readArrayFromConsole() throws IOException {
		userInput = in.readLine();
		String[] inputArray = userInput.split("\\s+");
		int integerArray[] = new int[inputArray.length];
		for(int i = 0; i < inputArray.length; i++) {
			integerArray[i] = Integer.parseInt(inputArray[i]);
		}
		return integerArray;
	}
	
	public static void main(String args[]) throws IOException, WrongInputException {
		ManualTestingApp a = new ManualTestingApp();
		a.run();
	}
}
