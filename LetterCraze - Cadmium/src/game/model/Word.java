package game.model;
public class Word {
	
	LetterTile selectedTiles [] = new LetterTile [36];
	String letters [] = new String [36];
	int wordScore;
	String actualWord;
	
	public Word (LetterTile wordTiles []) {
		this.selectedTiles = wordTiles;
	}
	
	public int numOfSTiles () {
		int count = 0;
		for (int i = 0; i < selectedTiles.length; i++) {
			if (selectedTiles [i] != null) {
				count++;
			}
		}
			return count;
	}
	
	public boolean isValidWord (Dictionary d) {
		return d.containsWord(this.actualWord);
	}
	
	public int calculateScore () {
		int score = 0;
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			score = score + selectedTiles[j].scoreValue;
		}
		score = score*(this.numOfSTiles()-2);
		return score;	
	}
	
	public String makeString () {
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			letters[j].concat(selectedTiles[j].getLetter());
		}
		this.actualWord = letters.toString();
		return this.actualWord;
	}
	
	public String getActualString() {
		return actualWord;
	}

}
