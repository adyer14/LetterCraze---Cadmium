package game.model;

import java.util.*;
/**
 * Level base class
 */
public abstract class Level {

	int i = 0;

	protected Board board;
	protected final Board initialBoard;
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
	private Dictionary dictionary = new Dictionary();
	ArrayList<Square> boardSquares = new ArrayList<Square>(36);
	ArrayList<Square> initBoardSquares = new ArrayList<Square>(36);
	private String sqsInPlay;

	/**
	 * Constructor
	 * @param starVal
	 * @param b
	 * @param initialTiles
	 * @param levelNumber
	 */
	public Level (int starVal [], String sqsInPlay, Board b, int levelNumber) {
		this.board = b;
		this.initialBoard = b;
		this.levelNumber = levelNumber;
		this.starValues = starVal;
		this.boardSquares = b.getBoardSquares();
		this.sqsInPlay = sqsInPlay;
		//for (int i = 0; i < 3; i++) {
		//starValues [i] = starVal [i];
		//}

	}

	// Abstract Methods
	abstract public boolean resetLevel();

	public abstract int addScore (Word word);

	public abstract int removeScore();

	public abstract boolean repopulate (Board board);

	// This one method is abstract because the subclasses define their own level type
	abstract protected void setLevelType();
	/**
	 * Reset Level
	 * @return boolean
	 */
	public boolean levelResetLevel() {
		this.wordList.clear();
		this.score = 0;
		this.currentStars = 0;
		if (wordList.isEmpty() && score == 0 && currentStars == 0)
			return true;
		else
			return false;
	}
	/**
	 * Add a word to the list of found words and change the score accordingly
	 * @param word
	 * @return boolean
	 */
	public boolean addWord (Word word) {
		boolean wordHasBeenAdded = this.wordList.add(word);
		this.addScore(word);
		return wordHasBeenAdded;
	}
	/**
	 * Remove a word from the list, useful with undo
	 * @return new word list
	 */
	public boolean removeWord () {
		if (wordList.isEmpty()) 
			return false;
		Word word = wordList.get(wordList.size()-1);
		if (this.levelType == "puzzle") {
			this.removeScore();
			wordList.remove(wordList.size()-1);
		}
		else {
			wordList.remove(wordList.size()-1);
			this.removeScore();
		}
		return !wordList.contains(word);
	}
	/**
	 * Keeps track of score and compares it to the requirements for stars
	 * @return Stars or 0
	 */
	public int checkStarProgress () {
		if (this.score > this.highScore) {
			this.highScore = this.score;
		}
		if (this.score >= starValues[0] && this.score < starValues[1]) {
			this.currentStars = 1;
		}
		else if (this.score >= starValues[1] && this.score < starValues[2]) {
			this.currentStars = 2;
		}
		else if (this.score >= starValues[2]) {
			this.currentStars = 3;
		}
		else {
			this.currentStars = 0;
		}

		if (this.currentStars > this.mostStars) {
			this.mostStars = this.currentStars;
		}
		return this.currentStars;
	}
	/**
	 * Creates a random tile
	 * @return Tile
	 */
	public Tile randomTile () {
		Random rand = new Random();
		int n = rand.nextInt(100000) + 1;

		if (n >= 1 && n <= 8167) {
			return new LetterTile ("A", 2);
		}

		if (n >= 8168 && n <= 9659) {
			return new LetterTile ("B", 4);
		}

		if (n >= 9660 && n <= 12441) { 
			return new LetterTile ("C", 3);
		}

		if (n >= 12441 && n <= 16694) {
			return new LetterTile ("D", 3);
		}

		if (n >= 16695 && n <= 29396) {
			return new LetterTile ("E", 1);
		}

		if (n >= 29397 && n <= 31624) {
			return new LetterTile ("F", 4);
		}

		if (n >= 31625 && n <= 33639) {
			return new LetterTile ("G", 4);
		}

		if (n >= 33640 && n <= 39733) {
			return new LetterTile ("H", 2);
		}

		if (n >= 39733 && n <= 46699) {
			return new LetterTile ("I", 2);
		}

		if (n >= 46700 && n <= 46852) {
			return new LetterTile ("J", 7);
		}

		if (n >= 46853 && n <= 47624) {
			return new LetterTile ("K", 5);
		}

		if (n >= 47625 && n <= 51649) {
			return new LetterTile ("L", 3);
		}

		if (n >= 51650 && n <= 54055) {
			return new LetterTile ("M", 3);
		}

		if (n >= 54056 && n <= 60804) {
			return new LetterTile ("N", 2);
		}

		if (n >= 60805 && n <= 68311) {
			return new LetterTile ("O", 2);
		}

		if (n >= 68312 && n <= 70240) {
			return new LetterTile ("P", 4);
		}

		if (n >= 70241 && n <= 70335) {
			return new LetterTile ("Qu", 8);
		}

		if (n >= 70336 && n <= 76322) {
			return new LetterTile ("R", 2);
		}

		if (n >= 76323 && n <= 82649) {
			return new LetterTile ("S", 2);
		}

		if (n >= 82649 && n <= 91705) {
			return new LetterTile ("T", 1);
		}

		if (n >= 91706 && n <= 94463) {
			return new LetterTile ("U", 3);
		}

		if (n >= 94464 && n <= 95441) {
			return new LetterTile ("V", 5);
		}

		if (n >= 95442 && n <= 97801) {
			return new LetterTile ("W", 3);
		}

		if (n >= 97802 && n <= 97951) {
			return new LetterTile ("X", 7);
		}

		if (n >= 97952 && n <= 99925) {
			return new LetterTile ("Y", 4);
		}

		if (n >= 99926 && n <= 100000) {
			return new LetterTile ("Z", 8);
		}

		else {
			return new BlankTile ();
		}
	}

	public boolean isSqInPlay(int index) {

		char sqsChar = sqsInPlay.charAt(index);
		if (sqsChar == '1') {
			return true;
		}
		else {  // (sqsChar == '0') {
			return false;
		}
	}

	/**
	 * Get/Set methods 
	 */
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board b) {
		this.board = b;
	}

	public Board getInitialBoard() {
		return initialBoard;
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

	public void setInitialBoardSquares (ArrayList<Square> s) {
		this.initBoardSquares = s;
	}

	public String getSqsInPlay() {
		return sqsInPlay;
	}
	public void setSqsInPlay(String inPlay) {
		this.sqsInPlay = inPlay;
	}
	/* End of Get/Set Methods */

}


