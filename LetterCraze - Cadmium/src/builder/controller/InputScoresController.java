package builder.controller;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.*;
import builder.view.*;

public class InputScoresController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputScoresController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		JTextField tf1 = (JTextField) ae.getSource();
		JTextField tf2 = (JTextField) ae.getSource();
		JTextField tf3 = (JTextField) ae.getSource();
		
		update (tf1, tf2, tf3);
	}
	
	void update (JTextField tf1, JTextField tf2, JTextField tf3) {
		try {
			int score1 = Integer.parseInt(tf1.getText());
			int score2 = Integer.parseInt(tf2.getText());
			int score3 = Integer.parseInt(tf3.getText());
			
			int[] scores = new int[3];
			
			scores[0] = score1;
			scores[1] = score2;
			scores[2] = score3;
			
			lvl.setScores(scores);
			
		} catch (Exception e) {
			// just put old value back in
			tf1.setText("" + lvl.getScores(1));
			tf2.setText("" + lvl.getScores(2));
			tf3.setText("" + lvl.getScores(3));
		}
	}
}
