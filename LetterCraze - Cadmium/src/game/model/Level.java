package game.model;

import java.util.*;

public abstract class Level {
	
	int i = 0;
	Board board;
	int currentStars;
	int [] starValues = new int [3];
	int score;
	int highScore;
	private int mostStars;
	private int levelNumber;
	protected String levelType;
	boolean isUnlocked;
	Word currentWord;
	Word [] wordList = new Word [20];
	private Dictionary dictionary;
	HashMap<String, Integer> letterFrequencies = new HashMap<String, Integer>();
	
	public Level (int starVal [], Board board, int levelNumber) {
		this.board = board;
		this.levelNumber = levelNumber;

		for (int i = 0; i < 3; i++) {
			starValues [i] = starVal [i];
		}
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

	public String getLevelType() {
		return levelType;
	}

	abstract protected void setLevelType();
	
	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public int getMostStars() {
		return mostStars;
	}

	public void setMostStars(int mostStars) {
		this.mostStars = mostStars;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	
	public String randomLetter () {
		Random rand = new Random();
		int n = rand.nextInt(100000) + 1;
		
		if (n >= 1 && n <= 8167) {
			return "A";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "B";
		}
		
		if (n >= 1 && n <= 8167) { // Fix val from here
			return "C";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "D";
		}
		
		if (n >= 1 && n <= 8167) {
			return "E";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "F";
		}
		
		if (n >= 1 && n <= 8167) {
			return "G";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "H";
		}
		
		if (n >= 1 && n <= 8167) {
			return "I";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "J";
		}
		
		if (n >= 1 && n <= 8167) {
			return "K";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "L";
		}
		
		if (n >= 1 && n <= 8167) {
			return "M";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "N";
		}
		
		if (n >= 1 && n <= 8167) {
			return "O";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "P";
		}
		
		if (n >= 1 && n <= 8167) {
			return "Qu";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "R";
		}
		
		if (n >= 1 && n <= 8167) {
			return "S";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "T";
		}
		
		if (n >= 1 && n <= 8167) {
			return "U";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "V";
		}
		
		if (n >= 1 && n <= 8167) {
			return "W";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "X";
		}
		
		if (n >= 1 && n <= 8167) {
			return "Y";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "Z";
		}
		
		else {
			return "I didn't work";
		}
	}
}
