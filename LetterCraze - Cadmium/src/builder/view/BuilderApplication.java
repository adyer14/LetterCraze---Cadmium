package builder.view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import builder.controller.GoToDeleteLevelController;
import builder.controller.GoToLoadLevelController;
import builder.controller.NewLevelController;
import builder.model.*;
/**
 * Builder Application, this is the entire container for the builder. It includes the logic which displays
 * an initial splash screen as well as a menu screen with buttons to chose your next step.
 * @author Cadmium : Alex M, Alex, Monika, Juan, Erin
 */
public class BuilderApplication extends JFrame {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 7707913344008839015L;
	
	private MainMenuPanel mmp;
	private LevelCreatorPanel lcp;
	private LoadLevelPanel llp;
	private DeleteLevelPanel dlp;
	private Model model;

	/**
	 * Create the frame.
	 */
	public BuilderApplication(Model model) {
		super();
		this.model = model;
		splashWindow();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		mmp = new MainMenuPanel(contentPane);
		lcp = new LevelCreatorPanel(contentPane, new Level());
		llp = new LoadLevelPanel(this, model, contentPane);
		dlp = new DeleteLevelPanel(model, contentPane);
		contentPane.add(mmp, "mainMenuPanel");
		contentPane.add(lcp, "levelCreatorPanel");
		contentPane.add(llp, "loadLevelPanel");
		contentPane.add(dlp, "deleteLevelPanel");
		
		setContentPane(contentPane);
        pack();   
        setLocationByPlatform(true);
        setVisible(true);
		setBounds(250, 80, 816, 589);
		setTitle("Builder");
		
		initControllers();
		
	}
	
	public MainMenuPanel getMainMenuPanel() {
		return mmp;
	}
	
	public LevelCreatorPanel getLevelCreatorPanel() {
		return lcp;
	}
	
	public LoadLevelPanel getLoadLevelPanel() {
		return llp;
	}
	
	public DeleteLevelPanel getDeleteLevelPanel() {
		return dlp;
	}
	/**
	 * Splash window is a window which is displayed for a moment to introduce the group and the application
	 */
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

	/**
	 * initialize all controllers within the main menu
	 */
	public void initControllers() {
		NewLevelController NLcontrol = new NewLevelController(this.mmp);
		mmp.getNewLevelButton().addActionListener(NLcontrol);
		GoToLoadLevelController LLcontrol = new GoToLoadLevelController(this);
		mmp.getLoadLevelButton().addActionListener(LLcontrol);
		GoToDeleteLevelController DLcontrol = new GoToDeleteLevelController(this);
		mmp.getDeleteLevelButton().addActionListener(DLcontrol);
	}
}
