package gamedata.poker;

import card.structure.deck.Card;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

public class Sequencial {
	protected Array<Array<Card>> sequencial;
	protected Hand h;
	protected Table t;
	private QuickSort qs;

	public Sequencial(Hand hand, Table table) {
		sequencial = new Array<Array<Card>>();
		h = hand;
		t = table;
		qs = new QuickSort();
	}

}
