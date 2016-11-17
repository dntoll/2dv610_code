package math;



public class MyMath {
	/**
	 * FAULTY implementation of getMax
	 * 
	 * Should return the max number of a set of inputs but sometimes dont.
	 * 
	 * @param an array of integers
	 * @return the highest integer in the array
	 * @throws WrongInputException 
	 */
	public int getMax(int[] a) throws WrongInputException {
		//FAULTY implementation with multiple bugs
		
		if (a.length == 0) {
			throw new WrongInputException();
		}
		int l = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > l)
				l = a[i];
		}
		return l;
	}
	
	
}
