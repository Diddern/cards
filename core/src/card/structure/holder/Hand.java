package card.structure.holder;

import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

/**
 * The hand is what the player can hold when it comes to cards.
 * 
 * @author Bobby
 *
 */
public class Hand {

	private Array<Card> cardsOnHand = new Array<Card>();

	private int size;

	/**
	 * Takes in the size of the allowed hand of the player
	 * 
	 * @param size
	 *            i the hand size
	 */
	public Hand(int size) {
		this.size = size;
	}

	/**
	 * check is the hand is full
	 * 
	 * @return true if it is full, false if not
	 */
	public boolean isHandFull() {
		if (size > cardsOnHand.size)
			return false;
		else
			return true;
	}

	/**
	 * if there is space left in the hand, then a card will be added to the
	 * hand. Does not check if the hand is full.
	 * 
	 * @param c
	 *            the card that will be added
	 */
	public void addCardToHand(Card c) {
		cardsOnHand.add(c);
	}

	public Array<Card> getHand() {
		return cardsOnHand;
	}

}
