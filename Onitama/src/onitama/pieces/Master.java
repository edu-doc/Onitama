package onitama.pieces;

import boardgame.Board;
import onitama.Color;
import onitama.OnitamaPiece;

public class Master extends OnitamaPiece {

	public Master(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "M";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
	
}
