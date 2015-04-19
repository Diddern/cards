package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Pairs extends Sequencial {

	protected Array<Array<Card>> pairs;

	/**
	 * The constructor of the class that takes inn the hand and the table.
	 * 
	 * @param hand
	 *            is the hand taken into account.
	 * @param table
	 *            is the table taken into account.
	 */

	public Pairs(Hand hand, Table table) {
		super(hand, table);
		pairs = new Array<Array<Card>>();
		makePairs();
	}

	/**
	 * This method collects eventual pairs if they exists.
	 */

	private void makePairs() {
		for (int i = 0; i < h.getHandSize(); i++) {
			if (hasCardOfThisValue(i)) {
				pairs.add(getCardsOfThisValue(i));
			}
		}
	}

	/**
	 * Checks if there are any similar cards in the table that the hand has. So
	 * the index cannot be bigger than the hand size.
	 * 
	 * @param i
	 *            the index of the card on hand that is going to be checked.
	 * @return true if this card exists.
	 * 
	 */
	private boolean hasCardOfThisValue(int i) {
		return t.hasCardOfThisRank(h.getCardAtPosition(i));
	}

	/**
	 * This method returns the card of the suit that the hand has. The index
	 * cannot be bigger than the hand size.
	 * 
	 * @param i
	 *            is the index of the card on hand that is going to be checked.
	 * @return the card that is the same suit
	 */

	private Array<Card> getCardsOfThisValue(int i) {
		return t.getCardsOfThisRank(h.getCardAtPosition(i));
	}

	/**
	 * checks if there are any pairs
	 * 
	 * @return true if it has any pairs
	 */
	private boolean hasPairs() {
		return pairs.size != 0;
	}

	/**
	 * Checks if there exists one pair
	 * 
	 * @return true if there exists one pair
	 */

	public boolean hasOnePair() {
		if (hasPairs())
			return pairs.size == 1 && pairs.get(0).size == 2;
		return false;
	}

	/**
	 * Checks if the are 3 of a kind.
	 * 
	 * @return true if there are 3 of a kind
	 */

	public boolean has3OfAKind() {
		if (hasPairs())
			return pairs.size == 1 && pairs.get(0).size == 3;
		return false;
	}

	/**
	 * Checks if there are four of a kind
	 * 
	 * @return true if there are four of a kind
	 */

	public boolean fourOfAKind() {
		if (hasPairs()) {
			if (pairs.get(0).size == 4) {
				int card1 = pairs.get(0).get(0).getValue();
				int card2 = pairs.get(0).get(1).getValue();
				int card3 = pairs.get(0).get(2).getValue();
				int card4 = pairs.get(0).get(3).getValue();
				if (card1 == card2 && card2 == card3 && card3 == card4)
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks if there are two pairs.
	 * 
	 * @return true if there are two pairs.
	 */

	public boolean twoPairs() {
		if (hasPairs()) {
			if (pairs.size == 2) {
				int card1 = pairs.get(0).get(0).getValue();
				int card2 = pairs.get(0).get(1).getValue();
				int card3 = pairs.get(1).get(2).getValue();
				int card4 = pairs.get(1).get(3).getValue();
				if (!(card1 == card2 && card3 == card4 && card3 != card2))
					return true;
			}
		}
		return false;

	}

}
