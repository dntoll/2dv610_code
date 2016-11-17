package rollDiceGame;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class DiceGameViewTest {
	PrintStream printStream;
	DiceGameView sut;
	BufferedReader input;

	@Before
	public void setUp() throws Exception {
		printStream = mock(PrintStream.class);
		input = mock(BufferedReader.class);
		sut = new DiceGameView(printStream, input);
	}
	
	

	@Test
	public void testShowMenu() {
		String expected = DiceGameView.MENU;
		
		sut.showMenu();
	
		verify(printStream).println(expected);
	}
	
	@Test
	public void shouldShowDiceOnDieRoll() {
		String expected = "Dice(1, 2, 3)\n Would you like to roll again?";
		
		sut.showDieRoll(1,2,3);
	
		verify(printStream).println(expected);
	}
	
	@Test
	public void shouldShowDiceOnDieRollOther() {
		String expected = "Dice(3, 2, 1)\n Would you like to roll again?";
		
		sut.showDieRoll(3,2,1);
	
		verify(printStream).println(expected);
	}
	
	@Test
	public void shouldQuitOnInputQ() throws IOException {
		
		when(input.readLine()).thenReturn("Q");
		
		boolean actual = sut.userWantsToQuit();
		assertTrue(actual);
	}
	
	@Test
	public void shouldNotQuitOnInputS() throws IOException {
		when(input.readLine()).thenReturn("S");
		
		boolean actual = sut.userWantsToQuit();
		assertFalse(actual);
	}

}
