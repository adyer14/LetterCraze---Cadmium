package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builder.model.Level;
import builder.view.LevelCreatorPanel;

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
