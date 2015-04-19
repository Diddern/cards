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
	 * hand. Does not check if the hand is full. Sorts the hand after.
	 * 
	 * @param c
	 *            the card that will be added
	 */
	public void addCardToHand(Card c) {
		cardsOnHand.add(c);
		sort();
	}

	/**
	 * This method returns the biggest card on the hand.
	 * 
	 * @return The biggest card on hand
	 */
	public Card getBiggestCardOnHand() {
		return a.getBiggestCardOnHand(cardsOnHand);
	}

	/**
	 * Gets all cards on hand with the same suit as the parameterized one
	 * @param card The card for which we compare suits
	 * @return All cards of the same suit
	 */
	public Array<Card> getCardsOfThisSuit(Card card) {
		return a.getCardsOfThisSuit(card, cardsOnHand);
	}

	/**
	 * Checks if there are any cards in the deck with the same suit as the parameterized card
	 * @param card The card for which we compare suits
	 * @return true if any card in the deck has the same suit, false otherwise
	 */
	public boolean hasCardsOfThisSuit(Card card) {
		return a.hasCardsOfThisSuit(card, cardsOnHand);
	}
	
	/**
	 * Checks if there are any cards in the deck with the same value as the parameterized card
	 * @param card The card for which we compare values
	 * @return true if any card in the deck has the same value, false otherwise
	 */
	public boolean hasCardOfThisValue(Card card) {
		return a.hasCardOfThisValue(card, cardsOnHand);
	}

	/**
	 * Gets all cards on hand with the same value as the parameterized one
	 * @param card The card for which we compare values
	 * @return All cards of the same value
	 */
	public Array<Card> getCardsOfThisValue(Card card) {
		return a.getCardsOfThisValue(card, cardsOnHand);
	}

	/**
	 * Returns the card at the given positional index
	 * @param i index of the card we want
	 * @return The card at index i
	 */
	public Card getCardAtPosition(int i) {
		return a.getCardAtPosition(i, cardsOnHand);
	}

	/**
	 * Sorts the hand using the sorting algorithm specified in class Abstractions.
	 */
	private void sort() {
		Array<Card> temp;
		temp = a.sortCardDeck(cardsOnHand);
		cardsOnHand = temp;
	}

}
