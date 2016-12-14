package game.model;

import java.util.ArrayList;

public class Word {
	
	private ArrayList<Square> selectedSquares = new ArrayList<Square>();
	private int wordScore;
	private String actualWord;
	
	public Word (ArrayList<Square> wordSquares) {
		this.selectedSquares = wordSquares;
		this.actualWord = "";
	}
	
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
	
	public int calculateScore () {
		int score = 0;
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			score = score + ((LetterTile)selectedSquares.get(j).getTile()).getScoreValue();
		}
		score = score*(this.numOfSTiles()-2);
		return score;	
	}
	
	public String makeString () {
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			actualWord = actualWord.concat(((LetterTile)selectedSquares.get(j).getTile()).getLetter());
		}
		return this.actualWord;
	}
	
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
