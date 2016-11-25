package builder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewLevelController extends MouseAdapter {
	Level level;
	LevelCreatorPanel levelCreatorView;
	MainMenu mainMenu;
	MainMenuPanel mainMenuView;
	
	public NewLevelController(Level lvl, LevelCreatorPanel lcv, MainMenu mm, MainMenuPanel mmv){
		this.level = lvl;
		this.levelCreatorView = lcv;
		this.mainMenu = mm;
		this.mainMenuView = mmv;
	}
	
	@Override
	public void MouseClicked(MouseEvent me){
		levelCreatorPanel.setVisible(true);
		MainMenuPanel.setVisible(false);
		//????????????????
	}
}
