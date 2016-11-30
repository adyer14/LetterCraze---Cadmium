package builder.view;

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
