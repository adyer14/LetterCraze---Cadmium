package builder.model;

public class Square {
	
	int sqRow;
	int sqColumn;
	boolean squareInPlay;
	Tile tile;
	
	public Square (int row, int column, boolean valid, Tile tile) {
		this.sqRow = row;
		this.sqColumn = column;
		this.squareInPlay = valid;
		this.tile = tile;
	}

	public void toggleInPlay() {
		if(squareInPlay) {
			squareInPlay = false;
		} else {
			squareInPlay = true;
		}
		
	}

	public boolean getSquareInPlay() {
		return squareInPlay;
	}

}
