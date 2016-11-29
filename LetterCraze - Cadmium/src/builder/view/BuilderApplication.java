package builder.view;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class BuilderApplication extends JFrame {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 7707913344008839015L;

	private MainMenuPanel mmp;
	private LevelCreatorPanel lcp;
	
	/**
	 * Launch the application.
	 */
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
					BuilderApplication frame = new BuilderApplication();
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
	public BuilderApplication() {
		super();

		setBounds(250, 80, 816, 589);
		setTitle("Builder");
		
		mmp = new MainMenuPanel();
		getContentPane().add(mmp);
		mmp.setVisible(false);
		
		lcp = new LevelCreatorPanel();
		getContentPane().add(lcp);
		lcp.setVisible(true);
		
	}

}
