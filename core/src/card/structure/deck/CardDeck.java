package card.structure.deck;

import java.util.ArrayList;

public class CardDeck {

	private ArrayList<Card> cardDeck = new ArrayList<Card>();
	String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers", "Joker" };

	public CardDeck(boolean withJoker) {
		if (withJoker == false) {
			makeCardDeck();
		} else {
			makeCardDeckWithJoker();
		}
	}

	private void makeCardDeckWithJoker() {
		makeCardDeck();
		for (int i = 0; i < 2; i++) {
			cardDeck.add(new Card(i, cardTypes[i]));
		}
	}

	private void makeCardDeck() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 13; k++) {
				cardDeck.add(new Card(k, cardTypes[k]));
			}
		}
	}

	public Card getCard(int posisjon) {
		if (posisjon < cardDeck.size())
			return cardDeck.get(posisjon);
		else
			return null;
	}

	public void putCardBackInn(int posisjon, Card card) {
		if (posisjon < cardDeck.size()) {
			cardDeck.add(posisjon, card);
		}
	}

}
