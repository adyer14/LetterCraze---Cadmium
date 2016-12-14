package game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class TestPuzzleLevel extends TestCase {

	PuzzleLevel lvl;
	Word w1;
	Word w2;
	Word w3;
	Square A;
	Square C;
	Square E;
	Square F;
	Square H;
	Square K;
	Square O;
	Square R;
	Square T;
	Square U;
	Square W;
	Square Y;
	
	protected void setUp() {
		int starVal[] = {10, 20, 30};
		Board b = new Board(null);
		int levNum = 2;
		int numMoves = 15;
		lvl = new PuzzleLevel(starVal, b, null, levNum, numMoves);
	
		A = new Square(0, 0, true,new LetterTile("A", b.getLetterScores().get("A")));
		C = new Square(0, 0, true,new LetterTile("C", b.getLetterScores().get("C")));
		E = new Square(0, 0, true,new LetterTile("E", b.getLetterScores().get("E")));
		F = new Square(0, 0, true,new LetterTile("F", b.getLetterScores().get("F")));
		H = new Square(0, 0, true,new LetterTile("H", b.getLetterScores().get("H")));
		K = new Square(0, 0, true,new LetterTile("K", b.getLetterScores().get("K")));
		O = new Square(0, 0, true,new LetterTile("O", b.getLetterScores().get("O")));
		R = new Square(0, 0, true,new LetterTile("R", b.getLetterScores().get("R")));
		T = new Square(0, 0, true,new LetterTile("T", b.getLetterScores().get("T")));
		U = new Square(0, 0, true,new LetterTile("U", b.getLetterScores().get("U")));
		W = new Square(0, 0, true,new LetterTile("W", b.getLetterScores().get("W")));
		Y = new Square(0, 0, true,new LetterTile("Y", b.getLetterScores().get("Y")));

		Square[] fucktruck = {F,U,C,K,T,R,U,C,K};
		ArrayList<Square> fucktruckList = new ArrayList<Square>(Arrays.asList(fucktruck));
		w1 = new Word(fucktruckList);
		Square[] fuck = {F,U,C,K};
		ArrayList<Square> fuckList = new ArrayList<Square>(Arrays.asList(fuck));
		w2 = new Word(fuckList);
		Square[] you = {Y,O,U};
		ArrayList<Square> youList = new ArrayList<Square>(Arrays.asList(you));
		w3 = new Word(youList);
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
		
		lvl.addWord(w1);
		lvl.addWord(w2);
		lvl.removeWord();
		assertEquals (lvl.getScore(), w1.calculateScore());
		
		score = lvl.removeScore();
		assertEquals (lvl.getScore(), 0);
	}
	
	public void testCheckStarProgress() {
		assertEquals(lvl.checkStarProgress(), 0);
		
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
		int numAs = 0;
		int numBs = 0;
		int numCs = 0;
		int numDs = 0;
		int numEs = 0;
		int numFs = 0;
		int numGs = 0;
		int numHs = 0;
		int numIs = 0;
		int numJs = 0;
		int numKs = 0;
		int numLs = 0;
		int numMs = 0;
		int numNs = 0;
		int numOs = 0;
		int numPs = 0;
		int numQs = 0;
		int numRs = 0;
		int numSs = 0;
		int numTs = 0;
		int numUs = 0;
		int numVs = 0;
		int numWs = 0;
		int numXs = 0;
		int numYs = 0;
		int numZs = 0;
		for (int i=0; i < 10000; i++) {
			String randLetter = ((LetterTile)lvl.randomTile()).getLetter();
			if (randLetter == "A") {
				numAs++;
			}
			if (randLetter == "B") {
				numBs++;
			}
			if (randLetter == "C") {
				numCs++;
			}
			if (randLetter == "D") {
				numDs++;
			}
			if (randLetter == "E") {
				numEs++;
			}
			if (randLetter == "F") {
				numFs++;
			}
			if (randLetter == "G") {
				numGs++;
			}
			if (randLetter == "H") {
				numHs++;
			}
			if (randLetter == "I") {
				numIs++;
			}
			if (randLetter == "J") {
				numJs++;
			}
			if (randLetter == "K") {
				numKs++;
			}
			if (randLetter == "L") {
				numLs++;
			}
			if (randLetter == "M") {
				numMs++;
			}
			if (randLetter == "N") {
				numNs++;
			}
			if (randLetter == "O") {
				numOs++;
			}
			if (randLetter == "P") {
				numPs++;
			}
			if (randLetter == "Q") {
				numQs++;
			}
			if (randLetter == "R") {
				numRs++;
			}
			if (randLetter == "S") {
				numSs++;
			}
			if (randLetter == "T") {
				numTs++;
			}
			if (randLetter == "U") {
				numUs++;
			}
			if (randLetter == "V") {
				numVs++;
			}
			if (randLetter == "W") {
				numWs++;
			}
			if (randLetter == "X") {
				numXs++;
			}
			if (randLetter == "Y") {
				numYs++;
			}
			if (randLetter == "Z") {
				numZs++;
			}
		
		}
		System.out.println("" + numEs);
		System.out.println("" + numTs);
		System.out.println("" + numAs);
		System.out.println("" + numOs);
		System.out.println("" + numIs);
		System.out.println("" + numNs);
		System.out.println("" + numSs);
		System.out.println("" + numHs);
		System.out.println("" + numRs);
		System.out.println("" + numDs);
		System.out.println("" + numLs);
		System.out.println("" + numCs);
		System.out.println("" + numUs);
		System.out.println("" + numMs);
		System.out.println("" + numWs);
		System.out.println("" + numFs);
		System.out.println("" + numGs);
		System.out.println("" + numYs);
		System.out.println("" + numPs);
		System.out.println("" + numBs);
		System.out.println("" + numVs);
		System.out.println("" + numKs);
		System.out.println("" + numJs);
		System.out.println("" + numXs);
		System.out.println("" + numQs);
		System.out.println("" + numZs);
	}
	
	

}
