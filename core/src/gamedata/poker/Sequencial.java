package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Sequencial {
	protected Array<Card> sequencial;
	protected Hand h;
	protected Table t;
	private int indexOfHand;
	private int indexOfTable;
	private int size;
	private boolean hasStraight;

	public Sequencial(Hand hand, Table table) {
		sequencial = new Array<Card>();
		h = hand;
		t = table;
		createSequence();
	}

	private boolean notOutOfIndex(int i, Hand h) {
		return i < h.getHandSize();
	}

	private int getTotalSize(Hand h, Table t) {
		return h.getHandSize() + t.getTableSize();

	}

	private int getCardNumber(int i, Table t) {
		return t.getCardAtPosition(i).getNumber();
	}

	private int getCardNumber(int i, Hand h) {
		return h.getCardAtPosition(i).getNumber();
	}

	private Card getTheSmallestCard(int indexOfHand, int indexOfTable, Table t,
			Hand h) {
		if (notOutOfIndex(indexOfHand, h)
				|| getCardNumber(indexOfHand, h) >= getCardNumber(indexOfTable,
						t)) {
			indexOfTable++;
			return t.getCardAtPosition(indexOfTable - 1);
		} else {
			indexOfHand++;
		}
		return h.getCardAtPosition(indexOfHand - 1);

	}

	private void createSequence() {
		size = getTotalSize(h, t);
		indexOfHand = 0;
		indexOfTable = 0;
		for (int i = 0; i < size; i++) {
			sequencial.add(getTheSmallestCard(indexOfHand, indexOfTable, t, h));
		}
	}

	private int getNumberOf(int i) {
		return sequencial.get(i).getNumber();
	}

	public boolean hasStraight() {
		hasStraight = false;
		for (int i = 4; i < sequencial.size; i++) {
			int a = getNumberOf(i - 4);
			int b = getNumberOf(i - 3);
			int c = getNumberOf(i - 2);
			int d = getNumberOf(i - 1);
			int e = getNumberOf(i);

			if (a + 1 == b && b + 1 == c && c + 1 == d && d + 1 == e) {
				hasStraight = true;
			}
		}
		return hasStraight;
	}

}
