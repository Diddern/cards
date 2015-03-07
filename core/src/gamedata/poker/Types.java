package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Types extends Pairs {
	protected Array<Array<Card>> types;
	private QuickSort qs;

	public Types(Hand hand, Table table) {
		super(hand, table);
		qs = new QuickSort();
	}

	public void getTypes() {
		for (int i = 0; i < h.getHandSize(); i++) {
			if (hasCardOfThisType(i)) {
				types.add(getCardOfThisType(i));
			}
		}
	}

	private boolean hasCardOfThisType(int i) {
		return t.hasCardsOfThisType(h.getCardAtPosition(i));
	}

	private Array<Card> getCardOfThisType(int i) {
		return t.getCardsOfThisType(h.getCardAtPosition(i));
	}

	private void sort(Array<Card> card) {
		for (int i = 0; i < types.size; i++) {
			qs.sort(types.get(i));
		}
	}

}
