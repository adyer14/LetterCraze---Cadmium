package game.model;

public class Model {
	
	private Level level [] = new Level [15];
	LevelSelect ls = new LevelSelect (getLevel());
	
	public Level[] getLevel() {
		return level;
	}
	public void setLevel(Level level[]) {
		this.level = level;
	}
	
	public LevelSelect getLevelSelect() {
		return ls;
	}
	
	public void setLevelSelect(LevelSelect ls) {
		this.ls = ls;
	}
	
}
