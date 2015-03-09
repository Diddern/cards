package perspective.player;

import card.structure.deck.Card;
import card.structure.deck.CardDeck;
import card.structure.holder.Hand;
import card.structure.holder.Table;

public class Dealer {
	private Hand hand;
	private Table table;
	private CardDeck deck;

	public Dealer(Hand hand, Table table, CardDeck cardDeck) {
		this.hand = hand;
		this.table = table;
		deck = cardDeck;
	}

	public void giveCard(Card c) {
		if (!hand.isHandFull()) {
			hand.addCardToHand(c);
		}
	}

	public Hand lookAtHand() {
		return hand;
	}

	public Table lookAtTable() {
		return table;
	}

	public void addCardToTable() {
		table.addACardToTable(deck.takeCard(deck.getDeckSize() - 1));
	}

}
