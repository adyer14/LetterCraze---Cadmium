package game.controller;
import java.util.Timer;
import java.util.TimerTask;

import game.model.*;
import game.view.LightningPanel;

public class EndLightningLevelController extends TimerTask {
	LightningLevel lightLevel;
//	LightningPanel lightPanel;

public EndLightningLevelController(LightningLevel l) {
//	this.lightPanel = lp;
	this.lightLevel = l;
}

//boolean timeEnded(Timer t){
//	return false;
//}

@Override
public void run() {
	// TODO Auto-generated method stub
	//display you suck window
	//window button calls exit level controller
	lightLevel.timer.cancel();
	
}
}