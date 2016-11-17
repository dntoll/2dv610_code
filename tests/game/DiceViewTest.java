package game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;


import java.io.IOException;

import javax.management.modelmbean.ModelMBean;

import org.junit.Before;
import org.junit.Test;

public class DiceViewTest {

	private ConsoleWrapper c;
	private DiceView sut;

	@Before
	public void setUp() throws Exception {
		c = mock(ConsoleWrapper.class);
		sut = new DiceView(c);
	}
	
	@Test
	public void handleInputShouldAskForCommandInput() throws IOException {
		sut.handleInput();
		verify(c).readLine();
	}
	
	
	@Test
	public void shouldReturnTrueOnQuitOnUserInput() throws IOException {
		when(c.readLine()).thenReturn(DiceView.QUIT_COMMAND);
		sut.handleInput();
		boolean actual = sut.doQuit();
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueOnQuitOnUserInputWithNewLine() throws IOException {
		when(c.readLine()).thenReturn(DiceView.QUIT_COMMAND + "\r\n");
		sut.handleInput();
		boolean actual = sut.doQuit();
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseOnQuitOnUserInput() throws IOException {
		when(c.readLine()).thenReturn(DiceView.ROLL_COMMAND);
		sut.handleInput();
		boolean actual = sut.doQuit();
		assertFalse(actual);
	}
	
	@Test
	public void shouldReturnTrueOnRollOnUserInput() throws IOException {
		when(c.readLine()).thenReturn(DiceView.ROLL_COMMAND);
		sut.handleInput();
		boolean actual = sut.doRoll();
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseOnRollOnUserInputQuit() throws IOException {
		when(c.readLine()).thenReturn(DiceView.QUIT_COMMAND);
		sut.handleInput();
		boolean actual = sut.doRoll();
		assertFalse(actual);
	}

	@Test
	public void testShowExitMessage() {
		
		sut.showExitMessage();
		verify(c).writeLine(DiceView.EXIT_MESSAGE);
	}
	
	@Test
	public void testShowStartupMessage() {
		
		sut.showStartupMessage();
		verify(c).writeLine(DiceView.WELCOME_MESSAGE);
	}
	
	@Test
	public void testShowMenuMessage() {
		
		sut.showInputMenu();
		verify(c).writeLine(DiceView.MENU_MESSAGE);
	}
	
	@Test
	public void shouldShowResultFromThreeDice() {
		int[] dice = {1,2,3};
		writeDiceArray(dice);
	}

	private void writeDiceArray(int[] dice) {
		DiceModel stub = mock(DiceModel.class);
		
		when(stub.getDice()).thenReturn(dice);
		sut.showResult(stub);
		verify(c).writeLine("First: " +dice[0]+ ", Second: " +dice[1]+ ", Third: " +dice[2]+ "");
	}
	
	@Test
	public void shouldShowResultFromThreeDice2() {
		
		int[] dice = {3,2,1};
		writeDiceArray(dice);
	}
	
	
	

}
