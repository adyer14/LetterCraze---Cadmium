package builder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builder.view.*;
//import builder.model.*;

public class NewLevelController extends MouseAdapter {
	//Level level;
	LevelCreatorPanel levelCreatorView;
	//MainMenu mainMenu;
	MainMenuPanel mainMenuView;
	
	public NewLevelController(/*Level lvl,*/ LevelCreatorPanel lcv, /*MainMenu mm,*/ MainMenuPanel mmv){
		//this.level = lvl;
		this.levelCreatorView = lcv;
		//this.mainMenu = mm;
		this.mainMenuView = mmv;
	}
	
	public void MouseClicked(MouseEvent me){
	
		mainMenuView.setVisible(false);
		//mainMenuView.invalidate();
		
		levelCreatorView.setVisible(true);
		//levelCreatorView.validate();
	}
}
