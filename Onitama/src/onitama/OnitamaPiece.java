package onitama;

import boardgame.Board;
import boardgame.Piece;

public class OnitamaPiece extends Piece {

	private Color color;
	
	public OnitamaPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
