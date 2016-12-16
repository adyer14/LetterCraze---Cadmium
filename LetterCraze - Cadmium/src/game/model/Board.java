package game.model;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Board class takes care of the functionality that goes with the board in the game
 * 
 */
public class Board {
	
	ArrayList<Square> boardSquares = new ArrayList<Square>(36);
	ArrayList<Square> selectedSquares = new ArrayList<Square>();
	Word selectedWord;
	BlankTile blankTile;
	private static HashMap<String, Integer> letterScores = new HashMap<String, Integer>();
	/**
	 * Constructor
	 * @param squares
	 */
	public Board (ArrayList<Square> squares) {
		this.boardSquares = squares;
		assignLevelScores();
	}
	
	public void loadInBoard(String sqs) {
		int k = 0;
		int n = 0;
		for (int m = 0; m < 36; m++) {
			char sqsChar = sqs.charAt(m);
			if (sqsChar == '1') {
				this.boardSquares.get(m).setSquareInPlay(true);
			}
			if (sqsChar == '0') {
				this.boardSquares.get(m).setSquareInPlay(false);
			}
		}
		/*for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(sqs.substring(0,1).equals("0")){
					this.boardSquares.get(k).setSquareInPlay(false);
					k++;
					sqs = sqs.substring(1);
				}else{
					this.boardSquares.get(k).setSquareInPlay(true);
					k++;
					sqs = sqs.substring(1);
				}
			}
		}*/
	}
	
	/**
	 * This is the number of tiles selected
	 * @return count The number of selected tiles
	 */
	public int numOfSTiles () {
		int count = 0;
		if (selectedSquares == null) {
			return 0;
		}
		for (int i = 0; i < selectedSquares.size(); i++) {
			if (selectedSquares.get(i) != null) {
				count++;
			}
		}
			return count;
	}
	
	/**
	 * make sure two-letter words not permissable (are they in Theme?)
	 * @return int
	 */
	// TODO make sure two-letter words not permissable (are they in Theme?)
	public boolean isValidSelection () {
		int numOfAdj = 0;
		int count = this.numOfSTiles();
		for (int j = 0; j < (count - 1); j++) {
			if (selectedSquares.get(j).isNeighbor(selectedSquares.get(j + 1))) {
				numOfAdj++;
			}
		}
		return (numOfAdj == count - 1);
	}
	
	public boolean clearTiles () {
		int count = this.numOfSTiles();
		
		for (int k = 0; k < count; k++) {
			selectedSquares.get(k).removeTile();
		}
	return true;
}
	/**
	 * When a word is successfully removed from the board the remaining tiles must move upward into empty, active squares
	 * @return
	 */
	public boolean floatTilesUp () {
	
		Square current, nextWithLetter;
		boolean haveNotTaken;
		int numEmptyTiles = 0;
		for (int i = 0; i < 36; i++) {
			haveNotTaken = true;
			current = this.boardSquares.get(i);
			if (current.getSquareInPlay() && current.getTile() == null) {
				for (int j = 1; j <= (5-current.getSquareRow()); j++) {
					int k = i + (6*j);
					nextWithLetter = this.boardSquares.get(k);
					if (nextWithLetter.getSquareInPlay() && nextWithLetter.getTile() != null && haveNotTaken) {
						haveNotTaken = false;
						current.setTile(nextWithLetter.getTile());
						nextWithLetter.removeTile();
					}
					else
						numEmptyTiles++;
				}
			}
		}
		return (numEmptyTiles == selectedSquares.size());
	}
	/**
	 * Associates letters with tile scores
	 */
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
	
	public ArrayList<Square> getSelectedSquares() {
		return selectedSquares;
	}

	public void setSelectedSquares(ArrayList<Square> sSquares) {
		this.selectedSquares = sSquares;
	}
	
	public Word getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(Word selWord) {
		this.selectedWord = selWord;
	}
	
	public HashMap<String, Integer> getLetterScores() {
		return letterScores;
	}

	
}

