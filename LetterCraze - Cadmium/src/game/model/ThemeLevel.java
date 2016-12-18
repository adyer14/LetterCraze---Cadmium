package game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import game.undo.UndoManager;

public class ThemeLevel extends Level {

	ThemeDictionary themeWords;
	private String themeName;
	private int wordsLeft;
	private int initWordsLeft;
	int i = 0;
	ArrayList<Square> beingUsed = new ArrayList<Square>();
	ArrayList<Square> initBoardSquares = new ArrayList<Square>(36);
	List<Tile> initialTiles = new ArrayList<Tile>();
	HashMap<Integer, LetterTile> tileLocations = new HashMap<Integer, LetterTile>();
	private int timesTried = 0;

	public ThemeLevel(int[] starVal, String sqsInPlay, List<Tile> tiles, Board board, int levelNumber, String themeName, ThemeDictionary themeWords) {
		super(starVal, sqsInPlay, board, levelNumber);
		this.setThemeName(themeName);
		//this.initBoardSquares = board.getBoardSquares();
		this.themeWords = themeWords;
		this.wordsLeft = themeWords.words.size();
		this.initWordsLeft = themeWords.words.size();
		
		themeWordsPlacement(themeWords.getWords(), board);
		for (int i = 0; i < 36; i++){
			if (tileLocations.get(i).getLetter() == ".") 
				tileLocations.get(i).setLetter(((LetterTile)this.randomTile()).getLetter());
			this.initialTiles.add(tileLocations.get(i));
			this.board.getBoardSquares().get(i).setTile(tileLocations.get(i));
		}
		//this.initialTiles = tiles;

		//TODO HACK super hacks
		//themeWords.words.add("PIE");
		//themeWords.words.add("BURGER");
		//themeWords.words.add("PIZZA");
		setLevelType();		
		//wipeLevel();
		//findThemeWordPlacement();

	}

	@Override
	public boolean resetLevel() {
		this.wordsLeft = initWordsLeft;

		int row,col;
		for (int i=0;i<36;i++){
			row = (int) Math.floor(i/6);
			col = i%6;
			initBoardSquares.add(i, new Square(row,col,this.isSqInPlay(i),initialTiles.get(i)));
		}
		this.board.setBoardSquares(this.initBoardSquares);/*
		UndoManager mgr = UndoManager.instance();

		// see if there is anything that can be undone
		for(int k = 0; k < mgr.getUndoStack().size(); k++) {
			Move m = mgr.removeLastMove();
			if (m == null) { return false; }

			// now complete the request, if possible, and update GUI and model
			if (!m.undoMove()) {
				return false;
			}
		}*/


		return this.levelResetLevel();
	}

	@Override
	public int addScore(Word word) {
		this.wordsLeft--;
		return this.score = wordList.size();
	}

	@Override
	public int removeScore() {
		this.wordsLeft++;
		return this.score = wordList.size();
	}

	public void wipeLevel() {
		for (int n = 0; n < 36; n++) {
			this.board.boardSquares.get(n).removeTile();
		}
	}

	@Override
	public boolean repopulate(Board board) {
		for (int j = 0; j < 36; j++) {
			if (this.board.boardSquares.get(j).getSquareInPlay()) {
				if (this.board.boardSquares.get(j).getTile() == null) {
					this.board.boardSquares.get(j).setTile(new BlankTile());
				}
			}
		}
		return true;
	}

	@Override
	protected void setLevelType() {
		this.levelType = "theme";
	}

	/**
	 *  Begin Theme Word Placement Code
	 */
	
	public ArrayList<Square> generateThemeWordBoard() {
		ArrayList<Square> tempBoardSquares = new ArrayList<Square>();
		int row, col;
		
		for (int i = 0; i < 36; i++) {
			row = (int) Math.floor(i/6);
			col = i%6;
			tileLocations.put(i, new LetterTile(".", 0));
			tempBoardSquares.add(i, new Square(row, col, this.isSqInPlay(i), tileLocations.get(i)));
		}
		return tempBoardSquares;
	}
	
	public void resetThemeWordBoard(Board b) {
		for (int i = 0; i < 36; i ++) {
			tileLocations.get(i).setLetter(".");
			//Tile t = b.getBoardSquares().get(i).getTile(); 
			//if (t instanceof LetterTile) {
				//t).setLetter(".");
				//tileLocations.get(i).setLetter(".");
			//}
		}
	}
	
	public int themeWordsPlacement(List<String> wordList, Board tempBoard) {
		int numSqs = 0;
		int numLet = 0;
		tempBoard.setBoardSquares(generateThemeWordBoard());
		
		for (int i = 0; i < wordList.size(); i++) {
			numLet = numLet + wordList.get(i).length();
		}
		// if there are enough tiles, and tries have not run out
		numSqs = placeWordsRecursion(tempBoard, wordList, 0);
		if (numSqs == -2) {
			System.out.println("The given list of words has two many letters to be placed on the board");
			return -2;
		}
		if (numSqs == -1 && timesTried < 5) {
			timesTried++;
			return themeWordsPlacement(wordList, tempBoard);
		}
		if (timesTried == 5) {
			resetThemeWordBoard(tempBoard);
			System.out.println("Function ran 5 times before failing");
			return -1;
		}
		
		System.out.println("Function was run " + timesTried + " times before succeeding.");
		return 1;
	}

	public int placeWordsRecursion(Board b, List<String> wordList, int currentWord) {
		int numLet = 0;
		int numAvail = 0;
		for (int i = 0; i < wordList.size(); i++) {
			numLet = numLet + wordList.get(i).length();
		}
		// if the total number of letters is greater than the available squares
		for (int i = 0; i < 36; i++) {
			if (b.getBoardSquares().get(i).getSquareInPlay())
				numAvail++;
		}
		if (numLet > numAvail) {
			return -2;
		}
		
		ArrayList<Square> firstUnavailable = new ArrayList<Square>();
		String word = wordList.get(currentWord); 
		String[] wordLetters = new String[word.length()];
		int size = word.length();
		Stack<Square> filledSquares = findWordPlacement(b, wordLetters, firstUnavailable);
		
		for (int i = 0; i < size; i++) {
			wordLetters[i] = word.substring(i, i+1);
		}
		
		//try {
			// if the word could not be placed...
			if (filledSquares == null) {
				return -1;	
			}
			else {
			int row,col, sqNum;
			for (int i = 0; i < wordLetters.length; i++) {
				Square currentSquare = filledSquares.pop();
				row = currentSquare.getSquareRow();
				col = currentSquare.getSquareColumn();
				sqNum = (row*6) + col;

				((LetterTile)b.getBoardSquares().get(sqNum).getTile()).setLetter(wordLetters[wordLetters.length-1-i]);
				//System.out.println(((LetterTile)b.getBoardSquares().get(sqNum).getTile()).getLetter());
				currentSquare.removeTile();
			}
			b.floatTilesUp();

			if (currentWord < (wordList.size()-1)) {
				return placeWordsRecursion(b, wordList, (currentWord+1));
			}
			else {
				return calcNumTiles(b);
			}
			}
		//} //catch(Exception e) {
			//return -2;
		//}
	}
	
	public int calcNumTiles(Board b) {
		int numSqs = 0;
		for (int i = 0; i < 36; i++) {
			if (b.getBoardSquares().get(i).getTile() != null)
				numSqs++;
		}
		return numSqs;
	}

	public Stack<Square> findWordPlacement(Board b, String[] wordLetters, ArrayList<Square> firstUnavailable) {
		Square first = randomlyPlaceFirstLetter(b, wordLetters[0], firstUnavailable);
		if (first == null) {
			return null;
		}
		Stack<Square> filledSquares = new Stack<Square>();
		ArrayList<Square> unavailable = new ArrayList<Square>();
		Stack<Square> finalSquares = randomlyPlaceLetter(b, wordLetters, filledSquares, 0, first, unavailable);
		if (finalSquares == null) {
			firstUnavailable.add(first);
			return findWordPlacement(b, wordLetters, firstUnavailable);
		}
		else 
			return finalSquares;
	}

	public Square randomlyPlaceFirstLetter(Board b, String letter, ArrayList<Square> unavailable) {
		Random rand = new Random(); 
		int randVal = rand.nextInt(36);
		Square sq = b.getBoardSquares().get(randVal);
		ArrayList<Square> firstUnavailable = new ArrayList<Square>();
		if (!unavailable.isEmpty())
			firstUnavailable.addAll(unavailable);
		for (int i = 0; i < 36; i++) {
			if (sq.getSquareInPlay() && sq.getTile() instanceof LetterTile && !firstUnavailable.contains(sq)) {
				return sq;
			}
			// if you've reached this point, the current square is not available - add it to the 
			// firstUnavailable list, then set sq to the next sq
			firstUnavailable.add(sq);
			randVal++;
			if (randVal < 36)
				sq = b.getBoardSquares().get(randVal);
			else {
				randVal = 0;
				sq = b.getBoardSquares().get(randVal);
			}
		}

		// if you've reached this point, there are no available squares to place
		return null;

	}

	public Stack<Square> randomlyPlaceLetter(Board b, String[] word, Stack<Square> filledSquares, int currentLetter, Square sq, ArrayList<Square> unavailableSquares) {
		Random rand = new Random(); 

		int sqNum = sq.getSquareRow()*6 + sq.getSquareColumn();
		int[] neighVal = {-7, -6, -5, -1, 1, 5, 6, 7};
		ArrayList<Square> goodNeighbors = new ArrayList<Square>();

		for (int i = 0; i < neighVal.length; i++) {
			int neighSqNum = sqNum + neighVal[i];
			if (neighSqNum < 36 && neighSqNum >= 0) {
				Square neighSq = b.getBoardSquares().get(neighSqNum);
				if (neighSq.getSquareInPlay() && 
						neighSq.getTile() instanceof LetterTile && 
						!unavailableSquares.contains(neighSq) && 
						neighSq.isNeighbor(sq)) {
					goodNeighbors.add(neighSq);
				}
			}
		}

		// if I'm the last letter in the word, place myself and finish
		if (currentLetter == (word.length-1)) {
			filledSquares.push(sq);
			return filledSquares;
		}

		// if I'm not the last letter, but there are no available neighbors,
		// add myself to unavailable list, rerun on previous letter
		if (goodNeighbors.isEmpty() ) {
			if (!unavailableSquares.contains(sq))
				unavailableSquares.add(sq);
			if (filledSquares.isEmpty())
				return null;
			Square previousSquare = filledSquares.pop();
			return randomlyPlaceLetter(b, word, filledSquares, currentLetter-1, previousSquare, unavailableSquares);
		}

		// if I'm not the last letter and there are available neighbors,
		// place myself, add myself to unavailable list, run on next letter
		else {
			int randVal = rand.nextInt(goodNeighbors.size());
			Square nextSq = goodNeighbors.get(randVal);
			if (!unavailableSquares.contains(sq))
				unavailableSquares.add(sq);
			//((LetterTile)sq.getTile()).setLetter(word[currentLetter]);
			filledSquares.push(sq);
			return randomlyPlaceLetter(b, word, filledSquares, currentLetter+1, nextSq, unavailableSquares);

		}
	}

	/**
	 *  End Theme Word Placement Code
	 */



	/**
	 * Get/set methods
	 */
	public ThemeDictionary getThemeWords() {
		return themeWords;
	}

	public void setThemeWords(ThemeDictionary themeWords) {
		this.themeWords = themeWords;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public int getWordsLeft() {
		return wordsLeft;
	}

	public void setWordsLeft(int wordsLeft) {
		this.wordsLeft = wordsLeft;
	}

	public HashMap<Integer, LetterTile> getTileLocations(){
		return tileLocations;
	}
}
