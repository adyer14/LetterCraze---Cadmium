package builder.model;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	
	Board b;
	
	protected void setUp(){
		b = new Board();
	}
	
	public void testInitialize(){
		for(int i = 0; i < 36; i++){
			assertFalse(b.getSquare(i).getSquareInPlay());
		}
	}
	
	public void testToggleSquare(){
		
		b.toggleSquare(28);
		assertTrue(b.getSquare(28).getSquareInPlay());
		
		b.resetSquares();
		assertFalse(b.getSquare(28).getSquareInPlay());
		
	}

}
