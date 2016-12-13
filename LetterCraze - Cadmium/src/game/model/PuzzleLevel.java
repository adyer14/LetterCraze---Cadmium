package game.model;

public class PuzzleLevel extends Level {
	
	private int movesLeft;
	int i = 0;
	int lvlNumMoves;
	Board lvlBoard;
	
	public PuzzleLevel(int[] starVal, Board board, int levelNumber, int numMoves) {
		super(starVal, board, levelNumber);
		this.movesLeft = numMoves;
		this.lvlNumMoves = numMoves;
		this.lvlBoard = board;
		setLevelType();
	}
	
	//TODO create initialize function

	@Override
	public boolean resetLevel() {
		this.wordList.clear();
		this.score = 0;
		this.currentStars = 0;
		this.movesLeft = this.lvlNumMoves;
		this.board = this.lvlBoard;
		if (wordList.isEmpty() && score == 0 && currentStars == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int addScore(Word word) {
		this.score = score + word.calculateScore();
		return this.score;
	}

	@Override
	public boolean repopulate (Board board) {
		for (int j = 0; j < 36; j++) {
			if (this.board.boardSquares[j].squareInPlay) {
				if (this.board.boardSquares[j].tile == null) {
					this.board.boardSquares[j].setTile(this.randomLetter());
					return true;
				}
			}
		}
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
