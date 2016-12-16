package game.model;
/**
 *A square is a container for a Tile which is either inactive or active
 */
public class Square {
	
	private int squareRow;
	private int squareColumn;
	private boolean squareInPlay;
	private Tile tile;
	/**
	 * Constructor
	 * @param row int
	 * @param column int
	 * @param valid boolean
	 * @param tile Tile
	 */
	public Square (int row, int column, boolean valid, Tile tile) {
		this.squareRow = row;
		this.squareColumn = column;
		this.squareInPlay = valid;
		this.tile = tile;
	}
	/**
	 * Checks if the Square contains a specific tile
	 * @param tile
	 * @return boolean
	 */
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
	/**
	 * Removes a tile from a square, useful when a word is selected
	 * @return boolean
	 */
	public boolean removeTile () {
		if (this.tile != null) {
			this.tile = null;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Checks to see if one square is adjacent to another one
	 * @param square
	 * @return boolean
	 */
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

	public void setSquareInPlay(boolean inPlay) {
		this.squareInPlay = inPlay;
	}
	
	public int getSquareRow() {
		return squareRow;
	}
}
