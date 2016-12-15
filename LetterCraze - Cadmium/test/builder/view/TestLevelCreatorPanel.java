package builder.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

import builder.model.Level;
import junit.framework.TestCase;

import java.awt.event.MouseEvent;

public class TestLevelCreatorPanel extends TestCase {
	
	LevelCreatorPanel lcp;
	
	public void setUp(){
		JPanel contentPane = new JPanel();
		lcp = new LevelCreatorPanel(contentPane, new Level());
	}
	
	public void testInputNumMoves(){
		JFormattedTextField tf = lcp.getMovesTextField();
		tf.setValue(45);
		// TODO figure out how to test TextFields
		Level lvl = lcp.getLevel();
		
		//assertEquals(tf.getValue(), 45);
		//assertEquals(tf.getValue(), lvl.getNumMoves());
	}
	
	public void testResetLevel(){
		JButton resetButton = lcp.getResetButton();
		JToggleButton testSquare = lcp.getBoardPanel().getSquare(0);
		
		assertFalse(testSquare.isSelected());
		
		MouseEvent meSquare = new MouseEvent(testSquare, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, testSquare.getX(), testSquare.getY(), 1, false);
		
		//assertTrue(testSquare.isSelected());
		
		MouseEvent meReset = new MouseEvent(resetButton, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, resetButton.getX(), resetButton.getY(), 1, false);
		
		//assertFalse(testSquare.isSelected());
	}
}
