package card.structure.holder;

import gamedata.poker.QuickSort;
import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

public class Abstractions {

	private QuickSort qs = new QuickSort();

	/**
	 * Checks the deck for cards of the same value as the parameterized one
	 * @param card The card for which we compare value
	 * @param cardDeck The card deck to compare against
	 * @return true if any card in the deck matches the value of the parameterized card, false otherwise
	 */
	public boolean hasCardOfThisValue(Card card, Array<Card> cardDeck) {
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameRank(card)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns all the cards in the deck with the same value as the parameterized one
	 * @param card The card for which we compare value
	 * @param cardDeck The card deck to compare against
	 * @return An array containing all matching-valued cards in the deck
	 */
	public Array<Card> getCardsOfThisValue(Card card, Array<Card> cardDeck) {
		Array<Card> matchingValues = new Array<Card>();
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameRank(card)) {
				matchingValues.add(cardDeck.get(i));
			}
		}
		return matchingValues;
	}

	/**
	 * Checks the deck for cards of the same suit as the parameterized one
	 * @param card The card for which we compare suit
	 * @param cardDeck The card deck to compare against
	 * @return true if any card in the deck matches the suit of the parameterized card, false otherwise
	 */
	public boolean hasCardsOfThisSuit(Card card, Array<Card> cardDeck) {
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameSuit(card)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns all the cards in the deck with the same suit as the parameterized one
	 * @param card The card for which we compare suit
	 * @param cardDeck The card deck to compare against
	 * @return An array containing all matching-suited cards in the deck
	 */
	public Array<Card> getCardsOfThisSuit(Card card, Array<Card> cardDeck) {
		Array<Card> matchingSuits = new Array<Card>();
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).sameSuit(card)) {
				matchingSuits.add(cardDeck.get(i));
			}
		}
		return matchingSuits;
	}

	/**
	 * Finds the largest valued card in the deck
	 * @param cardDeck The card deck to evaluate
	 * @return The card in the deck with the largest value
	 */
	public Card getBiggestCardOnHand(Array<Card> cardDeck) {
		int largestValue = 0;
		int index = 0;
		for (int i = 0; i < cardDeck.size; i++) {
			if (cardDeck.get(i).getValue() >= largestValue) {
				index = i;
				largestValue = cardDeck.get(index).getValue();
			}

		}
		return cardDeck.get(index);
	}
	
	/**
	 * Returns the card at the given positional index
	 * @param i index of the card we want
	 * @param cardDeck The deck in which to look for our card
	 * @return The card at index i
	 */
	public Card getCardAtPosition(int i, Array<Card> cardDeck) {
		return cardDeck.get(i);
		/*
		 * Perhaps this should throw some IndexOutOfBoundsException?
		 */
	}

	/**
	 * Sorts the deck (or part of the deck) using Quicksort
	 * @param cards The unsorted deck
	 * @return A sorted representation of the unsorted input
	 */
	public Array<Card> sortCardDeck(Array<Card> cards) {
		return qs.sort(cards);
	}

}
