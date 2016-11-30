package builder.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import builder.controller.NewLevelController;

public class BuilderApplication extends JFrame {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 7707913344008839015L;

	private MainMenuPanel mmp;
	private LevelCreatorPanel lcp;

	/**
	 * Create the frame.
	 */
	public BuilderApplication() {
		super();

		splashWindow();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		mmp = new MainMenuPanel(contentPane);
		lcp = new LevelCreatorPanel(contentPane);
		contentPane.add(mmp);
		contentPane.add(lcp);
		
		setContentPane(contentPane);
        pack();   
        setLocationByPlatform(true);
        setVisible(true);
		setBounds(250, 80, 816, 589);
		setTitle("Builder");
		
		
		
		
		
	}
	
	public MainMenuPanel getMainMenuPanel() {
		return mmp;
	}
	
	public LevelCreatorPanel getLevelCreatorPanel() {
		return lcp;
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
