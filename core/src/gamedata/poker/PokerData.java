package gamedata.poker;

import card.structure.holder.Hand;
import card.structure.holder.Table;

/**
 * If there are multiple hands of the same rank at the showdown,the pot is
 * divided equally between the winning players.
 * 
 * the hierarchy is:
 * 
 * Straight flush: A straight flush is a hand that contains five cards in
 * sequence, all of the same suit.
 * 
 * Four of a kind: Four of a kind, also known as quads, is a poker hand that
 * contains all four cards of one rank and any other.
 * 
 * Full House: A full house, also known as a full boat, is a hand that contains
 * three matching cards of one rank and two matching cards of another rank.
 * 
 * Flush: A flush is a poker hand where all five cards are of the same suit, but
 * not in sequence.
 * 
 * Straight: A straight is a poker hand that contains five cards of sequential
 * rank in at least two different suits.
 * 
 * Three of a kind: Three of a kind, also called trips or a set, is a poker hand
 * that contains three cards of the same rank, plus two cards which are not of
 * this rank nor the same as each other.
 * 
 * Two pair: A poker hand that contains two cards of the same rank, plus two
 * cards of another rank (that match each other but not the first pair), plus
 * any card not of either rank, is called two pair.
 * 
 * One pair: One pair is a poker hand that contains two cards of one rank, plus
 * three cards which are not of this rank nor the same as each other.
 * 
 * High card: A high-card or no-pair hand is a poker hand made of any five cards
 * not meeting any of the above requirements.
 * 
 * @author Bobby
 *
 */
public class PokerData extends Types {
	public PokerData(Hand hand, Table table) {
		super(hand, table);
	}

}
