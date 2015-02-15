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

					assertTrue(cardWJ.getNumber() == newCard.getNumber());
					assertTrue(cardWJ.getType().equals(newCard.getType()));
					assertTrue(card.getNumber() == newCard.getNumber());
					assertTrue(card.getType().equals(newCard.getType()));
					mellom++;
				}
			}

			for (int i = 0; i < 2; i++) {
				Card cardWJ = cardDeckWithJoker.get(mellom).lookAtCard(mellom);
				Card newCard = new Card(i, cardTypes[4]);
				assertTrue(cardWJ.getNumber() == newCard.getNumber());
				assertTrue(cardWJ.getType().equals(newCard.getType()));
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

			int newCardNumber = card.getNumber();
			int cardNumber = cardDeckWithJoker.get(q)
					.lookAtCard(randomInterval).getNumber();

			String newCardType = card.getType();
			String cardType = cardDeckWithJoker.get(q)
					.lookAtCard(randomInterval).getType();
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

			int putRandom = r.nextInt(randomsize - 1);

			assertFalse(cardDeckWithJoker.get(q).lookAtCard(putRandom)
					.equals(card));

			cardDeckWithJoker.get(q).putCardBackInn(putRandom, card);
			assertTrue(cardDeckWithJoker.get(q).lookAtCard(putRandom)
					.equals(card));
		}
	}
}
