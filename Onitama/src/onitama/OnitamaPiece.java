package onitama;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class OnitamaPiece extends Piece {

	private Color color;
	
	public OnitamaPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		OnitamaPiece piece = (OnitamaPiece)getBoard().piece(position);
		return piece != null && piece.getColor() != this.color;
	}

}
