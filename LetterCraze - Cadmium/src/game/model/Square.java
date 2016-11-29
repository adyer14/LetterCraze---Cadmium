package game.model;

public class Square {
	
	int squareRow;
	int squareColumn;
	boolean squareInPlay;
	Tile tile;
	
	public Square (int row, int column, boolean valid, Tile tile) {
		this.squareRow = row;
		this.squareColumn = column;
		this.squareInPlay = valid;
		this.tile = tile;
	}
	
	public boolean containsTile (Tile tile) {
		return false;
	}
	
	public boolean removeTile () {
		return false;
	}
	
	public boolean isNeighbor (Square square) {
		return false;
	}

}
