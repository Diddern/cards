package gamedata.poker.imports;

import game.structure.Constants;
import gamedata.poker.PokerData;

public class TexasHoldem extends PokerData {

	Constants con;

	public TexasHoldem() {
		con = new Constants(2, 5, false);

	}

	public Constants getConstants() {
		return con;
	}

}
