package game.model;

public class PuzzleLevel extends Level {
	
	private int movesLeft;
	int i = 0;
	
	public PuzzleLevel(int[] starVal, Board board, int levelNumber, int numMoves) {
		super(starVal, board, levelNumber);
		this.movesLeft = numMoves;
		setLevelType();
	}

	@Override
	public boolean resetLevel() {
		this.wordList.clear();
		this.score = 0;
		this.currentStars = 0;
		// TODO reset movesLeft - get movesLeft from level file and set it back
		// TODO reset board - get board from level file and set it to the board
		if (wordList.isEmpty() && score == 0 && currentStars == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int addScore(Word word) {
		// TODO rewrite to use currentWord
		this.score = score + word.calculateScore();
		return this.score;
	}

	@Override
	public boolean repopulate (Board board) {
		// TODO puzzle repopulate method
		return false;
	}

	@Override
	protected void setLevelType() {
		this.levelType = "puzzle";
	}
	
	
	public int getMovesLeft() {
		return this.movesLeft;
	}


	public int didMove() {
		return this.movesLeft - 1;
	}
	
	public int undidMove () {
		return this.movesLeft + 1;
	}

	

	
}
