package assignment4;

import java.util.Random;

public class WithdrawThread extends Thread {
	
	Random rand = new Random();

	private Account acc;
	private int num;
	
	public WithdrawThread(Account acc) {
		this.acc = acc;
	}
	
	public void Withdraw() {
		num = rand.nextInt(20) * 5;
		acc.withdraw(num);
	}
}
