package game.structure;

import gamedata.poker.imports.TexasHoldem;
import perspective.player.Player;
import card.structure.deck.CardDeck;
import card.structure.holder.Hand;
import card.structure.holder.Table;

import com.badlogic.gdx.utils.Array;

/**
 * Going to be the game hub. All you should need to do is to ask for a game, and
 * it gets the rules and sizes of the game. The simplest way is that this class
 * holds a lot of game classes, that again hold the rules and constants.
 * 
 * @author Bobby
 *
 */
public class GamesTypes {

	/**
	 * All Constant classes
	 */

	private Array<Player> players;
	private TexasHoldem thisGame;
	private Table t;
	private CardDeck deck;

	/**
	 * Unfinished GameTypeChooser. Not sure how to make it abstract enough to
	 * choose everything from choice. So this is the best temporary way.
	 */
	public GamesTypes() {
		thisGame = new TexasHoldem();
		players = new Array<Player>();
	}

	/**
	 * creates the game in the right order.
	 * 
	 * @param numberOfPlayers
	 *            number of players in the game.
	 */
	public void makeGame(int numberOfPlayers) {
		makePlayers(numberOfPlayers);
		makeDeck();
		makeTable();
	}

	/**
	 * Makes a list of players. But it needs input of how many players are
	 * present.
	 * 
	 * @param numberOfPlayers
	 *            The number of players that are supposed to play.
	 */
	private void makePlayers(int numberOfPlayers) {
		for (int i = 0; i < numberOfPlayers; i++) {
			Hand h = new Hand(thisGame.getConstants().getHandSize());
			Player p = new Player(h);
			players.add(p);
		}
	}

	/**
	 * Makes a CardDeck to the game.
	 */
	private void makeDeck() {
		deck = new CardDeck(thisGame.getConstants().getWithJoker());
	}

	/**
	 * Makes a table.
	 */
	public void makeTable() {
		t = new Table(deck, players);
	}

	public int getWinner() {
		return thisGame.getWinner(players, t);
	}

}
