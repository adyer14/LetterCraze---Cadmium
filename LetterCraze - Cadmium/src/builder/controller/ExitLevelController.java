package builder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builder.view.*;
import builder.model.*;

public class ExitLevelController extends MouseAdapter {
	Level level;
	LevelCreatorPanel levelCreatorView;
	MainMenu mainMenu;
	MainMenuPanel mainMenuView;
	
	public ExitLevelController(Level lvl, LevelCreatorPanel lcv, MainMenu mm, MainMenuPanel mmv){
		this.level = lvl;
		this.levelCreatorView = lcv;
		this.mainMenu = mm;
		this.mainMenuView = mmv;
	}
	
	@Override
	public void MousePressed(MouseEvent me){
		MainMenuPanel.setVisible(true);
		LevelCreatorPanel.setVisible(false);
		
		//????????????
	}

}
