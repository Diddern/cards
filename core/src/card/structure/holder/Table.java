package card.structure.holder;

import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

/**
 * The Table holds the cardDeck. It deals the cards to the players.
 * 
 * @author Bobby
 *
 */
public class Table {

	private Abstractions a = new Abstractions();
	private Array<Card> cardsOnTable;

	/**
	 * Creates a table by taking the card deck and number of players. The
	 * cardDeck is used to divide cards on the table;
	 * 
	 * @param d
	 *            cardDeck being used
	 * @param p
	 *            number of players.
	 */
	public Table(int sizeOfTable) {
		cardsOnTable = new Array<Card>(sizeOfTable);
	}

	/**
	 * Returns the array of cards that are one the table
	 * 
	 * @return An array of cards.
	 */
	public Array<Card> getCardsOnTable() {
		return cardsOnTable;
	}

	/**
	 * Ads a card to the table
	 * 
	 */
	public void addACardToTable(Card card) {
		cardsOnTable.add(card);
		sort();
	}

	/**
	 * sorting the deck
	 */

	/**
	 * Finds the index of the specified card.
	 * 
	 * @param c
	 *            the card that is gonna be found the index of.
	 * @return the index of the card.
	 */
	public int getIndexOfCardOnTable(Card c) {
		return cardsOnTable.indexOf(c, true);
	}

	/**
	 * This method returns the biggest card in the deck.
	 * 
	 * @return The biggest card on deck
	 */
	public Card getBiggestCard() {
		return a.getBiggestCardOnHand(cardsOnTable);
	}

	/**
	 * sends an array of the cards of this type.
	 * 
	 * @param type
	 *            the type that will be checked out.
	 * @return the array of the types.
	 */
	public Array<Card> getCardsOfThisSuit(Card card) {
		return a.getCardsOfThisSuit(card, cardsOnTable);
	}

	/**
	 * Checks if there is any cards of this type on your hand.
	 * 
	 * @param type
	 *            the type to check up against
	 * @return true if there is any.
	 */
	public boolean hasCardsOfThisSuit(Card card) {
		return a.hasCardsOfThisSuit(card, cardsOnTable);

	}

	public int getTableSize() {
		return cardsOnTable.size;
	}

	/**
	 * checks if a card with this rank is on this hand.
	 * 
	 * @param c
	 *            Card that will be checked
	 * @return true if it exists.
	 */
	public boolean hasCardOfThisRank(Card card) {
		return a.hasCardOfThisValue(card, cardsOnTable);
	}

	/**
	 * returns an array with the cards with the rank of this card
	 * 
	 * @param card
	 *            the card that will be checked
	 * @return an array with the cards of this rank
	 */
	public Array<Card> getCardsOfThisRank(Card card) {
		return a.getCardsOfThisValue(card, cardsOnTable);
	}

	/**
	 * Returns a card at the specified position in the deck you give
	 * 
	 * @param i
	 *            position
	 * @param cardDeck
	 *            the deck you give
	 * @return the specific card.
	 */

	public Card getCardAtPosition(int i) {
		return a.getCardAtPosition(i, cardsOnTable);
	}

	private void sort() {
		Array<Card> temp;
		temp = a.sortCardDeck(cardsOnTable);
		cardsOnTable = temp;
	}

}
