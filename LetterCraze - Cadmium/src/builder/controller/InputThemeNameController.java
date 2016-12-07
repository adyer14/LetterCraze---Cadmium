package builder.controller;

import builder.model.*;
import builder.view.*;

public class InputThemeNameController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputThemeNameController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
}
