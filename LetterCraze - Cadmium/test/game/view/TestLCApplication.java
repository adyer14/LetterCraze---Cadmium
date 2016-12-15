package game.view;

import junit.framework.TestCase;
import game.model.*;

public class TestLCApplication extends TestCase {
	Model m;
	LCApplication lca;
	
	protected void setUp(){
		m = new Model();
		lca = new LCApplication(m);
	}
	
	public void testInitialize(){
		
		assertEquals(lca.getModel(), m);
	}
	
}
