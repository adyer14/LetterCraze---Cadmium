package game.model;
import java.util.Timer;

import game.controller.EndLightningLevelController;

public class LightningLevel extends Level {
	
	boolean isOver;
	private int time;
	public Timer timer;
	int i = 0;

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

	public boolean addWord (Word word) {
		this.wordList[i] = word;
		i++;
		return true;
	}
	
	public boolean removeWord (Word word) {
		for (int j = 0; j < 20; j++) {
			if (word.equals(this.wordList[j])) {
				this.wordList[j] = this.wordList[j + 1];
				return true;
			}
		}
		return false;
	}
	
	public int addScore (Word word) {
		this.score = this.score + word.calculateScore();
		return this.score;
	}
	
	public int removeScore (Word word) {
		this.score = this.score - word.calculateScore();
		return this.score;
	}
	
	public int checkStarProgress (int score, int levelNumber) {
		this.score = score;
		if (this.score > this.highScore) {
			this.highScore = this.score;
		}
		if (this.score >= starValues[1] && this.score < starValues[2]) {
			this.currentStars = 1;
			return this.currentStars;
		}
		if (this.score >= starValues[2] && this.score < starValues[3]) {
			this.currentStars = 2;
			return this.currentStars;
		}
		if (this.score >= starValues[3]) {
			this.currentStars = 3;
			return this.currentStars;
		}
		else {
			return 0;
		}
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
