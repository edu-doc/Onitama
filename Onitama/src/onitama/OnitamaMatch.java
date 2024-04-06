package onitama;

import myCollection.*;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import onitama.pieces.Disciple;
import onitama.pieces.Master;

public class OnitamaMatch {

	private int turn;
	private static Color currentPlayer;
	private Board board;
	
	private MyLinkedListSingle<Piece> piecesOnTheBoard = new MyLinkedListSingle<>();
	private MyLinkedListSingle<Piece> capturedPieces = new MyLinkedListSingle<>();
	
	public OnitamaMatch() {
		this.board = new Board(5,5);
		turn = 1;
		currentPlayer = Color.RED;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public static Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean[][] possibleMoves(OnitamaPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public OnitamaPiece perfomeOnitamaMove(OnitamaPosition sourcePosition, OnitamaPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (OnitamaPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece piece = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(piece, target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.transferNode(capturedPieces, capturedPiece);
		}
		
		return capturedPiece;
	}
	
	public void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new OnitamaException("There is no piece on source position");
		}
		if (currentPlayer != ((OnitamaPiece)board.piece(position)).getColor()) {
			throw new OnitamaException("The chosen piece is not yours");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new OnitamaException("There is no possible moves for the piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new OnitamaException("The chosen piece can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.RED) ? Color.BLUE : Color.RED;
	}
	
	public boolean onitamaMateKill() {
		for(Piece piece : capturedPieces) {
			if(piece.toString() == "M") {
				return true;
			}
		}
		return false;
	}
	
	private void placeNewPiece(char column, int row, OnitamaPiece piece){
		board.placePiece(piece, new OnitamaPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPiece('a',1, new Disciple(board, Color.RED));
		placeNewPiece('b',1, new Disciple(board, Color.RED));
		placeNewPiece('c',1, new Master(board, Color.RED));
		placeNewPiece('d',1, new Disciple(board, Color.RED));
		placeNewPiece('e',1, new Disciple(board, Color.RED));
		placeNewPiece('a',5, new Disciple(board, Color.BLUE));
		placeNewPiece('b',5, new Disciple(board, Color.BLUE));
		placeNewPiece('c',5, new Master(board, Color.BLUE));
		placeNewPiece('d',5, new Disciple(board, Color.BLUE));
		placeNewPiece('e',5, new Disciple(board, Color.BLUE));
	}
}
