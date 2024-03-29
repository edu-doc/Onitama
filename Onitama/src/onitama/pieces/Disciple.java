package onitama.pieces;

import boardgame.Board;
import onitama.Color;
import onitama.OnitamaPiece;
import onitama.pieces.cards.Card;

public class Disciple extends OnitamaPiece {

	public Disciple(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean[][] possibleMoves() {
		return Card.possibleMoves(getBoard(), getColor(), getPosition());
	}

}
