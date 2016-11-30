package game.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import builder.view.SplashScreenWindow;

public class LCApplication extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 4242171863344367254L;
	
	private LevelSelectPanel lsp;
	private LevelPanel lp;
	
	
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


	/**
	 * Create the frame.
	 */
	public LCApplication() {
		super();

		setBounds(250, 80, 816, 589);
		setTitle("LetterCraze");
		
		lsp = new LevelSelectPanel();
		getContentPane().add (lsp);
		lsp.setVisible(false);
		
		lp = new LevelPanel();
		getContentPane().add(lp);
		lp.setVisible(true);
		

	}

}
