package onitama;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myCollection.MyLinkedListSingle;
import myCollection.MyQueueLinkedList;

public class OnitamaCard {

	private static Card card;
	private static List<Card> list = new ArrayList<>();
	private static MyLinkedListSingle<Card> listRed = new MyLinkedListSingle<>();
	private static MyLinkedListSingle<Card> listBlue = new MyLinkedListSingle<>();
	private static MyQueueLinkedList<Card> queue = new MyQueueLinkedList<>();

	public OnitamaCard(String card) {
		card = card.toUpperCase();
		
		boolean found = false;
		if (OnitamaMatch.getCurrentPlayer() == Color.RED)
			for(Card c : listRed) {
				if(c.name().equals(card)) {
					setCard(c);
					found = true;
					break;
				}
			}
		else if (OnitamaMatch.getCurrentPlayer() == Color.BLUE) {
			for(Card c : listBlue) {
				if(c.name().equals(card)) {
					setCard(c);
					found = true;
					break;
				}
			}
		}
		if(!found) {
			throw new OnitamaException("Error Card not found");
		}
	}



	public static void getListCard(){

		list.add(Card.BOAR);
		list.add(Card.COBRA);
		list.add(Card.CRAB);
		list.add(Card.CRANE);
		list.add(Card.DRAGON);
		list.add(Card.EEL);
		list.add(Card.ELEPHANT);
		list.add(Card.FROG);
		list.add(Card.GOOSE);
		list.add(Card.HORSE);
		list.add(Card.MANTIS);
		list.add(Card.MONKEY);
		list.add(Card.OX);
		list.add(Card.RABBIT);
		list.add(Card.ROOSTER);
		list.add(Card.TIGER);

		Collections.shuffle(list);

		listRed.add(list.get(0));
		listRed.add(list.get(1));
		
		listBlue.add(list.get(2));
		listBlue.add(list.get(4));

		queue.add(list.get(5));

	}

	public static void exchangeCard(OnitamaCard card){
		
		if(OnitamaMatch.getCurrentPlayer() == Color.RED){
			for(Card c : listRed){
				if (c == card.card) {
					queue.add(card.card);
					listRed.add(queue.peek());
					listRed.remove(card.card);
					queue.remove();
				}
			}
		} else if (OnitamaMatch.getCurrentPlayer() == Color.BLUE) {
			for(Card c : listBlue){
				if (c == card.card) {
					queue.add(card.card);
					listBlue.add(queue.peek());
					listBlue.remove(card.card);
					queue.remove();
				}
			}
		}

	}
	
	public void setCard(Card card) {
		OnitamaCard.card = card;
	}

	public static Card getCard() {
		return card;
	}

	public static MyLinkedListSingle<Card> getListRed() {
		return listRed;
	}

	public static MyLinkedListSingle<Card> getListBlue() {
		return listBlue;
	}

	public static MyQueueLinkedList<Card> getQueue() {
		return queue;
	}
	
}
