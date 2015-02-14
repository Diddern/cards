package test.structure.deck;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import card.structure.deck.Card;

/**
 * En enkel testklasse. Det er ikke så mye som kan bli testet, fordi denne skal
 * være abstrakt.
 * 
 * @author Espen Johnsen
 *
 */
public class TestCard {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int size = 1000;
	private int[] numbers = new int[size];
	Random r = new Random();

	/**
	 * Ser om get metoden fungerer.
	 * 
	 * @author Espen Johnsen
	 */
	@Test
	public void testGetCards() {
		for (int i = 0; i < size; i++) {
			assertTrue(cards.get(i).getNumber() == numbers[i]);
			assertTrue(cards.get(i).getType()
					.equals("kortnummer" + "" + numbers[i]));
		}
	}

	/**
	 * Setter opp en liste med mange forskjellige kort.
	 * 
	 * @author Espen Johnsen
	 */
	@Before
	public void setup() {
		for (int i = 0; i < size; i++) {
			numbers[i] = r.nextInt(13 + 1);
			cards.add(new Card(numbers[i], "kortnummer" + "" + numbers[i]));
		}
	}
}
