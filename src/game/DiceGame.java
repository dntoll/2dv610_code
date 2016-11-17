package game;

import java.io.IOException;
import java.util.Random;

public class DiceGame {
	
	DiceView view;
	private DiceModel model;
	
	public DiceGame(DiceView view, DiceModel model) {
		this.view = view;
		this.model = model;
	}

	
	public static void main(String[] args) throws IOException {
		DiceGame game = new DiceGame(new DiceView(new ConsoleWrapper()), new DiceModel(new Random()));
		
		game.run();
		
		
	}

	public void run() throws IOException {
		view.showStartupMessage();
		do {
			view.showInputMenu();
			view.handleInput();
			if (view.doRoll()) {
				view.showResult(model);
			}
		} while(view.doQuit() == false);
		view.showExitMessage();
	}

}
