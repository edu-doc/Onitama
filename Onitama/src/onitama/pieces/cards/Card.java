package onitama.pieces.cards;

import boardgame.Board;
import boardgame.Position;
import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;

public class Card {
	
	private static boolean canMove(Position position, Board board, Color color) {
		OnitamaPiece op = (OnitamaPiece)board.piece(position);
		return op == null || op.getColor() != color;
	}
	
	public static boolean[][] possibleMoves(Board board, Color color, Position position) {
		
		boolean[][] mat = new boolean[board.getRows()][board.getColumns()];
		
		Position p = new Position(0,0);
	
		byte multi;
		
		if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			multi = 1;
		} else {
			multi = -1;
		}
		
		switch(OnitamaCard.getCard()) {
		
			case BOAR:
				
				
					//above
					p.setValues(position.getRow()-1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					break;
					
				
				
			  
			case COBRA:
					
					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//below-right
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					break;
				
			case CRAB:
				
					//above
					p.setValues(position.getRow()-1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-left
					p.setValues(position.getRow(), position.getColumn()-2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-right
					p.setValues(position.getRow(), position.getColumn()+2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					break;
					
			case CRANE:
				
					//above
					p.setValues(position.getRow()-1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-below
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;			
				
			case DRAGON:
				
					//above-left-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//above-right-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-below
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
				
			case EEL:
				
					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
					
			case ELEPHANT:
			
					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;

			case FROG:

					//left-left
					p.setValues(position.getRow(), position.getColumn()-2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
					
			case GOOSE:
				
					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-below
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;

			case HORSE:

					//above
					p.setValues(position.getRow()-1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//below
					p.setValues(position.getRow()+1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
				
			case MANTIS:

					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//below
					p.setValues(position.getRow()+1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;

			case MONKEY:
			
					//above-left
					p.setValues(position.getRow()-1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-below
					p.setValues(position.getRow()+1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
					
			case OX:
				
					//above
					p.setValues(position.getRow()-1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//below
					p.setValues(position.getRow()+1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
					
			case RABBIT:
				
					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right-right
					p.setValues(position.getRow(), position.getColumn()+2*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;

			case ROOSTER:

					//above-right
					p.setValues(position.getRow()-1*multi, position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//right
					p.setValues(position.getRow(), position.getColumn()+1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left-below
					p.setValues(position.getRow()+1*multi, position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//left
					p.setValues(position.getRow(), position.getColumn()-1*multi);
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;
			
			case TIGER:
				
					//above-above
					p.setValues(position.getRow()-2*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					//below
					p.setValues(position.getRow()+1*multi, position.getColumn());
					if(board.positionExists(p) && canMove(p, board, color)) {
						mat[p.getRow()][p.getColumn()] = true;
					}
					
					break;

			}
		return mat;
	}
}
