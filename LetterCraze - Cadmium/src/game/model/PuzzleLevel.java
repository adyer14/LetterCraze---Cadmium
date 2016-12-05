package game.model;

public class PuzzleLevel extends Level {
	
	private int movesLeft;

	public PuzzleLevel(int[] starVal, Board board, int levelNumber, int numMoves) {
		super(starVal, board, levelNumber);
		this.movesLeft = numMoves;
		setLevelType();
	}

	/*
	public Level resetLevel () {
		return new Level (starValues, board, 1);
	}*/
	
	public boolean undoMove (Board board) {
		return false;
	}

	public boolean addWord (Word word) {
		return false;
	}
	
	public boolean removeWord (Word word) {
		return false;
	}
	
	public int addScore (Word word) {
		return 0;
	}
	
	public int checkStarProgress (int score, int levelNumber) {
		return 0;
	}
	
	public boolean repopulate (Board board) {
		return false;
	}
	
	public int calculateScore () {
		return 0;
	}


	public int getMovesLeft() {
		return movesLeft;
	}


	public void setMovesLeft(int movesLeft) {
		this.movesLeft = movesLeft;
	}

	@Override
	protected void setLevelType() {
		this.levelType = "puzzle";
		
	}
	
}
