package assignment4;

public class Assignment04 {
	
	static WithdrawThread withdraws;
	static DepositThread deposits;
	
	public static void main(String[] args) {
		
		withdraws.start();
		deposits.start();
		
	}
}
