package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.Level;
import builder.view.LevelCreatorPanel;

/**
 * Controller for inputting the score required to achieve two stars (not for theme levels).
 *
 */
public class InputStarValueController2 implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	/**
	 * Constructor
	 * @param lvl
	 * @param levelCreatorView
	 */
	
	public InputStarValueController2(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	/**
	 * Override to retrieve a value from a text field
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		JTextField tf = (JTextField) ae.getSource();
		update(tf);
	}
	
	/**
	 * Update value for the entity object (and for the JTextField if input is not valid)
	 * @param tf
	 */
	public void update(JTextField tf){
		try {
			int score = Integer.parseInt(tf.getText());
			
			lvl.setScores(2, score);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getScores(2));
		}
	}
}
