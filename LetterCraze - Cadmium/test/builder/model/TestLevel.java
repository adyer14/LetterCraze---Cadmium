package builder.model;

import junit.framework.TestCase;

public class TestLevel extends TestCase {
	
	Level lvl;
	
	protected void setUp(){
		lvl = new Level();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testInitialize(){
		// Check that all Level variables are being initialized properly
		assertEquals(lvl.getNumMoves(), 0);
		assertEquals(lvl.getLevelType(), "");
		assertEquals(lvl.getTime(), 0);
		assertEquals(lvl.getThemeName(), "");
		assertTrue(lvl.getThemeWords().isEmpty());
		assertEquals(lvl.getLevelNum(), 0);
		
		// Check that every square in the board is not in play
		for(int i = 0; i < 36; i++){
			assertFalse(lvl.getBoard().getSquare(i).getSquareInPlay());
		}
	}

}
