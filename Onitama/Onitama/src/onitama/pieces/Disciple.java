package onitama.pieces;

import boardgame.Board;
import onitama.Color;
import onitama.OnitamaPiece;

public class Disciple extends OnitamaPiece {

	public Disciple(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "D";
	}

}
