package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.Level;
import builder.view.LevelCreatorPanel;

/**
 * Controller for inputting the score required to achieve three stars (not for theme levels).
 *
 */
public class InputStarValueController3 implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputStarValueController3(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
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
			
			lvl.setScores(3, score);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getScores(3));
		}
	}

}
