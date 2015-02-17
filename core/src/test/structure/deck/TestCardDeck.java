package test.structure.deck;

import static org.junit.Assert.*;

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
	private String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers", "Joker" };
	private Random r = new Random();

	@Before
	public void setup() {
		for (int i = 0; i < this.size; i++) {
			this.cardDeckWithJoker.add(new CardDeck(true));
			this.cardDeckWithoutJoker.add(new CardDeck(false));
		}
	}

	@Test
	public void testSize() {
		for (int i = 0; i < this.size; i++) {
			assertTrue(this.cardDeckWithoutJoker.get(i).getDeckSize() == 52);
			assertTrue(this.cardDeckWithJoker.get(i).getDeckSize() == 54);
		}
	}

	@Test
	public void testStruckture() {
		for (int q = 0; q < this.size; q++) {
			int mellom = 0;
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < 13; k++) {
					Card cardWJ = this.cardDeckWithJoker.get(mellom).lookAtCard(mellom);
					Card card = this.cardDeckWithoutJoker.get(mellom).lookAtCard(mellom);
					Card newCard = new Card(k, this.cardTypes[i]);

					assertTrue(cardWJ.getNumber() == newCard.getNumber());
					assertTrue(cardWJ.getType().equals(newCard.getType()));
					assertTrue(card.getNumber() == newCard.getNumber());
					assertTrue(card.getType().equals(newCard.getType()));
					mellom++;
				}
			}

			for (int i = 0; i < 2; i++) {
				Card cardWJ = this.cardDeckWithJoker.get(mellom).lookAtCard(mellom);
				Card newCard = new Card(i, this.cardTypes[4]);
				assertTrue(cardWJ.getNumber() == newCard.getNumber());
				assertTrue(cardWJ.getType().equals(newCard.getType()));
				mellom++;
			}
		}
	}

	@Test
	public void testTakeCard() {
		for (int q = 0; q < this.size; q++) {
			int sizes = this.cardDeckWithJoker.get(q).getDeckSize();
			int randomInterval = this.r.nextInt(sizes - 1);
			Card card = this.cardDeckWithJoker.get(q).takeCard(randomInterval);

			int newCardNumber = card.getNumber();
			int cardNumber = this.cardDeckWithJoker.get(q).lookAtCard(randomInterval).getNumber();

			String newCardType = card.getType();
			String cardType = this.cardDeckWithJoker.get(q).lookAtCard(randomInterval).getType();
			assertFalse(newCardNumber == cardNumber && newCardType.equals(cardType));
			assertFalse(card.equals(this.cardDeckWithJoker.get(q)));
			assertTrue(this.cardDeckWithJoker.get(q).getDeckSize() == sizes - 1);
		}

	}

	@Test
	public void testPutCardBackIn() {
		for (int q = 0; q < this.size; q++) {
			int randomsize = this.cardDeckWithJoker.get(q).getDeckSize() - 1;
			int takeRandom = this.r.nextInt(randomsize);
			Card card = this.cardDeckWithJoker.get(q).takeCard(takeRandom);

<<<<<<< HEAD
			int putRandom = randomsize - 1;
=======
			int putRandom = this.r.nextInt(randomsize - 1);
>>>>>>> FETCH_HEAD

			assertFalse(this.cardDeckWithJoker.get(q).lookAtCard(putRandom).equals(card));

<<<<<<< HEAD
			cardDeckWithJoker.get(q).putCardBackInn(card);
			assertTrue(cardDeckWithJoker.get(q).lookAtCard(randomsize)
					.equals(card));
=======
			this.cardDeckWithJoker.get(q).putCardBackInn(putRandom, card);
			assertTrue(this.cardDeckWithJoker.get(q).lookAtCard(putRandom).equals(card));
>>>>>>> FETCH_HEAD
		}
	}

	/**
	 * Tester om kortene er blandet. Siden det ikke kan vær helt blandet, så den
	 * går via en faktor....
	 */

	@Test
	public void testShuffle() {
		int errormargin = 10;
		for (int i = 0; i < this.size; i++) {
			CardDeck cdOldWithJoker = this.cardDeckWithJoker.get(i);
			CardDeck cdOldWithoutJoker = this.cardDeckWithoutJoker.get(i);

			CardDeck newDeckWithJoker = new CardDeck(true);
			CardDeck newDeckWithoutJoker = new CardDeck(false);

			assertTrue(cdOldWithJoker.getDeckSize() == newDeckWithJoker.getDeckSize());
			assertTrue(cdOldWithoutJoker.getDeckSize() == newDeckWithoutJoker.getDeckSize());

			int randomMargin1 = 0;
			int randomMargin2 = 0;

			cdOldWithJoker.shuffleCards();
			cdOldWithoutJoker.shuffleCards();

			for (int k = 0; k < cdOldWithJoker.getDeckSize() - 1; k++) {

				if (newDeckWithJoker.lookAtCard(k).equalsTo(cdOldWithJoker.lookAtCard(k))) {
					randomMargin1++;
				}
			}

			for (int k = 0; k < cdOldWithoutJoker.getDeckSize(); k++) {
				if (newDeckWithoutJoker.lookAtCard(k).equalsTo(cdOldWithoutJoker.lookAtCard(k))) {
					randomMargin2++;
				}

			}

			assertTrue(randomMargin1 < errormargin);
			assertTrue(randomMargin2 < errormargin);
		}
	}
}
