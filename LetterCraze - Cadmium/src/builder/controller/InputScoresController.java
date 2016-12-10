package builder.controller;

import builder.model.*;
import builder.view.*;

public class InputScoresController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputScoresController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
