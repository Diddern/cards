package card.structure.holder;

import perspective.player.Player;
import card.structure.deck.Card;
import card.structure.deck.CardDeck;

import com.badlogic.gdx.utils.Array;

/**
 * The Table holds the cardDeck. It deals the cards to the players.
 * 
 * @author Bobby
 *
 */
public class Table {

	private Abstraksjoner a = new Abstraksjoner();
	private CardDeck cardDeck;
	private Array<Player> players;
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
	public Table(CardDeck d, Array<Player> p) {
		cardDeck = d;
		players = p;
		cardsOnTable = new Array<Card>();
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
	 * This method puts cards on the table.
	 * 
	 * @param numberOfCardsOnTheTable
	 *            number of cards that are to be put on the table.
	 */
	public void addCardsToTable(int numberOfCardsOnTheTable) {
		for (int i = 0; i < numberOfCardsOnTheTable; i++) {
			addACardToTable();
		}
	}

	/**
	 * Ads a card to the table
	 * 
	 */
	private void addACardToTable() {
		cardsOnTable.add(cardDeck.takeCard(cardDeck.getDeckSize() - 1));
	}

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
	public Array<Card> getCardsOfThisType(Card card) {
		return a.getCardsOfThisType(card, cardsOnTable);
	}

	/**
	 * Checks if there is any cards of this type on your hand.
	 * 
	 * @param type
	 *            the type to check up against
	 * @return true if there is any.
	 */
	public boolean hasCardsOfThisType(Card card) {
		return a.hasCardsOfThisType(card, cardsOnTable);

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
		return a.hasCardOfThisRank(card, cardsOnTable);
	}

	/**
	 * returns an array with the cards with the rank of this card
	 * 
	 * @param card
	 *            the card that will be checked
	 * @return an array with the cards of this rank
	 */
	public Array<Card> getCardsOfThisRank(Card card) {
		return a.getCardsOfThisRank(card, cardsOnTable);
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

}
