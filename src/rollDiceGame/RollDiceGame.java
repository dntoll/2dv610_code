package rollDiceGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RollDiceGame {
	private DiceGameView view;

	public RollDiceGame(DiceGameView view) {
		this.view = view;
	}

	public static void main(String args[]) throws IOException {
		DiceGameView dgv = new DiceGameView(System.out, new BufferedReader(new InputStreamReader(System.in)));
		RollDiceGame game = new RollDiceGame(dgv);
		
		game.run();
	}

	void run() throws IOException {
		
		do {
			view.showMenu();
			if (view.userWantsToStartGame()) {
				runGame();
			}
		} while (view.userWantsToQuit() == false);
	}
	
	void runGame() {
		view.showDieRoll(1,2,3);
	}
}
