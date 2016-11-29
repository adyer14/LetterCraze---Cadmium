package game.model;
public class Word {
	
	LetterTile selectedTiles [] = new LetterTile [36];
	int wordScore;
	String actualWord;
	
	public Word (LetterTile wordTiles []) {
		for (int i = 0; i < 35; i++) {
			selectedTiles [i] = wordTiles [i];
		}
	}
	
	public boolean isValidWord (Dictionary d) {
		return false;
	}
	
	public int calculateScore () {
		return 0;
	}
	
	public String makeString () {
		return "word";
	}

}
