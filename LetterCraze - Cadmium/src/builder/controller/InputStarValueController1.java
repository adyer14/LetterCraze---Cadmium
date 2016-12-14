package builder.controller;

import builder.model.Level;
import builder.view.LevelCreatorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class InputStarValueController1 implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputStarValueController1(Level lvl, LevelCreatorPanel levelCreatorView){
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
			lvl.setScores(1, score);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getScores(1));
		}
	}
}
