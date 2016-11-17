package soduko;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SodukoBoardTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionOnNullInput() {
		new SodukoBoard(null);
	}
	
	@Test
	public void shouldNotThrowanExceptionOnCorrectInput() {
		new SodukoBoard(new int[SodukoBoard.ARRAY_SIZE]);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowanExceptionOnIncorrectInputArraySize() {
		new SodukoBoard(new int[SodukoBoard.ARRAY_SIZE-1]);
	}
	
	
}
