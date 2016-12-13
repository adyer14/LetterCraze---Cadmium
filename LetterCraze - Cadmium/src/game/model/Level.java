package game.model;

import java.util.*;

public abstract class Level {
	
	int i = 0;
	
	private Board board;
	protected int currentStars;
	protected int [] starValues = new int [3];
	protected int score;
	protected int highScore;
	private int mostStars;
	private int levelNumber;
	protected String levelType;
	private boolean isUnlocked;
	private Word currentWord;
	protected List<Word> wordList = new ArrayList<Word>();
	private Dictionary dictionary;
	
	public Level (int starVal [], Board board, int levelNumber) {
		this.board = board;
		this.levelNumber = levelNumber;

		for (int i = 0; i < 3; i++) {
			starValues [i] = starVal [i];
		}
	}
	
	abstract public boolean resetLevel();

	public boolean addWord (Word word) {
		return this.wordList.add(word);
	}
	
	public boolean removeWord () {
		Word word = wordList.get(wordList.size());
		wordList.remove(wordList.size());
		return !wordList.contains(word);
	}
	
	//rewrite this to be with currentWord in puzzle so it takes no parameters
	public abstract int addScore (Word word);
	
	public int removeScore (Word word) {
		this.score = this.score - word.calculateScore();
		return this.score;
	}
	
	public int checkStarProgress () {
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
	
	public abstract boolean repopulate (Board board);

	public String randomLetter () {
		Random rand = new Random();
		int n = rand.nextInt(100000) + 1;
		
		if (n >= 1 && n <= 8167) {
			return "A";
		}
		
		if (n >= 8168 && n <= 9659) {
			return "B";
		}
		
		if (n >= 9660 && n <= 12441) { 
			return "C";
		}
		
		if (n >= 12441 && n <= 16694) {
			return "D";
		}
		
		if (n >= 16695 && n <= 29396) {
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


	
	/**
	 * Get/Set methods up the a-hole
	 */
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	
	public int getCurrentStars() {
		return currentStars;
	}

	public void setCurrentStars(int currentStars) {
		this.currentStars = currentStars;
	}
	
	public int[] getStarValues() {
		return starValues;
	}

	public void setStarValues(int[] starValues) {
		this.starValues = starValues;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	public int getMostStars() {
		return mostStars;
	}

	public void setMostStars(int mostStars) {
		this.mostStars = mostStars;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public String getLevelType() {
		return levelType;
	}

	// This one method is abstract because the subclasses define their own level type
	abstract protected void setLevelType();
	
	public boolean getIsUnlocked() {
		return isUnlocked;
	}

	public void setIsUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
	
	public Word getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(Word currentWord) {
		this.currentWord = currentWord;
	}
	
	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	
	
	
}
	
	
