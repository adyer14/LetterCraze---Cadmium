package game.model;

public class Move {
	
	Square selectedSquares [] = new Square [36];
	Tile selectedTiles [] = new Tile [36];
	Word word;
	Level level;
	Board board;
	
	Move (Square theSquares [], Word theWord, Level theLevel, Board theBoard) {
		this.word = theWord;
		this.level = theLevel;
		this.board = theBoard;
		
		for (int i = 0; i < 36; i++) {
			this.selectedSquares[i] = theSquares [i];
			this.selectedTiles[i] = this.selectedSquares[i].tile;
		}
	}
	
	public boolean doMove () {
		if (this.isValid()) {
			for (int i = 0; i < 36; i++) {
				this.selectedSquares[i].removeTile();
			}
				this.level.addScore(this.word);
				this.level.addWord(this.word);
				this.level.checkStarProgress(this.level.score, this.level.getLevelNumber());
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
		this.level.removeScore(this.word);
		this.level.removeWord(this.word);
		this.level.checkStarProgress(this.level.score, this.level.getLevelNumber());
		for (int i = 0; i < 36; i++) {
			this.selectedSquares[i].tile = this.selectedTiles[i];
		}
		return true;
	} 
	
	public boolean isValid () {
		return false;
	}

}
