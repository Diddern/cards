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

}
