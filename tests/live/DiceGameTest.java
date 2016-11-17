package live;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;


public class DiceGameTest {

	private DiceGame sut;
	private ConsoleView view;
	private DiceGameModel model;

	@Before
	public void setUp() throws Exception {
		view = mock(ConsoleView.class);
		model = mock(DiceGameModel.class);
		sut = new DiceGame(view, model);
		
	}

	@Test
	public void shouldShowMenuAndQuit() {

		when(view.userQuits()).thenReturn(true);

		sut.run();
		
		verify(view).showMenu();
		verify(view, never()).showBetting();
		verify(view).showQuitMessage();
	}
	
	@Test
	public void shouldShowMenuAndBetting() {
	
		when(view.userQuits()).thenReturn(false);

		sut.run();
		
		verify(view).showMenu();
		verify(view).showBetting();
	}
	
	@Test
	public void shouldAskUserToBet() {
	
		when(view.userQuits()).thenReturn(false);

		sut.run();
		
		verify(view).getUserBet();
	}
	
	@Test
	public void shouldHandleGameRules() {
		int inputMoney = 10;
		
		sut = new DiceGame(view, model);
		
		when(view.getUserBet()).thenReturn(inputMoney);
	
		sut.run();
		
		verify(model).runGame(inputMoney);
	}

}
