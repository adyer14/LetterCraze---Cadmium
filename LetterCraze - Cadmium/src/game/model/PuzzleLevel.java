package game.model;

/**
 *The Puzzle version of the Level class
 */
public class PuzzleLevel extends Level {
	
	private int movesLeft;
	int i = 0;
	int lvlNumMoves;
	/**
	 * Constructor
	 * @param starVal int[]
	 * @param board Board
	 * @param initialTiles ArrayList<Tile>
	 * @param levelNumber int
	 * @param numMoves int
	 */
	public PuzzleLevel(int[] starVal, String sqsInPlay, Board board, int levelNumber, int numMoves) {
		super(starVal, sqsInPlay, board, levelNumber);
		this.movesLeft = numMoves;
		this.lvlNumMoves = numMoves;
		setLevelType();
	}
	
	//TODO create initialize function
	/**
	 * Provides a new level
	 */
	@Override
	public boolean resetLevel() {
		this.movesLeft = this.lvlNumMoves;
		int row,col;
		for (int i=0;i<36;i++){
			row = (int) Math.floor(i/6);
			col = i%6;
			initBoardSquares.add(i, new Square(row,col,this.isSqInPlay(i),this.randomTile()));//initialTiles.get(i)));
		}
		this.board.setBoardSquares(this.initBoardSquares);
		return this.levelResetLevel();
	}
	
	@Override
	public int addScore(Word word) {
		this.score += word.calculateScore();
		return this.score;
	}

	@Override
	public int removeScore () {
		if (wordList.isEmpty()) 
			return this.score;
		Word word = this.getWordList().get(getWordList().size()-1);
		this.score = this.score - word.calculateScore();
		return this.score;
	}
	
	@Override
	public boolean repopulate (Board board) {
		for (int j = 0; j < 36; j++) {
			if (this.board.boardSquares.get(j).getSquareInPlay()) {
				if (this.board.boardSquares.get(j).getTile() == null) {
					this.board.boardSquares.get(j).setTile(this.randomTile());
				}
			}
		}
		return true;
	}

	public int didMove() {
		this.movesLeft = this.movesLeft - 1;
		return this.movesLeft;
	}
	
	public int undidMove () {
		this.movesLeft = this.movesLeft + 1;
		return this.movesLeft;
	}
/**
 * get/set
 */
	@Override
	protected void setLevelType() {
		this.levelType = "puzzle";
	}
	
	public int getMovesLeft() {
		return this.movesLeft;
	}

	
}
