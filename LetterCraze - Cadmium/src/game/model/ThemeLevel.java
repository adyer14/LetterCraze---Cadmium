package game.model;

import java.util.ArrayList;
import java.util.Random;

public class ThemeLevel extends Level {

	ThemeDictionary themeWords;
	private String themeName;
	private int wordsLeft;
	int i = 0;
	ArrayList<Square> beingUsed = new ArrayList<Square>();
	
	public ThemeLevel(int[] starVal, Board board, ArrayList<Tile> initialTiles, int levelNumber, String themeName, ThemeDictionary themeWords) {
		super(starVal, board, initialTiles, levelNumber);
		this.setThemeName(themeName);
		this.themeWords = themeWords;
		//TODO HACK super hacks
		themeWords.words.add("NOON");
		themeWords.words.add("TEN");
		themeWords.words.add("TED");
		themeWords.words.add("EA");
		themeWords.words.add("EO");
		setLevelType();
	}
	
	@Override
	public boolean resetLevel() {
		return this.levelResetLevel();
	}

	@Override
	public int addScore(Word word) {
		return this.score = wordList.size();
	}

	@Override
	public int removeScore() {
		return this.score = wordList.size();
	}
	
	@Override
	public boolean repopulate(Board board) {
		for (int j = 0; j < 36; j++) {
			if (this.board.boardSquares.get(j).getSquareInPlay()) {
				if (this.board.boardSquares.get(j).getTile() == null) {
					this.board.boardSquares.get(j).setTile(new BlankTile());
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	protected void setLevelType() {
		this.levelType = "theme";
	}
	

	public void findThemeWordPlacement (Square sqr) {
		int numOfWords = this.themeWords.words.size();
		ArrayList<ArrayList<String>> listOfThemeWordLetters = new ArrayList<ArrayList<String>>();
		for (int p = 0; p < numOfWords; p++) {
			listOfThemeWordLetters.add(parseThemeWords(this.themeWords.words.get(p)));
		}
		for (int p = 0; p < listOfThemeWordLetters.size(); p++) {
			boolean foundSequence = false;
			Random rand = new Random();
			int n;
			while (!foundSequence) {
				n = rand.nextInt(36);
				if (recursionAlgorithm(this.beingUsed, listOfThemeWordLetters.get(p).size(), this.initBoardSquares.get(n))) {
					foundSequence = true;
			} else {
				foundSequence = false;
			}
			}
		}
		for (int p = 0; p < numOfWords; p++) {
			for (int q = 0; q < listOfThemeWordLetters.get(p).size(); q++) {
				int r = 0;
				int index = this.initBoardSquares.indexOf(this.beingUsed.get(r));
				String letter = listOfThemeWordLetters.get(p).get(q);
				this.initBoardSquares.get(index).setTile(new LetterTile(letter, this.board.getLetterScores().get(letter)));
			}
		}

			for (int j = 0; j < 36; j++) {
				if (this.board.boardSquares.get(j).getSquareInPlay()) {
					if (this.board.boardSquares.get(j).getTile() instanceof BlankTile) {
						this.board.boardSquares.get(j).setTile(this.randomTile());
					}
				}
			}
		}

	
	public boolean recursionAlgorithm (ArrayList<Square> beingUsed, int numOfLetters, Square s) {
		numOfLetters --;
		beingUsed.add(s);
		int squareNum = ((6*s.getSquareColumn()) + s.getSquareRow());
		int neighbors [] = {-6, -5, 1, 7, 6, 5, -1, -7};
		
		if (numOfLetters == 0 && checkValidStart(s, beingUsed)) {
			return true;
		}
		if (!checkValidStart(s, beingUsed)) {
			numOfLetters++;
			beingUsed.remove(beingUsed.size() - 1);
			return false;
		}
		boolean foundPath = false;
		
		if (numOfLetters != 0 && squareNum == 0) {
			for (int m = 2; m < 5; m++) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && squareNum == 5) {
			for (int m = 4; m < 7; m++) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && squareNum == 35) {
			for (int m = 0; m < 8; m++) {
				if (m == 6 || m == 7 || m == 0) {
					if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
						foundPath = true;
						break;
					} else {
						foundPath = false;
					}
				}
				} if (foundPath) {
					return true;
				} else {
					numOfLetters++;
					beingUsed.remove(beingUsed.size() - 1);
					return false;
				}
			}

		
		if (numOfLetters != 0 && squareNum == 30) {
			for (int m = 0; m < 3; m++) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && (s.getSquareColumn() == 0) && (squareNum != 0 && squareNum != 30)) {
			for (int m = 0; m < 5; m++) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && (s.getSquareColumn() == 5) && (squareNum != 5 && squareNum != 35)) {
			for (int m = 0; m < 8; m++) {
				if (m == 0 || m >= 4) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && (s.getSquareRow() == 0) && (squareNum != 0 && squareNum != 5)) {
			for (int m = 2; m < 7; m++) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && (s.getSquareRow() == 5) && (squareNum != 30 && squareNum != 35)) {
			for (int m = 0; m < 8; m++) {
				if (m <= 2 || m >= 6) {
				if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
					foundPath = true;
					break;
				} else {
					foundPath = false;
				}
				}
			} if (foundPath) {
				return true;
			} else {
				numOfLetters++;
				beingUsed.remove(beingUsed.size() - 1);
				return false;
			}
			}
		
		if (numOfLetters != 0 && s.getSquareRow() != 0 && s.getSquareColumn() !=0) {
		for (int m = 0; m < 8; m++) {
			if (checkValidStart(s, beingUsed) && recursionAlgorithm(beingUsed, numOfLetters, this.initBoardSquares.get(squareNum + neighbors[m]))) {
				foundPath = true;
				break;
			} else {
				foundPath = false;
			}
		} if (foundPath) {
			return true;
		} else {
			numOfLetters++;
			beingUsed.remove(beingUsed.size() - 1);
			return false;
		}
		}
		
		else {
			return false;
		}
	}		
	
	public ArrayList<String> parseThemeWords (String string) {
		ArrayList<String> wordLetters = new ArrayList<String>();
		for (int j = 0; j < string.length(); j++) {
			 wordLetters.add(Character.toString(string.charAt(j)));
		}
		return wordLetters;
	}
	
	public boolean checkValidStart(Square sqr, ArrayList<Square> currentValid) {
		int instances = 0;
		if (sqr.getSquareInPlay()) {
			for (int k = 0; k < currentValid.size(); k++) {
				if(currentValid.get(k).equals(sqr)) {
					instances++;
				}
			}
			if (instances > 1) {
				return false;
			}
			else return true;
		}
		else return false;
	}
	

	
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
	
}
