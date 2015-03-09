package perspective.player;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

public class Dealer {
	private Hand hand;
	private Table table;

	public Dealer(Hand hand, Table table) {
		this.hand = hand;
		this.table = table;
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

}
