package builder.controller;

import builder.model.*;
import builder.view.*;

public class InputTimeController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputTimeController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
