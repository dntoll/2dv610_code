package rollDiceGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class DiceGameView {

	private PrintStream out;
	private BufferedReader input;
	final static String MENU = "Menu \n S. Start a game\n Q. Quit";

	public DiceGameView(PrintStream printStream, BufferedReader input) {
		this.out = printStream;
		this.input = input;
	}

	public void showMenu() {
		this.out.println(MENU);
	}

	public boolean userWantsToQuit() throws IOException {
		String str = input.readLine();
		return str == "Q";
	}

	public boolean userWantsToStartGame() {
		// TODO Auto-generated method stub
		return true;
	}

	public void showDieRoll(int d1, int d2, int d3) {
		out.println("Dice(" + d1 + ", " + d2 + ", " + d3 + ")\n Would you like to roll again?");
	}

}
