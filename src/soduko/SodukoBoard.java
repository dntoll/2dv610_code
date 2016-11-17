package soduko;

public class SodukoBoard {

	public static final int ARRAY_SIZE = 81;

	public SodukoBoard(int[] board) throws IllegalArgumentException {
		if(board == null || board.length != ARRAY_SIZE)
			throw new IllegalArgumentException();
	}

}
