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
		hand = this.hand;
	}

	public void getCard(Card c) {
		if (!hand.isHandFull()) {
			hand.addCardToHand(c);
		}
	}

}
