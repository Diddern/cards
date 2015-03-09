package gamedata.poker.imports;

import game.structure.Constants;
import perspective.player.Dealer;
import perspective.player.Player;

import com.badlogic.gdx.utils.Array;

public class TexasHoldem {

	Constants con;

	public TexasHoldem() {
		con = new Constants(2, 5, false);
	}

	public Constants getConstants() {
		return con;
	}

	public int getWinner(Array<Player> players, Dealer dealer) {
		return 0;
	}

}
