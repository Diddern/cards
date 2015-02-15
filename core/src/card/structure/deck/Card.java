package card.structure.deck;

public class Card {
	private String type;
	private int number;

	public Card(int number, String type) {
		this.number = number;
		this.type = type;
	}

	public String getType() {
		return type;
	}

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
		if (card.getNumber() == number) {
			if (type.equals(card.getType()))
				return true;
		}
		return false;
	}
}
