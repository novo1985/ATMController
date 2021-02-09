
public class Main {
	
	public static void main(String[] args) throws Exception { 
	
	Account acount1 = new Account("checking", 1, 1000.0);
	Account acount2 = new Account("saving", 2, 2000.0);
	Account acount3 = new Account("checking", 3, 3000.0);
	Account acount4 = new Account("saving", 4, 4000.0);
	Account acount5 = new Account("checking", 5, 5000.0);
	Account acount6 = new Account("saving", 6, 6000.0);
	Account acount7 = new Account("checking", 7, 7000.0);
	Account acount8 = new Account("saving", 8, 8000.0);
	Account acount9 = new Account("checking", 9, 9000.0);
	Account acount10 = new Account("saving", 10, 10000.0);
	
	Card card1 = new Card(123456, 111, acount1);	
	card1.getAccountInfo()[1] = acount2;
	
	Card card2 = new Card(123456, 222, acount3);
	card2.getAccountInfo()[1] = acount4;
	
	Card card3 = new Card(123456, 333, acount5);
	card3.getAccountInfo()[1] = acount6;
	
	Card card4 = new Card(123456, 444, acount7);
	card4.getAccountInfo()[1] = acount8;
	
	Card card5 = new Card(123456, 555, acount9);
	card5.getAccountInfo()[1] = acount10;
	
	Bank bank = new Bank();	
	bank.registerCard(card1);
	bank.registerCard(card2);
	bank.registerCard(card3);
	bank.registerCard(card4);
	bank.registerCard(card5);
	
	ATM atm = new ATM(bank, 5000.0);
	
	atm.execute(card1);
	
	}

}
