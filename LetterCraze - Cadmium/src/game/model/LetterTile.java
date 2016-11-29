package game.model;

public class LetterTile extends Tile {
	
	String letter;
	int scoreValue;
	
	public LetterTile (String letter, int scoreValue) {
		this.letter = letter;
		this.scoreValue = scoreValue;
	}

}
