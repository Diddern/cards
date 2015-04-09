package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Types extends Pairs {
	protected Array<Array<Card>> types;

	public Types(Hand hand, Table table) {
		super(hand, table);
		makeTypes();
	}

	private void makeTypes() {
		for (int i = 0; i < h.getHandSize(); i++) {
			if (hasCardOfThisType(i)) {
				types.add(getCardOfThisType(i));
			}
		}
	}

	private boolean hasCardOfThisType(int i) {
		return t.hasCardsOfThisSuit(h.getCardAtPosition(i));
	}

	private Array<Card> getCardOfThisType(int i) {
		return t.getCardsOfThisSuit(h.getCardAtPosition(i));
	}

}
