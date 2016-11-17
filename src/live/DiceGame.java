package live;

public class DiceGame {
	
	
	private ConsoleView view;
	private DiceGameModel model;

	public DiceGame(ConsoleView view, DiceGameModel model) {
		this.view = view;
		this.model = model;
	}

	public static void main(String[] args) {
		DiceGame game = new DiceGame(new ConsoleView(System.out), new DiceGameModel());
		
		game.run();
	}

	public void run() {
		this.view.showMenu();
		
		if (view.userQuits() == false) {
			view.showBetting();
			
			int value = view.getUserBet();
			
			model.runGame(value);
		}
		
		this.view.showQuitMessage();
	}
}
