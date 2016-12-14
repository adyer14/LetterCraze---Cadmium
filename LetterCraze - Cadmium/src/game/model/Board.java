package game.model;

import java.util.HashMap;

public class Board {
	
	Square boardSquares [] = new Square [36];
	Square selectedSquares [] = new Square [36];
	Word selectedWord;
	BlankTile blankTile;
	private static HashMap<String, Integer> letterScores = new HashMap<String, Integer>();
	
	public Board () {
		int k = 0;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
			boardSquares [k] = new Square (i, j, true, blankTile);
			k++;
			}
		}
		assignLevelScores();
	}
	
	public int numOfSTiles () {
		int count = 0;
		for (int i = 0; i < 36; i++) {
			if (selectedSquares [i] != null) {
				count++;
			}
		}
			return count;
	}
	
	public boolean isValidSelection () {
		int numOfAdj = 0;
		int count = this.numOfSTiles();
		for (int j = 0; j < count - 1; j++) {
			if (selectedSquares [j].isNeighbor(selectedSquares[j + 1])) {
				numOfAdj++;
			}
		}
			return (numOfAdj == count - 1);
	}
	
	public boolean clearTiles () {
		int count = this.numOfSTiles();
		
		for (int k = 0; k < count; k++) {
			selectedSquares[k].removeTile();
		}
	return true;
}
	
	public boolean floatTilesUp () {
		for (int i = 0; i < 36; i++) {
			if (boardSquares[i].getSquareInPlay() && 
					boardSquares[i].getTile() == null) {
				for (int j = boardSquares[i].getSquareColumn(); j < 36; j++) {
					if (boardSquares[j].getSquareInPlay() &&
							boardSquares[j].getTile() == null &&
							boardSquares[j].getSquareColumn() == boardSquares[i].getSquareColumn()) {
						for (int k = (boardSquares[j].getSquareColumn() + 6*boardSquares[j].getSquareRow()); k < 36; k++) {
							if (boardSquares[k].getSquareInPlay() &&
									boardSquares[k].getTile() != null &&
									boardSquares[k].getSquareColumn() == boardSquares[j].getSquareColumn()) {
								boardSquares[j].setTile(boardSquares[k].getTile());
								boardSquares[k].removeTile();
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	private static void assignLevelScores() {
		String[] letters = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Integer[] scores = new Integer[]{2,  4,  3,  3,  1,  4,  4,  2,  2,  7,  5,  3,  3,  2,  2,  4,  8,  2,  2,  1,  3,  5,  3,  7,  4,  8};
		for(int i = 0; i < letters.length; i++){
	        letterScores.put(letters[i], scores[i]);
		}
	}
	
	public Square getSpecificBoardSquare(int index) {
		return boardSquares[index];
	}
	
	/**
	 * Get/set methods
	 */
	public Square[] getBoardSquares() {
		return boardSquares;
	}

	public void setBoardSquares(Square boardSquares[]) {
		this.boardSquares = boardSquares;
	}
	
	public HashMap<String, Integer> getLetterScores() {
		return letterScores;
	}

	
}

