package game.view;

import javax.swing.JFrame;

import game.view.SplashScreenWindow;

public class LCApplication extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 4242171863344367254L;
	
	private LevelSelectPanel lsp;
	private LevelPanel lp;
	
	/**
	 * Create the frame.
	 */
	public LCApplication() {
		super();
		
		//____________________________________________________
		
		SplashScreenWindow splashWindow = new SplashScreenWindow();

		try {
			splashWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
			splashWindow.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		setBounds(250, 80, 816, 589);
		setTitle("LetterCraze");
		
		lsp = new LevelSelectPanel();
		getContentPane().add(lsp);
		lsp.setVisible(true);
		
//		lcp = new LevelCreatorPanel();
//		getContentPane().add(lcp);
//		lcp.setVisible(true);
	
		
		//_____________________________________________________

		

	}

}
