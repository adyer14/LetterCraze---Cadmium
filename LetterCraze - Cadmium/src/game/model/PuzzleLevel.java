package game.model;

import java.util.ArrayList;

public class PuzzleLevel extends Level {
	
	private int movesLeft;
	int i = 0;
	int lvlNumMoves;
	
	public PuzzleLevel(int[] starVal, Board board, ArrayList<Tile> initialTiles, int levelNumber, int numMoves) {
		super(starVal, board, initialTiles, levelNumber);
		this.movesLeft = numMoves;
		this.lvlNumMoves = numMoves;
		setLevelType();
	}
	
	//TODO create initialize function

	@Override
	public boolean resetLevel() {
		this.movesLeft = this.lvlNumMoves;
		int row,col;
		for (int i=0;i<36;i++){
			row = (int) Math.floor(i/6);
			col = i%6;
			initBoardSquares.add(i, new Square(row,col,true,this.randomTile()));//initialTiles.get(i)));
		}
		return this.levelResetLevel();
	}
	
	@Override
	public int addScore(Word word) {
		this.score = score + word.calculateScore();
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
