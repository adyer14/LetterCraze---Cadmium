package game.model;

public class PuzzleLevel extends Level {
	
	int movesRemaining;

	public PuzzleLevel(int[] starVal, Board board, int levelNumber) {
		super(starVal, board, levelNumber);
		// TODO Auto-generated constructor stub
	}

	
	public Level resetLevel () {
		return new Level (starValues, board, 1);
	}
	
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
	
}
