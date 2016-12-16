package game.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestMove extends TestCase {
	Word word;
	Level level;
	Board board;
	ArrayList<Tile> oldTiles;
	ArrayList<Square> squares;
	int[] stars;
	Move m;
	Tile t1;
	Tile t2;
	Tile t3;
	Tile t4;
	Tile t5;
	Tile t6;
	Square s;
	Square s2;
	Square s3;
	
	protected void setUp(){
		ArrayList<Tile> oldTiles = new ArrayList<Tile>();
		ArrayList<Square> squares = new ArrayList<Square>();
		Word word = new Word(squares);
		Board board = new Board(squares);
		int[] stars = { 1, 2, 3 };
//		Move m = new Move(word, new LightningLevel(stars, board, oldTiles, 1, 100 ));
		t1 = new LetterTile("A", 1);
		t2 = new LetterTile("B", 2);
		t3 = new LetterTile("C", 2);
		t4 = new LetterTile("D", 2);
		t5 = new LetterTile("E", 2);
		t6 = new LetterTile("F", 2);
		s = new Square(0,0,true,t1);
		s2 = new Square(1,2,true,t2);
		s3 = new Square(1,2,true,t3);
	}
	
	public void testdoMove(){
		
	}
	public void testundoMove(){
		
	}
	public void testisValid(){
		
	}
	public void testprintBoard(){
		
	}
	public void testnumOfSTiles(){
		
		Square[] squares = {s, s2, s3};
		System.out.println(squares);
		assertEquals("testing", 0, m.numOfSTiles(squares));
	}
}
