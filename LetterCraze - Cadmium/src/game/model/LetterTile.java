package game.model;

public class LetterTile extends Tile {
	
	private String letter;
	private int scoreValue;
	
	public LetterTile (String letter, int scoreValue) {
		this.letter = letter;
		this.scoreValue = scoreValue;
	}

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
