package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.*;
import builder.view.*;
/**
 * Load Level Controller
 * Pulls file from local file system to continue working on 
 *
 */
public class LoadLevelController implements ActionListener{
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	MainMenu mainMenu;
	MainMenuPanel mainMenuView;
	/**
	 * Constructor
	 * @param lvl Level being loaded
	 * @param levelCreatorView The main builder view
	 * @param mainMenu The main menu model
	 * @param mainMenuView The main menu view
	 */
	public LoadLevelController(Level lvl, LevelCreatorPanel levelCreatorView, MainMenu mainMenu, MainMenuPanel mainMenuView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
		this.mainMenu = mainMenu;
		this.mainMenuView = mainMenuView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
