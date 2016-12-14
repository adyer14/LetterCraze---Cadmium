package builder.controller;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.*;
import builder.view.*;

/**
 * Controller for inputting time (lightning levels only).
 *
 */
public class InputTimeController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputTimeController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
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
			int num = Integer.parseInt(tf.getText());
			lvl.setTime(num);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getTime());
		}
	}
}
