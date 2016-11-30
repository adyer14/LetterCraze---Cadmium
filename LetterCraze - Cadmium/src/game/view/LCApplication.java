package game.view;

import javax.swing.JFrame;

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
