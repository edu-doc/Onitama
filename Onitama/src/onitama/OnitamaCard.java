package onitama;

public class OnitamaCard {

	private static Card card;
	
	public OnitamaCard(String card) {
		card = card.toUpperCase();
		
		boolean found = false;
		for(Card c : Card.values()) {
			if(c.name().equals(card)) {
				setCard(c);
				found = true;
				break;
			}
		}
		if(!found) {
			throw new OnitamaException("Error Card not found");
		}
	}
	
	public void setCard(Card card) {
		OnitamaCard.card = card;
	}

	public static Card getCard() {
		return card;
	}
	
}
