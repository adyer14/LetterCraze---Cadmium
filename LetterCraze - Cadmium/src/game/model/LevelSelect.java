package game.model;

public class LevelSelect {

	Level playableLevels [] = new Level [15];
	
	LevelSelect (Level levels []) {
		for (int i = 0; i < 15; i++) {
			playableLevels [i] = levels [i];
		}
	}
	
}
