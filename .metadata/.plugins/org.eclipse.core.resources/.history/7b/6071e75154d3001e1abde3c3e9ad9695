package onitama;

import boardgame.Board;
import boardgame.Position;
import onitama.pieces.Disciple;
import onitama.pieces.Master;

public class OnitamaMatch {

	private Board board;
	
	public OnitamaMatch() {
		this.board = new Board(5,5);
		initialSetup();
	}
	
	public OnitamaPiece[][] getPieces(){
		OnitamaPiece[][] mat = new OnitamaPiece[board.getRows()][board.getColumns()];
		for (int i= 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				mat[i][j]= (OnitamaPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Master(board, Color.RED), new Position(0,2));
		board.placePiece(new Disciple(board, Color.RED), new Position(0,0));
		board.placePiece(new Disciple(board, Color.RED), new Position(0,1));
		board.placePiece(new Disciple(board, Color.RED), new Position(0,3));
		board.placePiece(new Disciple(board, Color.RED), new Position(0,4));
		board.placePiece(new Master(board, Color.BLUE), new Position(4,2));
		board.placePiece(new Disciple(board, Color.BLUE), new Position(4,0));
		board.placePiece(new Disciple(board, Color.BLUE), new Position(4,1));
		board.placePiece(new Disciple(board, Color.BLUE), new Position(4,3));
		board.placePiece(new Disciple(board, Color.BLUE), new Position(4,4));
	}
}
