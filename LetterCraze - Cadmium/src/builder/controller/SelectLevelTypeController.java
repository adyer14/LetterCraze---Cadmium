package builder.controller;

import builder.model.*;
import builder.view.*;

public class SelectLevelTypeController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public SelectLevelTypeController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
