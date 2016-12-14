package game.model;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestWord extends TestCase {

	Word word;
	ThemeDictionary thmDict;
	private Board b;
	private Square F;
	private Square C;
	private Square U;
	private Square K;
	
	protected void setUp() {
		b = new Board(null);
		F = new Square(0, 0, true, new LetterTile("F", b.getLetterScores().get("F")));
		C = new Square(0, 0, true, new LetterTile("C", b.getLetterScores().get("C")));
		U = new Square(0, 0, true, new LetterTile("U", b.getLetterScores().get("U")));
		K = new Square(0, 0, true, new LetterTile("K", b.getLetterScores().get("K")));

		Square[] fuck = {F,U,C,K, null};
		ArrayList<Square> fuckList = new ArrayList<Square>(Arrays.asList(fuck));
		word = new Word(fuckList);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testNumOfSTiles() {
		assertEquals(word.numOfSTiles(), 4);
	}
	
	public void testCalculateScore() {
		assertEquals(word.calculateScore(), 30);
	}
	
	public void testMakeString() {
		assertEquals(word.makeString(),word.getActualString());
		assertEquals(word.getActualString(), "FUCK");
	}
	
}
