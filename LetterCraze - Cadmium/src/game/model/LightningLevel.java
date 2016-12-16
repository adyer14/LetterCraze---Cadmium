package game.model;
import java.util.ArrayList;
/**
 *Lightning Level extention of level has a timer and a few overrides
 */
public class LightningLevel extends Level {
	
	private boolean isOver;
	private int time;
	//public Timer timer;
	int i = 0;
/**
 * Constructor
 * @param starVal
 * @param board
 * @param initialTiles
 * @param levelNumber
 * @param time
 */
	public LightningLevel(int[] starVal, String sqsInPlay, Board board, int levelNumber, int time) {
		super(starVal, sqsInPlay, board, levelNumber);
		this.time = time;
		setLevelType();
		//Timer timer = new Timer();
		//timer.schedule(new EndLightningLevelController(this), time);
	//	EndLightningLevelController llc = new EndLightningLevelController(this, null);
	}
/**
 * Reset level does not reset time
 */
	@Override
	public boolean resetLevel () {
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
	public int addScore (Word word) { 
		this.score = wordList.size();
		return this.score;
	}
	
	@Override
	public int removeScore () {
		this.score = wordList.size();
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
