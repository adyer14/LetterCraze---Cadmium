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
	
	public void testSetScores(){
		try {
		lvl.setScores(1, 15);
		lvl.setScores(2, 30);
		lvl.setScores(3, 45);
		} catch (Exception e){
			return; // TODO something?
		}
		
		assertEquals(lvl.getScores(1), 15);
		assertEquals(lvl.getScores(2), 30);
		assertEquals(lvl.getScores(3), 45);
		
		try {
			lvl.setScores(2, 10);
		} catch (Exception e){
			assertEquals(lvl.getScores(2), 30);
		}
	}
	
	public void testGetScores(){
		assertEquals(lvl.getScores(5), 0);
	}
	
	public void testResetLevel(){
		lvl.setLevelNum(1);
		lvl.setLevelType("PUZZLE");
		lvl.setTime(45);
		
		try {
			lvl.setScores(1, 15);
			lvl.setScores(2, 30);
			lvl.setScores(3, 45);
		} catch (Exception e){
			// TODO ?
		}
		
		Board b = new Board();
		
		lvl.setBoard(b);
		
		assertEquals(lvl.getTime(), 45);
		assertEquals(lvl.getLevelType(), "PUZZLE");
		assertEquals(lvl.getLevelNum(), 1);
		assertEquals(lvl.getBoard(), b);
		
		lvl.resetLevel();
		assertTrue(lvl.resetLevel());
		
		assertEquals(lvl.getTime(), 0);
		assertEquals(lvl.getLevelType(), "");
		assertEquals(lvl.getLevelNum(), 0);
		assertEquals(lvl.getScores(1), 0);
		assertEquals(lvl.getScores(2), 0);
		assertEquals(lvl.getScores(3), 0);
		
	}
}

