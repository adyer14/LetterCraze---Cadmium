package game;

import javax.swing.JFrame;

import game.model.Level;
import game.model.LevelSelect;
import game.model.Model;
import game.view.LCApplication;

public class LaunchLetterCraze {
	
	public static void main (String args []) {
		Model m = new Model();
		
		LCApplication app = new LCApplication(m);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
