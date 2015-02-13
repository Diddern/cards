package card.structure.deck;

import java.util.ArrayList;

public class CardDeck {
	private ArrayList<Card> cardDeck = new ArrayList<Card>();
	String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers" };

	public CardDeck() {
		makeCardDeck();
	}

	public String getCardName() {
		return null;
	}

	private void makeCardDeck() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 13; k++) {
				cardDeck.add(new Card(k, cardTypes[k]));
			}
		}
	}
}
