package game.model;

public class Square {
	
	private int squareRow;
	private int squareColumn;
	private boolean squareInPlay;
	private Tile tile;
	
	public Square (int row, int column, boolean valid, Tile tile) {
		this.squareRow = row;
		this.squareColumn = column;
		this.squareInPlay = valid;
		this.tile = tile;
	}
	
	public boolean containsTile (Tile tile) {
		if (this.squareInPlay) {
		
			if (tile == null) {
				return false;
			}
				
			else {
				return this.tile.equals(tile);
			}
		}
		else {
			return false;
		}
	}
	
	public boolean removeTile () {
		if (this.tile != null) {
			this.tile = null;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isNeighbor (Square square) {
		if (square.squareInPlay) {
			if ((this.squareColumn == square.squareColumn) ||
				(this.squareColumn + 1 == square.squareColumn) ||
				(this.squareColumn - 1 == square.squareColumn)) {
			if ((this.squareRow == square.squareRow) ||
				(this.squareRow + 1 == square.squareRow) ||
				(this.squareRow - 1 == square.squareRow)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
		else {
			return false;
		}
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile t) {
		this.tile = t;
	}

	public int getSquareColumn() {
		return squareColumn;
	}

	public boolean getSquareInPlay() {
		return squareInPlay;
	}

	public int getSquareRow() {
		return squareRow;
	}
}
