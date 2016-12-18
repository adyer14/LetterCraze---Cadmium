package game.model;

import java.util.ArrayList;
/**
 * Move contains all the functionality of mones within a board
 */
public class Move {
	
	Word word;
	Level level;
	Board board;
	ArrayList<Tile> oldTiles = new ArrayList<Tile>();
	/**
	 * Constructor
	 * @param theWord Word
	 * @param theLevel Level
	 */
	public Move (Word theWord, Level theLevel) {
		this.word = theWord;
		this.level = theLevel;
		
		this.board = theLevel.getBoard();
 
		this.board.setSelectedSquares(word.getSelectedSquares());
		for (int i = 0; i < 36; i++) {
			oldTiles.add(board.getBoardSquares().get(i).getTile());
		}
	}
	/**
	 * executes the move
	 * @return boolean
	 */
	public boolean doMove () {
		
		if (this.isValid()) {
			
			int wordSize = this.word.getSelectedSquares().size();
			this.level.addWord(this.word);
			for (int i = 0; i < wordSize; i++) {
				this.word.getSelectedSquares().get(i).removeTile();
			}
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
	/**
	 * Undoes a move
	 * @return boolean
	 */
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
	/**
	 * checks if a move is valid
	 * @return boolean
	 */
	public boolean isValid () {
		if (this.board.isValidSelection()) {
			if (this.level.getLevelType().equalsIgnoreCase("theme")) {
				
				boolean b = ((ThemeLevel)this.level).themeWords.containsWord(this.word.getActualString());
				System.out.println("Theme is...." + b);
				return b;
			}
			if (this.level.getLevelType().equalsIgnoreCase("puzzle")) {
				if ((((PuzzleLevel)this.level).getMovesLeft() == 0) || (word.getSelectedSquares().size() < 3))
					return false;
			}
			if (this.word.isValidWord(this.level.getDictionary())) {
				return true;
			}
			return false;
		}
		return false;
	}
	/**
	 * Prints the board as it is
	 * @param b Board
	 */
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
	/**
	 * Counts selected tiles
	 * @param sSquares
	 * @return count
	 */
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
