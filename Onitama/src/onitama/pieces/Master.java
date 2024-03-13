package onitama.pieces;

import boardgame.Board;
import boardgame.Position;
import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;
import onitama.pieces.cards.Card;

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
		return Card.possibleMoves(getBoard(), getColor(), getPosition());
	}
	
}
