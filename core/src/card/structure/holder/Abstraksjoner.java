package card.structure.holder;

import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

public class Abstraksjoner {

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
	 * returns the card with the rank of this card
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
		return getCardsOfThisType(type, cardDeck).size != 0;

	}

	/**
	 * sends an array of the cards of this type.
	 * 
	 * @param type
	 *            the type that will be checked out.
	 * @return the array of the types.
	 */
	public Array<Card> getCardsOfThisType(Card type, Array<Card> cardDeck) {
		Array<Card> types = new Array<Card>();
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameType(type)) {
				types.add(cardDeck.get(i));
			}
		}
		return types;
	}

	/**
	 * This method returns the biggest card on the deck.
	 * 
	 * @return
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

}
