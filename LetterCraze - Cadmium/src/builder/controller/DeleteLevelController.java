package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.Level;
import builder.view.SelectLevelPanel;

public class DeleteLevelController implements ActionListener{

	Level level = new Level();
	SelectLevelPanel levelSelectView;
	String pathName;
	
	
	public DeleteLevelController(SelectLevelPanel levelSelect, String levelName, int levelNum){
		this.levelSelectView = levelSelect;
		this.pathName = "src/levels/" + levelName + levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		level.deleteLevel(this.pathName);
		
	}

}