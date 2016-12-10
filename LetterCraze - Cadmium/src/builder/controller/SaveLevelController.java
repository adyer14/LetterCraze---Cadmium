package builder.controller;

import builder.model.*;
import builder.view.*;

public class SaveLevelController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public SaveLevelController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
