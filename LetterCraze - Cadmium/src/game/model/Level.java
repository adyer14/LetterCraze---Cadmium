package game.model;

import java.util.*;

import javax.swing.JButton;

public class Level {
	
	Board board;
	int stars;
	int maxStarsAcheived;
	int [] starValues = new int [3];
	int score;
	int highScore;
	int mostStars;
	int levelNumber;
	boolean isUnlocked;
	Word currentWord;
	Word [] wordList = new Word [20];
	Dictionary dictionary;
	HashMap<String, Integer> letterFrequencies = new HashMap<String, Integer>();
	
	public Level (int starVal [], Board board, int levelNumber) {
		this.board = board;
		this.levelNumber = levelNumber;
		
		for (int i = 0; i < 3; i++) {
			starValues [i] = starVal [i];
		}
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
	
}
