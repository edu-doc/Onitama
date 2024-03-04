package onitama;

public class OnitamaCard {

	private Card card;
	
	public OnitamaCard(String card) {
		card = card.toUpperCase();
		
		boolean found = false;
		for(Card c : Card.values()) {
			if(c.name().equals(card)) {
				this.card = c;
				found = true;
				break;
			}
		}
		if(!found) {
			throw new OnitamaException("Error Card not found");
		}
	}

	public Card getCard() {
		return card;
	}
	
}
