package assignment4;

import java.util.Random;

public class DepositThread extends Thread {

	Random rand = new Random();

	private Account acc;
	private int num;
	
	public DepositThread(Account acc) {
		this.acc = acc;
	}
	
	public void Deposit() {
		num = rand.nextInt(40) * 5;
		acc.withdraw(num);
	}
}
