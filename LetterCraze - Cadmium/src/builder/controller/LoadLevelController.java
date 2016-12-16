package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.Level;
import builder.view.SelectLevelPanel;

public class LoadLevelController implements ActionListener{

	Level level = new Level();
	SelectLevelPanel levelSelectView;
	String pathName;
	
	
	public LoadLevelController(SelectLevelPanel levelSelect, String levelName, int levelNum){
		this.levelSelectView = levelSelect;
		this.pathName = levelName + levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		level.loadLevel(this.pathName);
		
	}

}
