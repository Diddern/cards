package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Types extends Pairs {
	protected Array<Array<Card>> types;

	public Types(Hand hand, Table table) {
		super(hand, table);
		makeListOfSuits();
	}

	private void makeListOfSuits() {
		for (int i = 0; i < h.getHandSize(); i++) {
			if (hasCardOfThisSuit(i)) {
				types.add(getCardOfThisSuit(i));
			}
		}
	}

	private boolean hasCardOfThisSuit(int i) {
		return t.hasCardsOfThisSuit(h.getCardAtPosition(i));
	}

	private Array<Card> getCardOfThisSuit(int i) {
		return t.getCardsOfThisSuit(h.getCardAtPosition(i));
	}

}
