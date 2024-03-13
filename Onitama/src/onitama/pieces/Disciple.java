package onitama.pieces;

import boardgame.Board;
import boardgame.Position;
import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;

public class Disciple extends OnitamaPiece {

	public Disciple(Board board, Color color) {
		super(board, color);
	}
	
	private boolean canMove(Position position) {
		OnitamaPiece op = (OnitamaPiece)getBoard().piece(position);
		return op == null || op.getColor() != getColor();
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		switch(OnitamaCard.getCard()) {
		
		case BOAR:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				break;
				
			}
			
			
		  
		case COBRA:
		
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below-right
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			}
			
			
		case CRAB:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-left
				p.setValues(position.getRow(), position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-right
				p.setValues(position.getRow(), position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				break;
				
			}
			
		
		case CRANE:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
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
				
			} else {
				
				//above
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case DRAGON:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
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
				
			} else {
				
				//above-left-left
				p.setValues(position.getRow()+1, position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right-right
				p.setValues(position.getRow()+1, position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case EEL:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
		
		case ELEPHANT:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case FROG:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//left-left
				p.setValues(position.getRow(), position.getColumn()+2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case GOOSE:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case HORSE:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case MANTIS:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
				
			}
			
			
		case MONKEY:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above-left
				p.setValues(position.getRow()+1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-below
				p.setValues(position.getRow()-1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case OX:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
				
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
				
			} else {
				
				//above
				p.setValues(position.getRow()+1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case RABBIT:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right-right
				p.setValues(position.getRow(), position.getColumn()-2);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
			
		case ROOSTER:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above-right
				p.setValues(position.getRow()+1, position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//right
				p.setValues(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left-below
				p.setValues(position.getRow()-1, position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//left
				p.setValues(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
			
		
		case TIGER:
			
			if (OnitamaMatch.getCurrentPlayer() == Color.RED) {
			
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
				
			} else {
				
				//above-above
				p.setValues(position.getRow()+2, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//below
				p.setValues(position.getRow()-1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				break;
			}
		
		}
		
		return mat;
	}

}
