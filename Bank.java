import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private Map<Integer, Card> cards;	
	
	public Bank() {
		this.cards = new HashMap<Integer, Card>();
	}
	
	public void registerCard(Card card) {
		if(cards.containsKey(card.getCardId())) {
			System.out.println("Error! duplicated card");
		}
		cards.put(card.getCardId(), card);
	}
	
	public Card findCard(int id) {
		if(!cards.containsKey(id)) {
			System.out.println("Error! no such card");
			return null;
		}
		return cards.get(id);
	}
}
