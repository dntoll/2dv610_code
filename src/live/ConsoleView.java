package live;

import java.io.PrintStream;

public class ConsoleView {

	private PrintStream out;
	
	final static String MENU = "Dice Game Menu\n Bet (h)igher or (l)ower or (q)uit"; 
	final static String QUIT = "Thank you for playing and welcome back next time";

	public ConsoleView(PrintStream output) {
		this.out = output;
	}

	public void showMenu() {
		out.println(MENU);
	}

	public void showQuitMessage() {
		out.println(QUIT);
	}


	public void showBetting() {
		// TODO Auto-generated method stub
		
	}

	public boolean userQuits() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getUserBet() {
		// TODO Auto-generated method stub
		return 0;
	}

}
