package game.model;
import java.util.Timer;

public class LightningLevel extends Level {
	
	boolean isOver;
	private int time;
	Timer timer;

	public LightningLevel(int[] starVal, Board board, int levelNumber, int time) {
		super(starVal, board, levelNumber);
		this.time = time;
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
