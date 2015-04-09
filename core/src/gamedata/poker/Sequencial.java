package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Sequencial {
	protected Array<Card> sequencial;
	protected Hand h;
	protected Table t;
	private int indexOfHand;
	private int indexOfTable;
	private int size;
	private boolean hasStraight;

	/**
	 * Constructor for the class.
	 * 
	 * @param hand
	 *            is the hand that is gonna be checked
	 * @param table
	 *            is the table that will be used
	 * 
	 */
	public Sequencial(Hand hand, Table table) {
		sequencial = new Array<Card>();
		h = hand;
		t = table;
		createSequence();
	}

	/**
	 * Checks if the requested index is bigger or out of bounds of the hand.
	 * 
	 * @param i
	 *            is the index
	 * @param h
	 *            is the hand
	 * @return true if it is not out of index.
	 * 
	 */
	private boolean notOutOfIndex(int i, Hand h) {
		return i < h.getHandSize();
	}

	/**
	 * Sends the combined size of the table and the hand.
	 * 
	 * @param h
	 *            is the hand that is given
	 * @param t
	 *            is the table that is given
	 * @return the size of them combined
	 * 
	 */
	private int getTotalSize(Hand h, Table t) {
		return h.getHandSize() + t.getTableSize();

	}

	/**
	 * Sends the number of the card at the given index.
	 * 
	 * @param i
	 *            is the index of the card
	 * @param t
	 *            is the table that the card is going be in
	 * @return the number of the card at that position.
	 */
	private int getCardNumber(int i, Table t) {
		return t.getCardAtPosition(i).getNumber();
	}

	/**
	 * Sends the number of the card at the given index.
	 * 
	 * @param i
	 *            is the index of the card
	 * @param h
	 *            is the hand that the card is going to be found in.
	 * @return the number of the card at that position
	 */

	private int getCardNumber(int i, Hand h) {
		return h.getCardAtPosition(i).getNumber();
	}

	/**
	 * this method sends back the smallest card from the two stacks, the table
	 * and the hand. it makes it easier to create a sequencial card deck.
	 * 
	 * @param indexOfHand
	 *            is the index of hand to check
	 * @param indexOfTable
	 *            is the index if the table to check
	 * @param t
	 *            is the table to check
	 * @param h
	 *            is the hand to check
	 * @return the smallest card.
	 */
	private Card getTheSmallestCard(int indexOfHand, int indexOfTable, Table t,
			Hand h) {
		if (notOutOfIndex(indexOfHand, h)
				|| getCardNumber(indexOfHand, h) >= getCardNumber(indexOfTable,
						t)) {
			indexOfTable++;
			return t.getCardAtPosition(indexOfTable - 1);
		} else {
			indexOfHand++;
		}
		return h.getCardAtPosition(indexOfHand - 1);

	}

	/**
	 * Creates a sequence of cards in an order.
	 */

	private void createSequence() {
		size = getTotalSize(h, t);
		indexOfHand = 0;
		indexOfTable = 0;
		for (int i = 0; i < size; i++) {
			sequencial.add(getTheSmallestCard(indexOfHand, indexOfTable, t, h));
		}
	}

	/**
	 * Gets the number of the newly formed sequence.
	 * 
	 * @param i
	 *            is the index of the sequence.
	 * @return the number.
	 */
	private int getNumberOf(int i) {
		return sequencial.get(i).getNumber();
	}

	/**
	 * This method checks if this combination has a straight.
	 * 
	 * @return true if it has a straight.
	 */
	public boolean hasStraight() {
		hasStraight = false;
		for (int i = 4; i < sequencial.size; i++) {
			int a = getNumberOf(i - 4);
			int b = getNumberOf(i - 3);
			int c = getNumberOf(i - 2);
			int d = getNumberOf(i - 1);
			int e = getNumberOf(i);

			if (a + 1 == b && b + 1 == c && c + 1 == d && d + 1 == e) {
				hasStraight = true;
			}
		}
		return hasStraight;
	}

}
