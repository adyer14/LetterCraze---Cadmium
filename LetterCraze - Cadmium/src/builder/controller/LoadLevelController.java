package builder.controller;

import builder.model.*;
import builder.view.*;

public class LoadLevelController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	MainMenu mainMenu;
	MainMenuPanel mainMenuView;
	
	public LoadLevelController(Level lvl, LevelCreatorPanel levelCreatorView, MainMenu mainMenu, MainMenuPanel mainMenuView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
		this.mainMenu = mainMenu;
		this.mainMenuView = mainMenuView;
	}
}
