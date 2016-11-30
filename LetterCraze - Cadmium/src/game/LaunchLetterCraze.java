package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

import builder.view.BuilderApplication;
import builder.view.SplashScreenWindow;
import game.view.LCApplication;

public class LaunchLetterCraze {
	
	LCApplication app = new LCApplication();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.setVisible(true);

}
