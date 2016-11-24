package game.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class LCApplication extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 4242171863344367254L;
	
	private LevelSelectPanel lsp;
	private LevelPanel lp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		
		//lp = new LevelPanel();
		//add (lp);
		lsp = new LevelSelectPanel();
		getContentPane().add (lsp);
		//lp.setVisible(false);
		//lsp.setVisible(true);
		lsp.update();
	}

}
