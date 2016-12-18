package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import junit.framework.TestCase;

public class TestThemeLevel extends TestCase {

	ThemeLevel level;

	protected void setUp() throws Exception {
		int[] starVal = {0,0,0};
		String sqsInPlay = "111111111111111111111111111111111111";
		List<Tile> tiles = null;
		Board board = new Board(null);
		int levNum = 1;
		String themeName = "Test";
		List<String> themeWordsInDic = new ArrayList<String>();
		themeWordsInDic.add("TEST");
		themeWordsInDic.add("THIS");
		themeWordsInDic.add("MOTHERFUCKER");
		ThemeDictionary themeWords = new ThemeDictionary(themeWordsInDic);
		level = new ThemeLevel(starVal, sqsInPlay, tiles, board, levNum, themeName, themeWords);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testThemeWordsPlacement() {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("AAAAA");
		wordList.add("BBBBB");
		wordList.add("CCCCC");
		wordList.add("DDDDD");
		wordList.add("EEEEE");
		
		assertEquals(level.themeWordsPlacement(wordList, new Board(null)), 1);
		
		level.setSqsInPlay("111111111111110011110011111111111111");
		assertEquals(level.themeWordsPlacement(wordList, new Board(null)), 1);
		
		wordList.add("FFFFFFF");
		assertEquals(level.themeWordsPlacement(wordList, new Board(null)), -1);
		
		wordList.add("HH");
		assertEquals(level.themeWordsPlacement(wordList, new Board(null)), -2);
		

	}

	public void testRandomlyPlaceFirstLetter() {
		Board b = new Board(level.generateThemeWordBoard());
		ArrayList<Square> unavailable = new ArrayList<Square>();
		Square sq = level.randomlyPlaceFirstLetter(b, "T", unavailable);

		// Test 1
		assertFalse (sq == null);

		// Test 2
		b = new Board(level.generateThemeWordBoard());
		int onlyAvailableSq = 7;
		for (int i = 0; i < 36; i++) {
			unavailable.add(b.getBoardSquares().get(i));
		}
		sq = level.randomlyPlaceFirstLetter(b, "S", unavailable);
		assertTrue (sq == null);
		for (int i = 0; i < 36; i++) {
			assertEquals (((LetterTile)b.getBoardSquares().get(i).getTile()).getLetter(), ".");
		}

		unavailable.remove(b.getBoardSquares().get(onlyAvailableSq));
		sq = level.randomlyPlaceFirstLetter(b, "S", unavailable);
		assertEquals(sq.getSquareColumn(),(onlyAvailableSq%6));
		assertEquals(sq.getSquareRow(),((onlyAvailableSq - (onlyAvailableSq%6)))/6);

		// Test 3
		unavailable.remove(b.getBoardSquares().get(onlyAvailableSq+1));
		b.getBoardSquares().get(onlyAvailableSq).setSquareInPlay(false);
		sq = level.randomlyPlaceFirstLetter(b, "B", unavailable);
		assertEquals(sq, b.getBoardSquares().get(onlyAvailableSq+1));

		// Test 4
		unavailable.remove(b.getBoardSquares().get(onlyAvailableSq+2));
		b.getBoardSquares().get(onlyAvailableSq+1).setTile(new BlankTile());
		sq = level.randomlyPlaceFirstLetter(b, "X", unavailable);
		assertEquals(sq, b.getBoardSquares().get(onlyAvailableSq+2));
	}

	public void testRandomlyPlacedLetter3() {
		Board b = new Board(level.generateThemeWordBoard());
		ArrayList<Square> unavailable = new ArrayList<Square>();
		Stack<Square> filledSquares = new Stack<Square>();
		String[] wordLetters = {"T", "E", "S", "T"};

		for (int i = 0; i < 36; i++) {
			unavailable.add(b.getBoardSquares().get(i));
		}
		unavailable.remove(b.getBoardSquares().get(1));
		unavailable.remove(b.getBoardSquares().get(2));
		unavailable.remove(b.getBoardSquares().get(3));
		unavailable.remove(b.getBoardSquares().get(5));
		Square first = level.randomlyPlaceFirstLetter(b, wordLetters[0], unavailable);
		Stack<Square> finalSquares = level.randomlyPlaceLetter(b, wordLetters, filledSquares, 0, first, unavailable);
		assertTrue(finalSquares == null);
	}
	public void testRandomlyPlaceLetter2() {
		Board b = new Board(level.generateThemeWordBoard());
		ArrayList<Square> unavailable = new ArrayList<Square>();
		Stack<Square> filledSquares = new Stack<Square>();
		String[] wordLetters = {"T", "E", "S", "T"};

		for (int i = 0; i < 36; i++) {
			unavailable.add(b.getBoardSquares().get(i));
		}
		unavailable.remove(b.getBoardSquares().get(1));
		unavailable.remove(b.getBoardSquares().get(2));
		unavailable.remove(b.getBoardSquares().get(3));
		unavailable.remove(b.getBoardSquares().get(4));
		unavailable.remove(b.getBoardSquares().get(7));
		unavailable.remove(b.getBoardSquares().get(13));
		Square first = level.randomlyPlaceFirstLetter(b, wordLetters[0], unavailable);
		Stack<Square> finalSquares = level.randomlyPlaceLetter(b, wordLetters, filledSquares, 0, first, unavailable);
		assertFalse(finalSquares.isEmpty());
		assertEquals(finalSquares.size(), wordLetters.length);
		for (int i = 1; i < wordLetters.length; i++) {
			assertTrue(finalSquares.pop().isNeighbor(finalSquares.peek()));
		}
	}
	public void testRandomlyPlaceLetter() {
		Board b = new Board(level.generateThemeWordBoard());
		ArrayList<Square> unavailable = new ArrayList<Square>();
		Stack<Square> filledSquares = new Stack<Square>();
		String[] wordLetters = {"T", "E", "S", "T"};

		// TEST 1
		Square first = level.randomlyPlaceFirstLetter(b, wordLetters[0], unavailable);
		Stack<Square> finalSquares = level.randomlyPlaceLetter(b, wordLetters, filledSquares, 0, first, unavailable);
		assertFalse(finalSquares.isEmpty());
		assertEquals(finalSquares.size(), wordLetters.length);
		for (int i = 1; i < wordLetters.length; i++) {
			assertTrue(finalSquares.pop().isNeighbor(finalSquares.peek()));
		}

	}

	public void testFindWordPlaceMent() {
		Board b = new Board(level.generateThemeWordBoard());
		ArrayList<Square> firstUnavailable = new ArrayList<Square>();
		String[] wordLetters = {"H","E","L","L","O"};
		for (int i = 0; i < 36; i++) {
			b.getBoardSquares().get(i).setSquareInPlay(false);
		}
		
		b.getBoardSquares().get(14).setSquareInPlay(true);
		b.getBoardSquares().get(15).setSquareInPlay(true);
		b.getBoardSquares().get(16).setSquareInPlay(true);
		b.getBoardSquares().get(17).setSquareInPlay(true);
		b.getBoardSquares().get(25).setSquareInPlay(true);
		b.getBoardSquares().get(26).setSquareInPlay(true);
		b.getBoardSquares().get(27).setSquareInPlay(true);
		Stack<Square> finalSquares = level.findWordPlacement(b, wordLetters, firstUnavailable);
		assertTrue(finalSquares == null);
		
		b.getBoardSquares().get(13).setSquareInPlay(true);
		finalSquares = level.findWordPlacement(b, wordLetters, firstUnavailable);
		assertFalse(finalSquares == null);
		assertEquals(finalSquares.size(), wordLetters.length);
	}
	
	public void testPlaceWordRecursion() {
		ArrayList<String> wordList = new ArrayList<String>();
		Board b = new Board(level.generateThemeWordBoard());
		
		wordList.add("TEST");
		wordList.add("HOMEWORK");
		wordList.add("FURRY");
		int sqsLeft = level.placeWordsRecursion(b, wordList, 0);
		if (sqsLeft != -1) {
			assertEquals(sqsLeft, 19);
		}
		
		wordList.add("AAAAAAAAAAAAAAAAAAAA");
		assertEquals(level.placeWordsRecursion(b, wordList, 0), -2);
		
	}
	
	public void printBoard(Board b) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int sqNum = (i*6)+j;
				Tile t = b.getBoardSquares().get(sqNum).getTile();
				if (t instanceof LetterTile)
					System.out.print(" " + ((LetterTile)t).getLetter());
				if (t instanceof BlankTile)
					System.out.print("-");
			}
			System.out.println("");
		}
	}
	public void printTiles() {
		System.out.println("\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int sqNum = (i*6)+j;
				Tile t = level.getTileLocations().get(sqNum);
				System.out.print(" " + ((LetterTile)t).getLetter());
			}
			System.out.println("");
		}
		//System.out.println("\n");
	}


}


