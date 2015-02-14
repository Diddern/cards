package test.structure.deck;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import card.structure.deck.CardDeck;

public class TestCardDeck {

	private ArrayList<CardDeck> cardDeckWithJoker = new ArrayList<CardDeck>();
	private ArrayList<CardDeck> cardDeckWithoutJoker = new ArrayList<CardDeck>();
	private int size = 1000;
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
			assertTrue(cardDeckWithJoker.get(i).getDeckSize() == 54);
			assertTrue(cardDeckWithoutJoker.get(i).getDeckSize() == 52);
		}
	}

	@Test
	public void testStruckture() {

	}

}
