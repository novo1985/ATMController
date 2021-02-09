public class Card {
	
	private int PIN;
	private int cardID;
	private Account[] accountInfo = new Account[2];
	
	public Card(int pin, int id, Account account) {
		this.PIN = pin;
		this.cardID = id;
		int index = -1;
		if(account.getAccountType().equals("checking")) {
			index = 0;
		}else {
			index = 1;
		}
		accountInfo[index] = account;
	}
	
	public int getPIN() {
	    return this.PIN;
	}
	public void setPIN(int PIN) {
	    this.PIN = PIN;
	}
	
	public int getCardId() {
		return this.cardID;
	}
	
	public Account[] getAccountInfo() {
		return this.accountInfo;
	}
	
	public boolean validatePin(int pin) {
		return this.PIN == pin;
	}
	
	public void deposit(int type, double amount) {
		// update corresponding account balance
		double origin_money = accountInfo[type].getBalance();
		accountInfo[type].setBalance(origin_money + amount);
	}
	
	public void withdraw(int type, double amount) {
		double origin_money = accountInfo[type].getBalance();
		if(origin_money < amount) {
			System.out.println("Sorry, without enough balance!");
		}else {
			accountInfo[type].setBalance(origin_money - amount);
		}
	}


	
}
