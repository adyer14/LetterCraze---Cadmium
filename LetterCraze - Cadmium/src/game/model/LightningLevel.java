package game.model;
import java.util.Timer;

import game.controller.EndLightningLevelController;

public class LightningLevel extends Level {
	
	boolean isOver;
	private int time;
	public Timer timer;

	public LightningLevel(int[] starVal, Board board, int levelNumber, int time) {
		super(starVal, board, levelNumber);
		this.time = time;
		setLevelType();
		Timer timer = new Timer();
		timer.schedule(new EndLightningLevelController(this), time);
	//	EndLightningLevelController llc = new EndLightningLevelController(this, null);
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	protected void setLevelType() {
		this.levelType = "lightning";
		
	}

	
	
}
