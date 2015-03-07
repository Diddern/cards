package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Pairs {

	protected Array<Array<Card>> pairs;
	protected Hand h;
	protected Table t;

	public Pairs(Hand hand, Table table) {
		pairs = new Array<Array<Card>>();
		h = hand;
		t = table;
	}

	public void getPairs() {
		for (int i = 0; i < h.getHandSize(); i++) {
			if (hasCardOfThisRank(i)) {
				pairs.add(getCardsOfThisRank(i));
			}
		}
	}

	private boolean hasCardOfThisRank(int i) {
		return t.hasCardOfThisRank(h.getCardAtPosition(i));
	}

	private Array<Card> getCardsOfThisRank(int i) {
		return t.getCardsOfThisRank(h.getCardAtPosition(i));
	}

	private boolean hasPairs() {
		return pairs.size != 0;
	}

	public boolean hasOnePair() {
		if (hasPairs())
			return pairs.size == 1 && pairs.get(0).size == 2;
		return false;
	}

	public boolean has3OfAKind() {
		if (hasPairs())
			return pairs.size == 1 && pairs.get(0).size == 3;
		return false;
	}

	public boolean fourOfAKind() {
		if (hasPairs()) {
			if (pairs.get(0).size == 4) {
				int card1 = pairs.get(0).get(0).getNumber();
				int card2 = pairs.get(0).get(1).getNumber();
				int card3 = pairs.get(0).get(2).getNumber();
				int card4 = pairs.get(0).get(3).getNumber();
				if (card1 == card2 && card2 == card3 && card3 == card4)
					return true;
			}
		}
		return false;
	}

	public boolean twoPairs() {
		if (hasPairs()) {
			if (pairs.size == 2) {
				int card1 = pairs.get(0).get(0).getNumber();
				int card2 = pairs.get(0).get(1).getNumber();
				int card3 = pairs.get(1).get(2).getNumber();
				int card4 = pairs.get(1).get(3).getNumber();
				if (!(card1 == card2 && card3 == card4 && card3 != card2))
					return true;
			}
		}
		return false;

	}

}
