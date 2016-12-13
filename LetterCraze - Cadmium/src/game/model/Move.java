package game.model;

public class Move {
	
	Square selectedSquares [] = new Square [36];
	Tile selectedTiles [] = new Tile [36];
	Word word;
	Level level;
	Board board;
	Dictionary d;
	
	Move (Square theSquares [], Word theWord, Level theLevel, Board theBoard, Dictionary dict) {
		this.word = theWord;
		this.level = theLevel;
		this.board = theBoard;
		this.d = dict;
		
		for (int i = 0; i < this.numOfSTiles(theSquares); i++) {
			this.selectedSquares[i] = theSquares [i];
			this.selectedTiles[i] = this.selectedSquares[i].tile;
		}
	}
	
	public boolean doMove () {
		if (this.isValid()) {
			for (int i = 0; i < this.numOfSTiles(selectedSquares); i++) {
				this.selectedSquares[i].removeTile();
			}
				this.level.addWord(this.word);
				this.level.checkStarProgress();
				if (this.level.getLevelType().equalsIgnoreCase("puzzle")) {
					((PuzzleLevel) this.level).didMove();
				}
				return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean undoMove () {
		if (this.level.getLevelType().equalsIgnoreCase("puzzle")) {
			((PuzzleLevel) this.level).undidMove();
		}
		this.level.removeWord();
		this.level.checkStarProgress();
		for (int i = 0; i < this.numOfSTiles(selectedSquares); i++) {
			this.selectedSquares[i].tile = this.selectedTiles[i];
		}
		return true;
	} 
	
	public boolean isValid () {
		if (this.board.isValidSelection()) {
			if (this.level.getLevelType().equalsIgnoreCase("theme")) {
				return ((ThemeLevel)this.level).themeWords.containsWord(this.word.getActualString());
			}
			if (this.word.isValidWord(this.d)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public int numOfSTiles (Square sSquares []) {
		int count = 0;
		for (int i = 0; i < 36; i++) {
			if (sSquares [i] != null) {
				count++;
			}
		}
			return count;
	}

}
