package game.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.controller.LevelSelectController;
import game.model.Model;
import game.view.SplashScreenWindow;
/**
 * The Letter Craze Application
 * @author Cadmium - Monika, Alex M, Alex, Juan, Erin
 *
 */
public class LCApplication extends JFrame {

	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 4242171863344367254L;

	private Model m;
	private LevelSelectPanel lsp;
	private ThemePanel[] thmPnl = new ThemePanel[6];
	private LightningPanel[] litPnl = new LightningPanel[6];
	private PuzzlePanel[] pzzPnl = new PuzzlePanel[6];
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public LCApplication(Model m) {
		super();
		this.m = m;
		
		splashWindow();
		initPanels();
		
        pack();   
        setLocationByPlatform(true);
        setVisible(true);
		setBounds(250, 80, 816, 589);
		setTitle("LetterCraze");

	}
	/**
	 * Introduces the application
	 */
	public void splashWindow() {
		SplashScreenWindow splashWindow = new SplashScreenWindow();

		try {
			splashWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(100);
			splashWindow.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void initPanels() {
		contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		lsp = new LevelSelectPanel(m, contentPane);
		contentPane.add(lsp, "levelSelectPanel");
		for (int i = 1; i <= 5; i++) { 
			String puzzID = "puzzlePanel" + i;
			//PuzzleLevel pzzLvl = m.getPuzzleLevel(i);
			pzzPnl[i] = new PuzzlePanel(m, contentPane, "puzzle", i, lsp);
			contentPane.add(pzzPnl[i], puzzID);
			LevelSelectController lspcontrol = new LevelSelectController(m, this, "puzzle", i);
			lsp.getPuzzleButton(i).addActionListener(lspcontrol);
			
			String litID = "lightningPanel" + i;
			//LightningLevel litLvl = m.getLightningLevel(i);
			litPnl[i] = new LightningPanel(m, contentPane, "lightning", i, lsp);
			contentPane.add(litPnl[i], litID);
			LevelSelectController lslcontrol = new LevelSelectController(m, this, "lightning", i);
			lsp.getLightningButton(i).addActionListener(lslcontrol);
			
			String thmID = "themePanel" + i;
			//ThemeLevel thmLvl = m.getThemeLevel(i);
			thmPnl[i] = new ThemePanel(m, contentPane, "theme", i, lsp);
			contentPane.add(thmPnl[i], thmID);
			LevelSelectController lstcontrol = new LevelSelectController(m, this, "theme", i);
			lsp.getThemeButton(i).addActionListener(lstcontrol);
		}
		
		setContentPane(contentPane);
	}

	public LevelSelectPanel getLevelSelectPanel() {
		return lsp;
	}

	public PuzzlePanel getPuzzlePanel(int levNum) {
		return pzzPnl[levNum];
	}
	
	public LightningPanel getLightningPanel(int levNum) {
		return litPnl[levNum];
	}
	
	public ThemePanel getThemePanel(int levNum) {
		return thmPnl[levNum];
	}

	public Model getModel() {
		// TODO Auto-generated method stub
		return m;
	}
	
}
