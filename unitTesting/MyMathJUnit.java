import static org.junit.Assert.*;

import math.MyMath;

import org.junit.Before;
import org.junit.Test;


public class MyMathJUnit {

	private MyMath sut;
	int expected = 2;

	@Before
	public void setUp() throws Exception {
		sut = new MyMath();
	}

	@Test
	public void shouldReturnTheLastHighestValue() throws math.WrongInputException {
		int[] input = {1,2};
		
		assertHighest(input);
	}
	
	@Test
	public void shouldReturnTheFirstHighestValue() throws math.WrongInputException {
		
		int[] input = {2,1};
		
		assertHighest(input);
	}
	
	@Test
	public void shouldReturnTheThirdHighestValue() throws math.WrongInputException {
		
		int[] input = {-1,1,2};
		
		assertHighest(input);
	}
	
	@Test(expected=math.WrongInputException.class)
	public void shouldSomethingWhenInputIsEmpty() throws math.WrongInputException {
		
		int[] input = {};
		
		sut.getMax(input);
		
	}
	
	

	private void assertHighest(int[] input) throws math.WrongInputException {
		int actual = sut.getMax(input);
		assertEquals(expected, actual);
	}

}
