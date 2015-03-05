package card.structure.deck;

/**
 * This class represents the basic card that goes in a cardDeck
 * 
 * @author Bobby
 *
 */
public class Card {

	private String type;
	private int number;

	public Card(int number, String type) {
		this.number = number;
		this.type = type;
	}

	/**
	 * This method returns the type of card it is. The choices are Spade,
	 * Hearts, Diamonds, Clovers, Joker.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
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
			if (sameType(card))
				return true;
		}
		return false;
	}

	public boolean sameRank(Card c) {
		return c.getNumber() == number;

	}

	public boolean sameType(Card c) {
		return c.type.equals(type);
	}
}
