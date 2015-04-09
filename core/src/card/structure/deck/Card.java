package card.structure.deck;

/**
 * This class represents the basic card that goes in a cardDeck
 * 
 * @author Bobby
 *
 */
public class Card {

	private String suit;
	private int number;

	public Card(int number, String suit) {
		this.number = number;
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
	 * This method returns the number of the card. It is between 0 to 12, where
	 * 0 is Ace, 10 is jack, 11 is queen, and 12 is king.
	 * 
	 * @return an integer from 0 to 12
	 */
	public int getNumber() {
		return number;
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
		return c.getNumber() == number;

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
