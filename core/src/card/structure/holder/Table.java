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
	 * checks if the given card exists on the table;
	 * 
	 * @param c
	 *            card that will be checked
	 * @return true if it exists;
	 */
	public boolean checkIfCardIsOnTable(Card c) {
		return cardsOnTable.contains(c, true);
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

	public Card getBiggestCardOnHand() {
		return a.getBiggestCardOnHand(cardsOnTable);
	}

	public Array<Card> getCardsOfThisType(Card card) {
		return a.getCardsOfThisType(card, cardsOnTable);
	}

	public boolean hasCardsOfThisType(Card card) {
		return a.hasCardsOfThisType(card, cardsOnTable);

	}

	public boolean hasCardOfThisRank(Card card) {
		return a.hasCardOfThisRank(card, cardsOnTable);
	}

	public Array<Card> getCardsOfThisRank(Card card) {
		return a.getCardsOfThisRank(card, cardsOnTable);
	}

}
