package game;

import java.awt.EventQueue;

import builder.view.SplashScreenWindow;
import game.view.LCApplication;

public class LaunchLetterCraze {
		
	
	public static void main(String[] args) {
		SplashScreenWindow splashWindow = new SplashScreenWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashWindow.setVisible(false);
					LCApplication frame = new LCApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}


}
