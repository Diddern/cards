package perspective.player;

import card.structure.deck.Card;
import card.structure.holder.Hand;

/**
 * Player has a hand. It should have all the abilities that a normal player has.
 * 
 * Added a comment for show..
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
		if (!this.hand.isHandFull()) {
			this.hand.addCardToHand(c);
		}
	}
	
	// another comment

	public Hand lookAtHand() {
		return this.hand;
	}

}
