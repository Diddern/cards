package perspective.player;

import card.structure.deck.Card;
import card.structure.holder.Hand;

/**
 * Player has a hand. It should have all the abilities that a normal player has.
 * 
 * @author Bobby
 *
 */
public class Player {
	private Hand hand;

	public Player(Hand hand) {
		this.hand = hand;
	}

	public void giveCard(Card c) {
		if (!hand.isHandFull()) {
			hand.addCardToHand(c);
		}
	}

	public Hand lookAtHand() {
		return hand;
	}

}
