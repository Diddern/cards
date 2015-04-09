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

	private Abstractions a = new Abstractions();
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
		cardsOnHand = new Array<Card>(size);
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
		sort();
	}

	/**
	 * This method returns the biggest card on the deck.
	 * 
	 * @return The biggest card on deck
	 */
	public Card getBiggestCardOnHand() {
		return a.getBiggestCardOnHand(cardsOnHand);
	}

	/**
	 * sends an array of the cards of this type.
	 * 
	 * @param type
	 *            the type that will be checked out.
	 * @return the array of the types.
	 */
	public Array<Card> getCardsOfThisType(Card card) {
		return a.getCardsOfThisType(card, cardsOnHand);
	}

	/**
	 * Checks if there is any cards of this type on your hand.
	 * 
	 * @param type
	 *            the type to check up against
	 * @return true if there is any.
	 */
	public boolean hasCardsOfThisType(Card card) {
		return a.hasCardsOfThisType(card, cardsOnHand);

	}

	/**
	 * checks if a card with this rank is on this hand.
	 * 
	 * @param c
	 *            Card that will be checked
	 * @return true if it exists.
	 */
	public boolean hasCardOfThisRank(Card card) {
		return a.hasCardOfThisRank(card, cardsOnHand);
	}

	/**
	 * returns an array of the cards with the rank of this card
	 * 
	 * @param card
	 *            the card that will be checked
	 * @return an array with the cards of this rank
	 */
	public Array<Card> getCardsOfThisRank(Card card) {
		return a.getCardsOfThisRank(card, cardsOnHand);
	}

	/**
	 * Returns a card at the specified position in the deck you give
	 * 
	 * @param i
	 *            position
	 * @return the specific card.
	 */
	public Card getCardAtPosition(int i) {
		return a.getCardAtPosition(i, cardsOnHand);
	}

	private void sort() {
		Array<Card> temp;
		temp = a.sortCardDeck(cardsOnHand);
		cardsOnHand = temp;
	}

}
