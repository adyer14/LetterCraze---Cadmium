package game.model;

import junit.framework.TestCase;

public class TestPuzzleLevel extends TestCase {

	PuzzleLevel lvl;
	Word w1;
	Word w2;
	Word w3;
	LetterTile A;
	LetterTile C;
	LetterTile E;
	LetterTile F;
	LetterTile H;
	LetterTile K;
	LetterTile O;
	LetterTile R;
	LetterTile T;
	LetterTile U;
	LetterTile W;
	LetterTile Y;
	
	protected void setUp() {
		int starVal[] = {10, 20, 30};
		Board b = new Board();
		int levNum = 2;
		int numMoves = 15;
		lvl = new PuzzleLevel(starVal, b, levNum, numMoves);
	
		A = new LetterTile("A", b.getLetterScores().get("A"));
		C = new LetterTile("C", b.getLetterScores().get("C"));
		E = new LetterTile("E", b.getLetterScores().get("E"));
		F = new LetterTile("F", b.getLetterScores().get("F"));
		H = new LetterTile("H", b.getLetterScores().get("H"));
		K = new LetterTile("K", b.getLetterScores().get("K"));
		O = new LetterTile("O", b.getLetterScores().get("O"));
		R = new LetterTile("R", b.getLetterScores().get("R"));
		T = new LetterTile("T", b.getLetterScores().get("T"));
		U = new LetterTile("U", b.getLetterScores().get("U"));
		W = new LetterTile("W", b.getLetterScores().get("W"));
		Y = new LetterTile("Y", b.getLetterScores().get("Y"));
		
		LetterTile[] fucktruck = {F,U,C,K,T,R,U,C,K};
		w1 = new Word(fucktruck);
		LetterTile[] fuck = {F,U,C,K};
		w2 = new Word(fuck);
		LetterTile[] you = {Y,O,U};
		w3 = new Word(you);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddWord() {
		assertTrue (lvl.getWordList().isEmpty());
		
		boolean didIGetAdded = lvl.addWord(w1);
		
		assertTrue (didIGetAdded);
		assertTrue (lvl.getWordList().size() == 1);
		assertTrue (lvl.getWordList().contains(w1));
	}
	
	public void testRemoveWord() {
		boolean removed = lvl.removeWord();
		assertFalse(removed);
		
		lvl.addWord(w1);
		lvl.addWord(w2);
		removed = lvl.removeWord();
		assertTrue(removed);
		assertTrue (lvl.getWordList().size() == 1);
		assertTrue (lvl.getWordList().contains(w1));
	
		removed = lvl.removeWord();
		assertTrue(removed);
		assertTrue(lvl.getWordList().isEmpty());
	}
	
	public void testAddScore() {
		lvl.addScore(w1);
		assertEquals (lvl.getScore(), w1.calculateScore());
		lvl.addScore(w2);
		assertEquals (lvl.getScore(), (w1.calculateScore()+w2.calculateScore()));
	}
	
	public void testRemoveScore() {
		int score = lvl.removeScore();
		assertEquals(score,0);
		
		lvl.addScore(w1);
		lvl.addWord(w1);
		lvl.addScore(w2);
		lvl.addWord(w2);
		score = lvl.removeScore();
		lvl.removeWord();
		assertEquals (score, w1.calculateScore());
		
		score = lvl.removeScore();
		assertEquals (score, 0);
	}
	
	public void testCheckStarProgress() {
		assertEquals(lvl.checkStarProgress(), 0);
		
		lvl.addScore(w3);
		lvl.addWord(w3);
		assertEquals(lvl.checkStarProgress(), 0);
		assertEquals(lvl.getHighScore(), lvl.getScore());
		
		int score = lvl.getScore();
		lvl.removeScore();
		assertEquals(lvl.checkStarProgress(), 0);
		assertEquals(lvl.getHighScore(), score);
		assertEquals(lvl.getScore(),0);
		
		lvl.addScore(w3);
		lvl.addScore(w3);
		assertEquals(lvl.checkStarProgress(), 1);
		assertEquals(lvl.getHighScore(), lvl.getScore());
		
		lvl.addScore(w3);
		assertEquals(lvl.checkStarProgress(), 2);
		
		lvl.addScore(w1);
		assertEquals(lvl.checkStarProgress(), 3);
		
	}
	
	public void testResetLevel() {
		lvl.addWord(w1);
		lvl.addScore(w1);
		lvl.checkStarProgress();
		boolean isReset = lvl.resetLevel();
		
		assertTrue (isReset);
		assertEquals (lvl.getScore(), 0);
		assertEquals (lvl.getCurrentStars(), 0);
		assertTrue (lvl.getWordList().isEmpty());
	}
	
	public void testRandomLetter () {
		int numEs = 0;
		for (int i=0; i < 1000; i++) {
			String isItAnE = lvl.randomLetter();
			if (isItAnE == "A") {
				numEs++;
			}
		}
		System.out.println("" + numEs);
	}
	
	

}
