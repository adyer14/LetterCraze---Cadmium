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
			this.squareInPlay = false;
			System.out.println("false");
		} else {
			this.squareInPlay = true;
			System.out.println("true");
		}
		
	}

	public boolean getSquareInPlay() {
		return squareInPlay;
	}

}
