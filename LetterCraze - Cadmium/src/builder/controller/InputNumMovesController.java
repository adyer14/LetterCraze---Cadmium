package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.*;
import builder.view.*;

public class InputNumMovesController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputNumMovesController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		JTextField tf = (JTextField) ae.getSource();
		update (tf);
	}
	
	void update (JTextField tf) {
		try {
			//String name = tf.getText();
			int numMoves = Integer.parseInt(tf.getText());
			lvl.setNumMoves(numMoves);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getNumMoves());
		}
	}

}
