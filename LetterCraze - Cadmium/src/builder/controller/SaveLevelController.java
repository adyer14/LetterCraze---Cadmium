package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import builder.model.*;
import builder.view.*;

public class SaveLevelController implements ActionListener{
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public SaveLevelController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		lvl.saveLevel();
	}
}
