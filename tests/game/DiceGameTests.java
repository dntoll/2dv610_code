package game;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DiceGameTests {

	private DiceView view;
	private DiceModel model;
	private DiceGame sut;

	@Before
	public void setUp() throws Exception {
		view = mock(DiceView.class);
		model = mock(DiceModel.class);
		sut = new DiceGame(view, model);
	}
	
	@Test
	public void shouldShowInputMenuTwiceInFirstFalseInput() throws IOException {
		when(view.doQuit()).thenReturn(false).thenReturn(true);
		sut.run();
		
		
		verify(view, times(2)).showInputMenu();
	}
	
	@Test
	public void shouldUpdateInput() throws IOException {
		when(view.doQuit()).thenReturn(true);
		sut.run();
		verify(view).handleInput();
	}
	
	@Test
	public void shouldShowInputMenu() throws IOException {
		when(view.doQuit()).thenReturn(true);
		sut.run();
		verify(view).showInputMenu();
	}
	
	@Test
	public void shouldAskForUserInput() throws IOException {
		when(view.doQuit()).thenReturn(true);
		sut.run();
		verify(view).doQuit();
	}
	
	@Test
	public void shouldShowStartupMessage() throws IOException {
		when(view.doQuit()).thenReturn(true);
		sut.run();
		verify(view).showStartupMessage();
	}

	@Test
	public void shouldStopAndShowExitMessageOnQuit() throws IOException {
		when(view.doQuit()).thenReturn(true);
		sut.run();
		verify(view).showExitMessage();
		verify(view, never()).showResult(model);
	}
	
	@Test
	public void shouldRollDiesAndPresentResult() throws IOException {
		when(view.doQuit()).thenReturn(false).thenReturn(true);
		when(view.doRoll()).thenReturn(true).thenReturn(false);
		
		sut.run();
		
		verify(view).showResult(model);
	}
}
