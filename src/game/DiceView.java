package game;

import java.io.IOException;



public class DiceView {
	public static String EXIT_MESSAGE = "Welcome back another time";
	public static String QUIT_COMMAND = "Q";
	public static String ROLL_COMMAND = "R";
	
	public static String WELCOME_MESSAGE = "Application startup";
	public static String MENU_MESSAGE = "Menu";
	
	ConsoleWrapper console;
	String lineRead;

	public DiceView(ConsoleWrapper c) {
		console = c;
	}

	public boolean doQuit() throws IOException {
		if (lineRead.startsWith(QUIT_COMMAND))
			return true;
		return false;
	}

	public void showExitMessage() {
		console.writeLine(EXIT_MESSAGE);
	}

	public void showStartupMessage() {
		console.writeLine(WELCOME_MESSAGE);
		
	}

	public void showInputMenu() {
		console.writeLine(MENU_MESSAGE);
	}

	public boolean doRoll() throws IOException {
	
		if (lineRead.startsWith(ROLL_COMMAND))
			return true;
		
		return false;
	}

	public void showResult(DiceModel model) {
		int dice[] = model.getDice();
		console.writeLine("First: "+dice[0]+", Second: "+dice[1]+", Third: "+dice[2]+"");
	}

	public void handleInput() throws IOException {
		lineRead = console.readLine();
	}

}
