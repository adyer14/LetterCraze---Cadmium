package game.model;
/**
 * This is the non-empty tile which has a letter and a score associated with it
 */
public class LetterTile extends Tile {
	
	private String letter;
	private int scoreValue;
	/**
	 * Constructor
	 * @param letter
	 * @param scoreValue
	 */
	public LetterTile (String letter, int scoreValue) {
		this.letter = letter;
		this.scoreValue = scoreValue;
	}
/**
 * 
 * get/set
 */
	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getScoreValue() {
		return scoreValue;
	}
	
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
}
