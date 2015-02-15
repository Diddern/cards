package test.structure.deck;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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

		}

	}

}
