package game.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	LevelPanel lp;
	
	/**
	 * Create the frame.
	 */
	public LCApplication(Model m) {
		super();
		
		this.m = m;
		splashWindow();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		lsp = new LevelSelectPanel(m, contentPane);
		lp = new LevelPanel(contentPane);
		contentPane.add(lsp);
		contentPane.add(lp);
		
		setContentPane(contentPane);
        pack();   
        setLocationByPlatform(true);
        setVisible(true);
		setBounds(250, 80, 816, 589);
		setTitle("LetterCraze");

	}
	
	public void splashWindow() {
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
	}

}
