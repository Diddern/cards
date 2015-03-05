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

	private Abstraksjoner a = new Abstraksjoner();
	private Array<Card> cardsOnHand;

	private int size;

	/**
	 * Takes in the size of the allowed hand of the player
	 * 
	 * @param size
	 *            i the hand size
	 */
	public Hand(int size) {
		this.size = size;
		cardsOnHand = new Array<Card>();
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
	 * gives you the size of the hand
	 * 
	 * @return the integer size
	 */
	public int getHandSize() {
		return cardsOnHand.size;
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

	public Card getBiggestCardOnHand() {
		return a.getBiggestCardOnHand(cardsOnHand);
	}

	public Array<Card> getCardsOfThisType(Card card) {
		return a.getCardsOfThisType(card, cardsOnHand);
	}

	public boolean hasCardsOfThisType(Card card) {
		return a.hasCardsOfThisType(card, cardsOnHand);

	}

	public boolean hasCardOfThisRank(Card card) {
		return a.hasCardOfThisRank(card, cardsOnHand);
	}

	public Array<Card> getCardsOfThisRank(Card card) {
		return a.getCardsOfThisRank(card, cardsOnHand);
	}

}
