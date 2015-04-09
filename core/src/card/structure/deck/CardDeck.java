package card.structure.deck;

import com.badlogic.gdx.utils.Array;

public class CardDeck {

	/*
	 * Array containing the cards in the deck
	 */
	private Array<Card> cardDeck = new Array<Card>();
	
	/*
	 * String array containing the possible suits, in order to simplify initializing
	 */
	String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers", "Joker" };

	/**
	 * Constructor creating a card deck with or without jokers.
	 * @param withJoker Whether or not the deck should contain jokers.
	 */
	public CardDeck(boolean withJoker) {
		if (withJoker == false) {
			makeCardDeck();
		} else {
			makeCardDeckWithJokers();
		}
	}

	/**
	 * Creating a new card deck containing two jokers.
	 */
	private void makeCardDeckWithJokers() {
		makeCardDeck();
		for (int i = 0; i < 2; i++) {
			cardDeck.add(new Card(i, cardTypes[4]));
		}
	}

	/**
	 * Creating a new classic French card deck without jokers.
	 */
	private void makeCardDeck() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 13; k++) {
				cardDeck.add(new Card(k, cardTypes[i]));
			}
		}
	}

	/**
	 * Removing a card from the deck, meaning that the card is no longer contained within the deck after running this method.
	 * @param position The index of the card to be removed
	 * @return The removed card if the parameterized index is within the range of the deck, null otherwise
	 */
	public Card takeCard(int position) {
		if (position < cardDeck.size) {
			Card card = lookAtCard(position);
			removeCard(position);
			return card;
		} else
			return null;
	}

	/**
	 * Removes a card from a given index
	 * @param position The index of the card to be removed
	 */
	public void removeCard(int position) {
		cardDeck.removeIndex(position);
	}
	
	/**
	 * Puts a given card back into the deck
	 * @param card The card to reinsert
	 */
	public void putCardBackIn(Card card) {
		cardDeck.add(card);
	}

	/**
	 * Retrieves the size of the deck
	 * @return The size of the deck
	 */
	public int getDeckSize() {
		return cardDeck.size;
	}

	/**
	 * Allows us to peek at a card in a given position
	 * @param position The index of the card we wish to peek at
	 * @return The card in the given position
	 */
	public Card lookAtCard(int position) {
		return cardDeck.get(position);
	}

	/**
	 * Shuffles the deck ten times.
	 */
	public void shuffleCards() {
		for (int i = 0; i < 10; i++) {
			cardDeck.shuffle();
		}
	}

}
