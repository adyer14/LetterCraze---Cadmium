package game.view;

import javax.swing.JPanel;

import game.model.Model;
import junit.framework.TestCase;

public class TestLevelPanel extends TestCase {
	
	Model m;
	JPanel contentPane;
	LevelSelectPanel lsp;
	LightningPanel lp;
	
	protected void setUp(){
		m = new Model();
		contentPane = new JPanel();
		lsp = new LevelSelectPanel(m, contentPane);
		lp = new LightningPanel (m, contentPane, 1, lsp);
	}
	
	public void testInitialize(){
		assertEquals(lp.getContentPane(), contentPane);
		assertEquals(lp.getModel(), m);
		assertEquals(lp.getLevelType(), "LIGHTNING");
		assertEquals(lp.getLevelNum(), 1);
		assertEquals(lp.getLsp(), lsp);
	}

}
