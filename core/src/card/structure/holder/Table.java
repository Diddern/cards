package card.structure.holder;

import perspective.player.Player;
import card.structure.deck.CardDeck;

import com.badlogic.gdx.utils.Array;

/**
 * The Table holds the cardDeck. It deals the cards to the players.
 * 
 * @author Bobby
 *
 */
public class Table {

	private CardDeck cardDeck;
	private Array<Player> players;

	public Table(CardDeck d, Array<Player> p) {
		cardDeck = d;
		players = p;
	}

}
