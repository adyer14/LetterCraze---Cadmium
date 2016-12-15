package builder.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import builder.model.Level;
import junit.framework.TestCase;

public class TestLevelCreatorPanel extends TestCase {
	
	LevelCreatorPanel lcp;
	
	public void setUp(){
		JPanel contentPane = new JPanel();
		lcp = new LevelCreatorPanel(contentPane, new Level());
	}
	
	public void testInputNumMoves(){
		JFormattedTextField tf = lcp.getMovesTextField();
		tf.setValue(45);
		
		Level lvl = lcp.getLevel();
		
		//assertEquals(tf.getValue(), 45);
		//assertEquals(tf.getValue(), lvl.getNumMoves());
	}
}
