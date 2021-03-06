package test.structure.deck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import card.structure.deck.Card;
import card.structure.deck.CardDeck;

public class TestCardDeck {

	private ArrayList<CardDeck> cardDeckWithJoker = new ArrayList<CardDeck>();
	private ArrayList<CardDeck> cardDeckWithoutJoker = new ArrayList<CardDeck>();
	private int size = 1000;
	private String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers",
			"Joker" };
	private Random r = new Random();

	@Before
	public void setup() {
		for (int i = 0; i < size; i++) {
			cardDeckWithJoker.add(new CardDeck(true));
			cardDeckWithoutJoker.add(new CardDeck(false));
		}
	}

	@Test
	public void testSize() {
		for (int i = 0; i < size; i++) {
			assertTrue(cardDeckWithoutJoker.get(i).getDeckSize() == 52);
			assertTrue(cardDeckWithJoker.get(i).getDeckSize() == 54);
		}
	}

	@Test
	public void testStruckture() {
		for (int q = 0; q < size; q++) {
			int mellom = 0;
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < 13; k++) {
					Card cardWJ = cardDeckWithJoker.get(mellom).lookAtCard(
							mellom);
					Card card = cardDeckWithoutJoker.get(mellom).lookAtCard(
							mellom);
					Card newCard = new Card(k, cardTypes[i]);

					assertTrue(cardWJ.getValue() == newCard.getValue());
					assertTrue(cardWJ.getSuit().equals(newCard.getSuit()));
					assertTrue(card.getValue() == newCard.getValue());
					assertTrue(card.getSuit().equals(newCard.getSuit()));
					mellom++;
				}
			}

			for (int i = 0; i < 2; i++) {
				Card cardWJ = cardDeckWithJoker.get(mellom).lookAtCard(mellom);
				Card newCard = new Card(i, cardTypes[4]);
				assertTrue(cardWJ.getValue() == newCard.getValue());
				assertTrue(cardWJ.getSuit().equals(newCard.getSuit()));
				mellom++;
			}
		}
	}

	@Test
	public void testTakeCard() {
		for (int q = 0; q < size; q++) {
			int sizes = cardDeckWithJoker.get(q).getDeckSize();
			int randomInterval = r.nextInt(sizes - 1);
			Card card = cardDeckWithJoker.get(q).takeCard(randomInterval);

			int newCardNumber = card.getValue();
			int cardNumber = cardDeckWithJoker.get(q)
					.lookAtCard(randomInterval).getValue();

			String newCardType = card.getSuit();
			String cardType = cardDeckWithJoker.get(q)
					.lookAtCard(randomInterval).getSuit();
			assertFalse(newCardNumber == cardNumber
					&& newCardType.equals(cardType));
			assertFalse(card.equals(cardDeckWithJoker.get(q)));
			assertTrue(cardDeckWithJoker.get(q).getDeckSize() == sizes - 1);
		}

	}

	@Test
	public void testPutCardBackIn() {
		for (int q = 0; q < size; q++) {
			int randomsize = cardDeckWithJoker.get(q).getDeckSize() - 1;
			int takeRandom = r.nextInt(randomsize);
			Card card = cardDeckWithJoker.get(q).takeCard(takeRandom);

			int putRandom = randomsize - 1;

			assertFalse(cardDeckWithJoker.get(q).lookAtCard(putRandom)
					.equals(card));

			cardDeckWithJoker.get(q).putCardBackIn(card);
			assertTrue(cardDeckWithJoker.get(q).lookAtCard(randomsize)
					.equals(card));
		}
	}

	/**
	 * Tester om kortene er blandet. Siden det ikke kan vær helt blandet, så den
	 * går via en faktor....
	 */

	@Test
	public void testShuffle() {
		int errormargin = 10;
		for (int i = 0; i < size; i++) {
			CardDeck cdOldWithJoker = cardDeckWithJoker.get(i);
			CardDeck cdOldWithoutJoker = cardDeckWithoutJoker.get(i);

			CardDeck newDeckWithJoker = new CardDeck(true);
			CardDeck newDeckWithoutJoker = new CardDeck(false);

			assertTrue(cdOldWithJoker.getDeckSize() == newDeckWithJoker
					.getDeckSize());
			assertTrue(cdOldWithoutJoker.getDeckSize() == newDeckWithoutJoker
					.getDeckSize());

			int randomMargin1 = 0;
			int randomMargin2 = 0;

			cdOldWithJoker.shuffleCards();
			cdOldWithoutJoker.shuffleCards();

			for (int k = 0; k < cdOldWithJoker.getDeckSize() - 1; k++) {

				if (newDeckWithJoker.lookAtCard(k).equalsTo(
						cdOldWithJoker.lookAtCard(k))) {
					randomMargin1++;
				}
			}

			for (int k = 0; k < cdOldWithoutJoker.getDeckSize(); k++) {
				if (newDeckWithoutJoker.lookAtCard(k).equalsTo(
						cdOldWithoutJoker.lookAtCard(k))) {
					randomMargin2++;
				}

			}

			assertTrue(randomMargin1 < errormargin);
			assertTrue(randomMargin2 < errormargin);
		}
	}
}
