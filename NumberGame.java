package finalProject;

import java.util.Random;

public class NumberGame {
	
	public static int getRandom() {
		Random rand = new Random();
		int randNum = rand.nextInt(999) + 1;
		
		return randNum;
	}

}
