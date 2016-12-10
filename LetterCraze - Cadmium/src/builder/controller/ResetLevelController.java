package builder.controller;

import builder.model.*;
import builder.view.*;

public class ResetLevelController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public ResetLevelController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
