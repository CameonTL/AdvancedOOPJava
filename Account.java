package assignment4;

public class Account extends Thread {
	
	private int balance;
	
	public Account() {
		balance = 0;
	}
	
	public void deposit( int d ) {
		synchronized( this ) {
			balance += d;
			System.out.println( "Deposit " + d );
			this.notifyAll();
		}
	}
	
	public void withdraw( int d ) {
		try {
			synchronized( this ) {
				while ( balance < d ) {
					System.out.println( "withdraw " + d + " enters wait");
					this.wait();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
