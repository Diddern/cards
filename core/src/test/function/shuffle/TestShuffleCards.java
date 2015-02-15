package test.function.shuffle;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import card.function.shuffle.ShuffleCards;
import card.structure.deck.CardDeck;

public class TestShuffleCards {
	private int size = 1000;

	ArrayList<CardDeck> withJoker = new ArrayList<CardDeck>(),
			withoutJoker = new ArrayList<CardDeck>();
	ArrayList<ShuffleCards> shuffle = new ArrayList<ShuffleCards>();

	@Before
	public void setup() {
		for (int i = 0; i < size; i++) {
			withJoker.add(new CardDeck(true));
			withoutJoker.add(new CardDeck(false));
			shuffle.add(new ShuffleCards());
		}
	}

	@Test
	public void testShuffle() {
		for (int i = 0; i < size; i++) {
			CardDeck cdOldWithJoker = withJoker.get(i);
			CardDeck cdOldWithoutJoker = withoutJoker.get(i);
			ShuffleCards shuffleCards = shuffle.get(i);

			CardDeck newcd1 = shuffleCards.shuffleCards(cdOldWithJoker);
			CardDeck newcd2 = shuffleCards.shuffleCards(cdOldWithoutJoker);

			assertTrue(cdOldWithJoker.getDeckSize() == newcd1.getDeckSize());
			assertTrue(cdOldWithoutJoker.getDeckSize() == newcd2.getDeckSize());
			int randomMargin1 = 0;
			int randomMargin2 = 0;

			for (int k = 0; k < cdOldWithJoker.getDeckSize() - 1; k++) {

				if (newcd1.lookAtCard(k).equalsTo(cdOldWithJoker.lookAtCard(k))) {
					randomMargin1++;
				}
			}

			for (int k = 0; k < cdOldWithoutJoker.getDeckSize(); k++) {
				if (newcd2.lookAtCard(k).equalsTo(
						cdOldWithoutJoker.lookAtCard(k))) {
					randomMargin2++;
				}

			}

			assertTrue(randomMargin1 < 55);
			assertTrue(randomMargin2 < 55);
		}
	}

}
