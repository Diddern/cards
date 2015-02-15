package card.function.shuffle;

import java.util.Random;

import card.structure.deck.Card;
import card.structure.deck.CardDeck;

public class ShuffleCards {
	private Random r1, r2;

	/**
	 * Tror ikke det går ann å teste denne skikkelig. Det e vel det som e
	 * problemet med random.
	 * 
	 * @param deck
	 */
	public CardDeck shuffleCards(CardDeck deck) {
		r1 = new Random(deck.getDeckSize());
		r2 = new Random(deck.getDeckSize() - 1);

		for (int i = 0; i < 1000; i++) {
			int random1 = r1.nextInt(deck.getDeckSize());
			Card card = deck.takeCard(random1);

			int random2 = r2.nextInt(deck.getDeckSize());
			if (random1 == random2) {
				System.out.println("feil");
			}
			deck.putCardBackInn(random2, card);
		}
		return deck;
	}

}
