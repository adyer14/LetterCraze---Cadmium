package builder.controller;

import builder.model.*;
import builder.view.*;

public class InputThemeWordsController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputThemeWordsController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}

}
