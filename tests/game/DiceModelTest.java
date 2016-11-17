package game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class DiceModelTest {

	private DiceModel sut;
	private Random r;

	@Before
	public void setUp() throws Exception {
		r = mock(Random.class);
		sut = new DiceModel(r);
	}

	@Test
	public void shouldUseRandomValues() {
		sut.getDice();
		verify(r, times(3)).nextInt(6);
	}
	
	@Test
	public void shouldReturnTheValues() {
		when(r.nextInt(6)).thenReturn(1).thenReturn(2).thenReturn(5);
		
		//One higher since a die starts with 1
		int[] expecteds = {2,3,6};
		int[] actuals = sut.getDice();
		assertArrayEquals(expecteds, actuals);
	}

}
