package game;

import java.util.Random;

public class DiceModel {
	
	private Random die;
	

	public DiceModel(Random r) {
		this.die = r;
	}

	public int[] getDice() {
		
		int[] ret = {die.nextInt(6)+1, die.nextInt(6)+1, die.nextInt(6)+1};
		
		return ret;
	}

}
