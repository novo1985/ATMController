
public class Account {
		
	private String accountType;
	private int accountNumber;
	private double balance;
	
	
	public Account(String str, int num, double value) {
		this.accountType = str;
		this.accountNumber = num;
		this.balance = value;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
