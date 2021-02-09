
public class User {
	
	private int id;
	private Card card;
	
	public User(int id, Card card) {
		this.id = id;
		this.card = card;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}	

}
