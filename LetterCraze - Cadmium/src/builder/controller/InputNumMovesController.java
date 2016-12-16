package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.*;
import builder.view.*;

/**
 * Controller for inputting the maximum number of moves (for puzzle level)
 * 
 */
public class InputNumMovesController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	/**
	 * Constructor
	 * @param lvl Current Level
	 * @param levelCreatorView Current Level view
	 */
	public InputNumMovesController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	/**
	 * Override of action performed
	 * @param tf is the text field where the move number is entered
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		JTextField tf = (JTextField) ae.getSource();
		update (tf);
	}
	
	/**
	 * Update value for the entity object (and for the JTextField if input is not valid)
	 * @param tf 
	 */
	void update (JTextField tf) {
		try {
			int numMoves = Integer.parseInt(tf.getText());
			lvl.setNumMoves(numMoves);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getNumMoves());
		}
	}

}
