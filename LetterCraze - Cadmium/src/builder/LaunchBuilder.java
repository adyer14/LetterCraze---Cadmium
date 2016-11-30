package builder;

import java.awt.EventQueue;

import builder.view.BuilderApplication;
import builder.view.SplashScreenWindow;

public class LaunchBuilder {

	
	public static void main(String[] args){
		
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
		    Thread.sleep(100);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashWindow.setVisible(false);
					BuilderApplication frame = new BuilderApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
