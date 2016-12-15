package game.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	ArrayList<Square> squares;
	ArrayList<Square> selectedSquares;
	ArrayList<Tile> t;
	Board b;
	Tile t1;
	Tile t2;
	Tile t3;
	Tile t4;
	Tile t5;
	Tile t6;
	Square s;
	Square s2;
	Square s3;
	
	protected void setUp() {
		squares = new ArrayList<Square>(36);
		selectedSquares = new ArrayList<Square>();
		t = new ArrayList<Tile>();
		b = new Board(squares);
		t1 = new LetterTile("A", 1);
		t2 = new LetterTile("B", 2);
		t3 = new LetterTile("C", 2);
		t4 = new LetterTile("D", 2);
		t5 = new LetterTile("E", 2);
		t6 = new LetterTile("F", 2);
		s = new Square(0,0,true,t1);
		s2 = new Square(1,2,true,t2);
		s3 = new Square(1,2,true,t3);
		for (int i = 0; i < 6; i++){			
			for (int j = 0; j < 6; j++){
				b.getBoardSquares().add(new Square(i, j, true, t1));
			}
		}
		b.setSelectedSquares(selectedSquares);
		
	}
	public void testnumOfSTiles() {
		assertEquals(0, b.numOfSTiles());
		b.selectedSquares.add(s);
		assertTrue(1 == b.numOfSTiles());
	}
	
	
	public void testisValidSelection(){
		b.getSelectedSquares().add(s2);
		b.getSelectedSquares().add(s3);
		assertTrue(b.isValidSelection());
	}
	
	public void testclearTiles(){
		if (b.numOfSTiles() != 0){
			b.clearTiles();
			assertTrue(0 == b.numOfSTiles());
		}
		else {
			b.selectedSquares.add(s);
			b.clearTiles();
			assertTrue(0 == b.numOfSTiles());
		}
	}
	public void testfloatTilesUp(){
		b.selectedSquares.clear();
		t.add(t1);
		t.add(t2);
		t.add(t3);
		t.add(t4);
		t.add(t5);
		t.add(t6);
		
		
		for (int i = 0; i < 6; i++){			
			for (int j = 0; j < 6; j++){
				b.getSelectedSquares().add(new Square(i, j, true, t.get(j)));
			}
		}
		b.selectedSquares.add(s);
		b.floatTilesUp();
		assertTrue( s.containsTile(t2) );
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
