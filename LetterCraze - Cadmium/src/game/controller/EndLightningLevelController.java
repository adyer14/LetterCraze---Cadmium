package game.controller;
import java.util.Timer;

import game.model.*;
import game.view.LightningPanel;

public class EndLightningLevelController{
	LightningLevel lightLevel;
	LightningPanel lightPanel;

public EndLightningLevelController (LightningLevel l, LightningPanel lp) {
	this.lightPanel = lp;
	this.lightLevel = l;
}

boolean timeEnded(Timer t){
	return false;
}
}