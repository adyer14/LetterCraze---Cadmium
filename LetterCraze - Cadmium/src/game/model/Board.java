package game.model;

public class Board {
	
	Square boardSquares [] = new Square [36];
	LetterTile selectedTiles [] = new LetterTile [36];
	Word selectedWord;
	BlankTile blankTile;
	
	public Board () {
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			boardSquares [k] = new Square (i, j, true, blankTile);
			k++;
			}
		}
	}
	
	public boolean isValidSelection () {
		return false;
	}
	
	public boolean clearTiles () {
		//Already have letterTiles making up the word, run remove tile on each, doesn't need Word
		return false;
	}
	
	public boolean floatTilesUp () {
		return false;
	}

}
