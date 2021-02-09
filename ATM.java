import java.util.Scanner;

public class ATM {
	
	private Bank bank;
	private Account cur_account;
	private double cash_bin;
	public Scanner input;
	
	public ATM(Bank bank, double money) {
		this.bank = bank;
		this.cash_bin = money;
		input = new Scanner(System.in);
	}
	
	// validate Card
	public int validateCard(Card card) {
		if(this.bank.findCard(card.getCardId()) == null) {
			return -1;
		}
		return 0;
	}
	
	//  insert card
	public void insertCard(Card card) throws Exception {
		int code = validateCard(card);
		if(code == -1) {
			throw new Exception("Invalid Card!");
		}
		System.out.println("Please enter you PIN number:");
		int password = input.nextInt();
		
		int attemp = 3;
		while(attemp > 0 && password != card.getPIN()) {
			attemp--;
			System.out.println("Wrong PIN, please try again! Remaing attemp is " + attemp);
			password = input.nextInt();
		}
		if(password != card.getPIN()) {
			throw new Exception("Wrong PIN, Card temporary blocked!");
		}		
	}
	
	// select Account
	public void selectAccount(Card card) {
		System.out.println("Please select your account type: 1 is checking, 2 is saving");
		int type = input.nextInt();
		this.cur_account = card.getAccountInfo()[type-1];
	}
	
	// show balance
	public double showBalance() {
		System.out.println("Your account balance is " + this.cur_account.getBalance());
		return this.cur_account.getBalance();
	}
	
	// deposit
	public void deposit() {
		double origin_money = cur_account.getBalance();
		System.out.println("Please put your money:");
		double amount = input.nextDouble();
		this.cur_account.setBalance(origin_money + amount);
		this.cash_bin += amount;
	}
	
	// withdraw
	public void withdraw() {
		double origin_money = cur_account.getBalance();
		System.out.println("Please enter how much money you want to withdraw:");
		double amount = input.nextDouble();
		if(amount > this.cash_bin) {
			System.out.println("Not enough cash in ATM!");
		}
		else if(amount > origin_money) {
			System.out.println("Not enough balance in your account!");
		}
		else {
			this.cash_bin -= amount;
			this.cur_account.setBalance(origin_money - amount);
		}
	}
	
	public void execute(Card card) throws Exception{
	
		try {
			insertCard(card);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean done = false;
		while(!done) {
			selectAccount(card);
			System.out.println("Please chose your service. 1: show balance; 2: deposit; 3:withdraw");
			int operation_code = input.nextInt();
			if(operation_code == 1) {
				showBalance();
			}
			if(operation_code == 2) {
				deposit();
			}
			if(operation_code == 3) {
				withdraw();
			}
			System.out.println("Are you done? yes or no");
			String ans = input.next();
			done = (ans.equals("yes")) ? true : false;
		}
		input.close();
	}
	
	
	

}
