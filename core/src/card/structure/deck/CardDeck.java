package card.structure.deck;

import java.util.ArrayList;

public class CardDeck {

	/**
	 * ArrayListen er for å holde kortene. Korttypene er puttet i en streng
	 * liste for å gjør initialiseringen enklere.
	 */
	private ArrayList<Card> cardDeck = new ArrayList<Card>();
	String[] cardTypes = { "Spade", "Hearts", "Diamonds", "Clovers", "Joker" };

	/**
	 * Konstruktøren trenger å få inn en boolean om den skal ta med jokere eller
	 * ikke. Utenom det så lager den en standard fransk kortstokk.
	 * 
	 * @param withJoker
	 *            Boolean som bestemmer om du vil ha med jokere eller ikke.
	 *            False er om du ikke vil ha med jokere, true om du vil ha med
	 *            jokere.
	 */
	public CardDeck(boolean withJoker) {
		if (withJoker == false) {
			makeCardDeck();
		} else {
			makeCardDeckWithJoker();
		}
	}

	/**
	 * Den private metoden som lager kortdecket med joker.
	 */
	private void makeCardDeckWithJoker() {
		makeCardDeck();
		for (int i = 0; i < 2; i++) {
			cardDeck.add(new Card(i, cardTypes[4]));
		}
	}

	/**
	 * Den private metoden som lager kortdecket uten joker.
	 */
	private void makeCardDeck() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 13; k++) {
				cardDeck.add(new Card(k, cardTypes[i]));
			}
		}
	}

	/**
	 * Metoden tar et kort ut av kortstokken. Det betyr at kortet er fjernet fra
	 * kortstokken når det tas ut.
	 * 
	 * @param posisjon
	 *            : hvor du fjerner kortet ifra.
	 * @return kortet du fjernet. vist det ikke er et kort å fjerne så får du
	 *         NULL.
	 */
	public Card takeCard(int posisjon) {
		if (posisjon < cardDeck.size()) {
			Card card = lookAtCard(posisjon);
			removeCard(posisjon);
			return card;
		} else
			return null;
	}

	/**
	 * fjerner kortet fra posisjonen spesifisert.
	 * 
	 * @param posisjon
	 *            : posisjonen kortet blir fjernet ifra.
	 */

	public void removeCard(int posisjon) {
		cardDeck.remove(posisjon);
	}

	/**
	 * Metoden putter kortet tilbake i kortstokken.
	 * 
	 * @param posisjon
	 *            : posisjonen kortet skal bli puttet tilbake i.
	 * @param card
	 *            : Kortet som skal bli puttet tilbake.
	 */
	public void putCardBackInn(int posisjon, Card card) {
		if (posisjon < cardDeck.size()) {
			cardDeck.add(posisjon, card);
		}
	}

	/**
	 * Returnerer hvor mange elementer det er i listen.
	 * 
	 * @return hvor mange elementer det er i listen.
	 */

	public int getDeckSize() {
		return cardDeck.size();
	}

	/**
	 * Viser kortet ved en spesiel posisjon.
	 * 
	 * @param posisjon
	 *            : posisjonen kortet er i
	 * @return Kortet ved den posisjonen.
	 */
	public Card lookAtCard(int posisjon) {
		return cardDeck.get(posisjon);
	}

}