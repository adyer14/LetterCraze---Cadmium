package game.model;
import java.util.Timer;


import game.controller.EndLightningLevelController;

public class LightningLevel extends Level {
	
	private boolean isOver;
	private int time;
	public Timer timer;
	int i = 0;
	Board lvlBoard;

	public LightningLevel(int[] starVal, Board board, int levelNumber, int time) {
		super(starVal, board, levelNumber);
		this.time = time;
		this.lvlBoard = board;
		setLevelType();
		Timer timer = new Timer();
		timer.schedule(new EndLightningLevelController(this), time);
	//	EndLightningLevelController llc = new EndLightningLevelController(this, null);
	}

	@Override
	public boolean resetLevel () {
		this.wordList.clear();
		this.score = 0;
		this.currentStars = 0;
		this.board = this.lvlBoard;
		if (wordList.isEmpty() && score == 0 && currentStars == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int addScore (Word word) {
		return this.score = wordList.size();
	}
	
	public int removeScore () {
		return this.score = wordList.size();
		
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
		this.levelType = "lightning";	
	}
	
	/**
	 * Get/set methods
	 */
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public boolean getIsOver() {
		return isOver;
	}
	
	public void setIsOver(boolean isOver) {
		this.isOver = isOver;
	}

	
	
}
