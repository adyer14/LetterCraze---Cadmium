package game.model;

import java.util.ArrayList;
/**
 *A word is made up of the letter values collected from tiles on selected squares.
 *The letters are contained in an ArrayList to form word squares
 */
public class Word {
	
	private ArrayList<Square> selectedSquares = new ArrayList<Square>();
	private int wordScore;
	private String actualWord;
	/**
	 * Constructor
	 * @param wordSquares
	 */
	public Word (ArrayList<Square> wordSquares) {
		this.selectedSquares = wordSquares;
		this.actualWord = "";
	}
	/**
	 * Counts the number of tiles which have been selected
	 * @return count
	 */
	public int numOfSTiles () {
		int count = 0;
		for (int i = 0; i < selectedSquares.size(); i++) {
			if (selectedSquares.get(i) != null) {
				count++;
			}
		}
			return count;
	}
	
	public boolean isValidWord (Dictionary d) {
		return d.isWord(this.actualWord);
	}
	/**
	 * Calculates the score from the values associated with each selected tile
	 * @return score
	 */
	public int calculateScore () {
		int score = 0;
		int count = this.numOfSTiles();
		if (selectedSquares.get(0) == null) {
		System.out.println("hi");
		}
		for (int j = 0; j < count; j++) {
			score = score + ((LetterTile)selectedSquares.get(j).getTile()).getScoreValue();
		}
		score = score*(this.numOfSTiles()-2);
		return score;	
	}
	/**
	 * Creates a string from the letters
	 * @return
	 */
	public String makeString () {
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			actualWord = actualWord.concat(((LetterTile)selectedSquares.get(j).getTile()).getLetter());
		}
		return this.actualWord;
	}
	
	/**
	 * get/set
	 * 
	 */
	public String getActualString() {
		return actualWord;
	}
	
	public int getWordScore() {
		return wordScore;
	}
	
	public ArrayList<Square> getSelectedSquares() {
		return selectedSquares;
	}
	
	public void setSelectedSquares(ArrayList<Square> selectedSquares) {
		this.selectedSquares = selectedSquares;
	}
	
	

}
