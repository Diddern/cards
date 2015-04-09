package card.structure.holder;

import gamedata.poker.QuickSort;
import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

public class Abstractions {

	private QuickSort qs = new QuickSort();

	/**
	 * checks if a card with this rank is on this hand.
	 * 
	 * @param c
	 *            Card that will be checked
	 * @return true if it exists.
	 */
	public boolean hasCardOfThisRank(Card card, Array<Card> cardDeck) {
		return getCardsOfThisRank(card, cardDeck).size != 0;
	}

	/**
	 * returns an array with the cards with the rank of this card
	 * 
	 * @param card
	 *            the card that will be checked
	 * @return an array with the cards of this rank
	 */
	public Array<Card> getCardsOfThisRank(Card card, Array<Card> cardDeck) {
		Array<Card> ranks = new Array<Card>();
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameRank(card)) {
				ranks.add(cardDeck.get(i));
			}
		}
		return ranks;
	}

	/**
	 * Checks if there is any cards of this type on your hand.
	 * 
	 * @param type
	 *            the type to check up against
	 * @return true if there is any.
	 */
	public boolean hasCardsOfThisType(Card type, Array<Card> cardDeck) {
		return getCardsOfThisSuit(type, cardDeck).size != 0;

	}

	/**
	 * sends an array of the cards of this type.
	 * 
	 * @param type
	 *            the type that will be checked out.
	 * @return the array of the types.
	 */
	public Array<Card> getCardsOfThisSuit(Card type, Array<Card> cardDeck) {
		Array<Card> types = new Array<Card>();
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameSuit(type)) {
				types.add(cardDeck.get(i));
			}
		}
		return types;
	}

	/**
	 * This method returns the biggest card on the deck.
	 * 
	 * @return The biggest card on deck
	 */
	public Card getBiggestCardOnHand(Array<Card> cardDeck) {
		int score = 0;
		int index = 0;
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).getNumber() >= score) {
				index = i;
				score = cardDeck.get(index).getNumber();
			}

		}
		return cardDeck.get(index);
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
	public Card getCardAtPosition(int i, Array<Card> cardDeck) {
		return cardDeck.get(i);
	}

	public Array<Card> sortCardDeck(Array<Card> cards) {
		return qs.sort(cards);

	}

}
