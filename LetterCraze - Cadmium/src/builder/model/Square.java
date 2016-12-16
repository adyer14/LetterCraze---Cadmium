package builder.model;
/**
 * This is the square class
 * a Square is a container for a Tile. It can be set as active, allowing it to hold a tile
 * or inactive without a tile
 *
 */
public class Square {
	
	int sqRow;
	int sqColumn;
	boolean squareInPlay;
	Tile tile;
	/**
	 * Constructor for a Square
	 * @param row What row is it located in
	 * @param column What column is it located in
	 * @param valid or squareInPlay determines if it's available to hold a tile
	 * @param tile The tile on the Square
	 */
	public Square (int row, int column, boolean valid, Tile tile) {
		this.sqRow = row;
		this.sqColumn = column;
		this.squareInPlay = valid;
		this.tile = tile;
	}
    /**
     * Switches the state of the Square
     */
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
