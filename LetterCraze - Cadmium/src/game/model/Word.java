package game.model;
public class Word {
	
	LetterTile selectedTiles [] = new LetterTile [36];
	String letters [] = new String [36];
	int wordScore;
	String actualWord;
	
	public Word (LetterTile wordTiles []) {
		for (int i = 0; i < 35; i++) {
			selectedTiles [i] = wordTiles [i];
		}
	}
	
	public int numOfSTiles () {
		int count = 0;
		for (int i = 0; i < 36; i++) {
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
		return score;	
	}
	
	public String makeString () {
		int count = this.numOfSTiles();
		for (int j = 0; j < count; j++) {
			letters[j].concat(selectedTiles[j].letter);
		}
		this.actualWord = letters.toString();
		return this.actualWord;
	}

}
