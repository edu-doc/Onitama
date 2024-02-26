package onitama;

import boardgame.Position;

public class OnitamaPosition {
	
	private int row;
	private char column;
	
	public OnitamaPosition(char column, int row) {
		if (column < 'a' || column > 'e' || row < 1 || row > 5) {
			throw new OnitamaException("Error instantiating OnitamaPosition");
		}
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}
	
	protected Position toPosition() {
		return new Position(5 - row, column - 'a');
	}
	
	protected static OnitamaPosition fromPosition (Position position) {
		return new OnitamaPosition((char)('a' - position.getColumn()), 5 - position.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
	}
	
	
	
	
	
	

}
