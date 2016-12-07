package builder.controller;

import builder.model.*;
import builder.view.*;

public class DeleteLevelController {
	Level lvl;
	MainMenu mainMenu;
	MainMenuPanel mainMenuPanel;
	
	public DeleteLevelController(Level lvl, MainMenu mainMenu, MainMenuPanel mainMenuPanel){
		this.lvl = lvl;
		this.mainMenu = mainMenu;
		this.mainMenuPanel = mainMenuPanel;
	}
	
}
