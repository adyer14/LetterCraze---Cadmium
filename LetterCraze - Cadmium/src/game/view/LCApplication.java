package game.view;

import javax.swing.JFrame;

import game.model.Level;
import game.model.LevelSelect;
import game.model.Model;
import game.view.SplashScreenWindow;

public class LCApplication extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 4242171863344367254L;

	Model m;
	LevelSelectPanel lsp;
	
	/**
	 * Create the frame.
	 */
	public LCApplication(Model m) {
		super();
		
		this.m = m;
		
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
		
		lsp = new LevelSelectPanel(this.m, this, lsp);
		getContentPane().add(lsp);
		lsp.setVisible(true);
	
		
		//_____________________________________________________

		

	}

}
