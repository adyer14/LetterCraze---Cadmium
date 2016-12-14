package game.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	
	ArrayList<Square> boardSquares = new ArrayList<Square>();
	Square selectedSquares [] = new Square [36];
	Word selectedWord;
	BlankTile blankTile;
	private static HashMap<String, Integer> letterScores = new HashMap<String, Integer>();
	
	public Board (ArrayList<Square> squares) {
		this.boardSquares = squares;
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
	
	public Board floatTilesUp () {
		for (int i = 0; i < 36; i++) {
			if (this.boardSquares.get(i).getSquareInPlay() && 
					this.boardSquares.get(i).getTile() == null) {
				for (int j = this.boardSquares.get(i).getSquareColumn(); j < 36; j++) {
					if (this.boardSquares.get(j).getSquareInPlay() &&
							this.boardSquares.get(j).getTile() == null &&
							this.boardSquares.get(j).getSquareColumn() == this.boardSquares.get(j).getSquareColumn()) {
						for (int k = (this.boardSquares.get(j).getSquareColumn() + 6*this.boardSquares.get(j).getSquareRow()); k < 36; k++) {
							if (this.boardSquares.get(k).getSquareInPlay() &&
									this.boardSquares.get(k).getTile() != null &&
									this.boardSquares.get(k).getSquareColumn() == this.boardSquares.get(j).getSquareColumn()) {
								this.boardSquares.get(j).setTile(this.boardSquares.get(k).getTile());
								this.boardSquares.get(k).removeTile();
							}
						}
					}
				}
			}
		}
		return new Board (this.boardSquares);
	}
	
	private static void assignLevelScores() {
		String[] letters = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Integer[] scores = new Integer[]{2,  4,  3,  3,  1,  4,  4,  2,  2,  7,  5,  3,  3,  2,  2,  4,  8,  2,  2,  1,  3,  5,  3,  7,  4,  8};
		for(int i = 0; i < letters.length; i++){
	        letterScores.put(letters[i], scores[i]);
		}
	}
	
	/**
	 * Get/set methods
	 */
	public ArrayList<Square> getBoardSquares() {
		return boardSquares;
	}

	public void setBoardSquares(ArrayList<Square> bSquares) {
		this.boardSquares = bSquares;
	}
	
	public HashMap<String, Integer> getLetterScores() {
		return letterScores;
	}

	
}

