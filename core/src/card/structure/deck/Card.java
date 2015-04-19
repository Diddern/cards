package card.structure.deck;

/**
 * This class represents the basic card that goes in a cardDeck
 * 
 * @author Bobby
 *
 */
public class Card {

	private String suit;
	private int value;

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	/**
	 * This method returns the type of card it is. The choices are Spade,
	 * Hearts, Diamonds, Clovers, Joker.
	 * 
	 * @return The card's suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * This method returns the value of the card. It is between 0 to 12, where
	 * 0 is Ace, 10 is jack, 11 is queen, and 12 is king.
	 * 
	 * Note that this also means that the value 1 in our representation is equivalent to 2 and so forth. 
	 * 
	 * @return an integer from 0 to 12
	 */
	public int getValue() {
		return value;
	}

	/**
	 * checks if the card given has the same number and is the same type
	 * 
	 * @param card
	 *            the card you want to send
	 * @return true if it is equal
	 */
	public boolean equalsTo(Card card) {
		if (sameRank(card)) {
			if (sameSuit(card))
				return true;
		}
		return false;
	}

	/**
	 * Checks if two cards have the same value
	 * @param c Other card
	 * @return true if both cards have the same value, i.e. they are the same card (but in different suits, unless playing multiple decks)
	 */
	public boolean sameRank(Card c) {
		return c.getValue() == value;

	}

	/**
	 * Checks if two cards are the same suit
	 * @param c Other card
	 * @return true if both cards have the same suit
	 */
	public boolean sameSuit(Card c) {
		return c.suit.equals(suit);
	}
}
