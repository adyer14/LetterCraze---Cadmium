package game;

import javax.swing.JFrame;

import game.view.LCApplication;

public class LaunchLetterCraze {
	
	static LCApplication app = new LCApplication();
	
	public static void main (String args []) {
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.setVisible(true);
	}
}
