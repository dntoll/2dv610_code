package live;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ConsoleViewTest {

	private ConsoleView sut;
	private PrintStream printStream;

	@Before
	public void setUp() throws Exception {
		printStream = mock(PrintStream.class);
		sut = new ConsoleView(printStream);
	}

	@Test
	public void shouldShowMenu() {
		sut.showMenu();
		verify(printStream).println(ConsoleView.MENU);
	}
	
	@Test
	public void shouldShowQuitMessage() {
		sut.showQuitMessage();
		verify(printStream).println(ConsoleView.QUIT);
	}

}
