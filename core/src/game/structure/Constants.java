package game.structure;

/**
 * Holds all the constants of one game. Like hand size, table size.
 * 
 * @author Bobby
 *
 */

public class Constants {
	private int handSize;
	private int tableSize;
	private boolean withJoker;

	public Constants(int hs, int ts, boolean wj) {
		handSize = hs;
		tableSize = ts;
		withJoker = wj;

	}

	public int getHandSize() {
		return handSize;
	}

	public int getTableSize() {
		return tableSize;
	}

	public boolean getWithJoker() {
		return withJoker;
	}
}
