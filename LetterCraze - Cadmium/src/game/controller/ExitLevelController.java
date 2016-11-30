package game.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.model.Level;
import game.view.LevelPanel;
import game.view.LevelSelectPanel;

public class ExitLevelController extends MouseAdapter {
	Level level;
	LevelPanel levelView;
	LevelSelectPanel levelSelectView;
	
	public ExitLevelController(Level lvl, LevelPanel lcv, LevelSelectPanel mmv){
		this.level = lvl; 
		this.levelView = lcv;
		this.levelSelectView = mmv;
	}
	
	public void MousePressed(MouseEvent me){
		
		//save progress
		
		levelView.setVisible(false);
		//levelCreatorView.invalidate();
		
		levelSelectView.setVisible(true);
		//mainMenuView.validate();
	}

}
