package rollDiceGame;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.anyInt;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class RollDiceGameTest {

	DiceGameView view;
	RollDiceGame sut;
	
	@Before
	public void setUp() throws Exception {
		view = mock(DiceGameView.class);
		
		sut = spy(new RollDiceGame(view));
	}

	@Test
	public void runShouldShowMenu() throws IOException {
		when(view.userWantsToQuit()).thenReturn(true);
		
		sut.run();
		
		verify(view).showMenu();
	}
	
	@Test
	public void runShouldShowMenuTwiceOnFaultyInput() throws IOException {
		when(view.userWantsToQuit()).thenReturn(false).thenReturn(true);
		
		sut.run();
		
		verify(sut, never()).runGame();
		verify(view, times(2)).showMenu();
	}
	
	@Test
	public void shouldShowStartGame() throws IOException {
	
		
		when(view.userWantsToStartGame()).thenReturn(true);
		when(view.userWantsToQuit()).thenReturn(true).thenReturn(true);
		
		sut.run();
		
		verify(sut).runGame();
	}
	
	@Test
	public void shouldShowDice() throws IOException {
		sut.runGame();
		
		view.showDieRoll(anyInt(), anyInt(), anyInt());
		verify(view).userWantsToQuit();
	}

}
