package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.*;
import builder.view.*;

public class LoadLevelController implements ActionListener{
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
