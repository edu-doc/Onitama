package onitama.pieces;

import boardgame.Board;
import boardgame.Position;
import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaPiece;

public class Master extends OnitamaPiece {

	public Master(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "M";
	}
	
	private boolean canMove(Position position) {
		OnitamaPiece op = (OnitamaPiece)getBoard().piece(position);
		return op == null || op.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		switch(OnitamaCard.getCard()) {
		
			case BOAR:
				
				//above
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				break;
			  
			case COBRA:
			
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below-right
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				break;
				
			case CRAB:
				//above
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-left
				p.setValues(position.getRow(), position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-right
				p.setValues(position.getRow(), position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				break;
			
			case CRANE:
				
				//above
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case DRAGON:
				
				//above-left-left
				p.setValues(position.getRow()-1, position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right-right
				p.setValues(position.getRow()-1, position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case EEL:
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			
			case ELEPHANT:
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case FROG:
				
				//left-left
				p.setValues(position.getRow(), position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case GOOSE:
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case HORSE:
				
				//above
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case MANTIS:
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case MONKEY:
				
				//above-left
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case OX:
				
				//above
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case RABBIT:
				
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-right
				p.setValues(position.getRow(), position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			case ROOSTER:
				
				//above-right
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			
			case TIGER:
				
				//above-above
				p.setValues(position.getRow()-2, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
		}
		
		return mat;
	}
	
}
