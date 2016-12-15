package game.model;

import java.util.ArrayList;

public class Move {
	
	Word word;
	Level level;
	Board board;
	ArrayList<Tile> oldTiles = new ArrayList<Tile>();
	
	public Move (Word theWord, Level theLevel) {
		this.word = theWord;
		this.level = theLevel;
		
		this.board = theLevel.getBoard();

		this.board.setSelectedSquares(word.getSelectedSquares());
		for (int i = 0; i < 36; i++) {
			oldTiles.add(board.getBoardSquares().get(i).getTile());
		}
	}
	
	public boolean doMove () {
		
		if (this.isValid()) {
			
			int wordSize = this.word.getSelectedSquares().size();
			for (int i = 0; i < wordSize; i++) {
				this.word.getSelectedSquares().get(i).removeTile();
			}
			this.level.addWord(this.word);
			this.level.checkStarProgress();
			this.board.floatTilesUp();
			this.level.repopulate(board);
			this.level.setBoard(board);
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
		for (int i = 0; i < 36; i++) {
			board.getBoardSquares().get(i).setTile(oldTiles.get(i));
		}
		this.level.setBoard(this.board);
		return true;
	} 
	
	public boolean isValid () {
		if (this.board.isValidSelection()) {
			if (this.level.getLevelType().equalsIgnoreCase("theme")) {
				return ((ThemeLevel)this.level).themeWords.containsWord(this.word.getActualString());
			}
			if (this.word.isValidWord(this.level.getDictionary())) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void printBoard(Board b ) {
		System.out.print(b.toString());
		int isLetter = 0;
		for (int i = 0; i < 36; i++) {
			if (b.getBoardSquares().get(i).getTile() instanceof LetterTile) 
				isLetter = 1;
			else
				isLetter = 0;
			System.out.print(" " + isLetter);
		}
		System.out.println("");
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
