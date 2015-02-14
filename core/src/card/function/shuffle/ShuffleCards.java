package card.function.shuffle;

import java.util.Random;

import card.structure.deck.Card;
import card.structure.deck.CardDeck;

public class ShuffleCards {
	private Random r;

	public void shuffleCards(CardDeck deck) {
		r = new Random();
		int size = deck.getDeckSize();
		for (int i = 0; i < 1000; i++) {
			Card card = deck.takeCard(r.nextInt(size));
			deck.putCardBackInn(r.nextInt(size), card);
		}
	}

}
