package builder.controller;

import builder.model.*;
import builder.view.*;

public class InputNumMovesController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputNumMovesController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}

}
