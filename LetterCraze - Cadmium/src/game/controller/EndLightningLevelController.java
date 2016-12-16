package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.*;
import game.view.LightningPanel;
/**
 * This controlls how a lightning level ends. It relies on the timer to call the exit level 
 * functionality
 *
 */
public class EndLightningLevelController implements ActionListener {
	LightningLevel ll;
	LightningPanel lp;
	int time;
/**
 * Constructor
 * @param lightPanel Container
 * @param lightLevel Level
 */
	public EndLightningLevelController(LightningPanel lightPanel, LightningLevel lightLevel) {
		this.ll = lightLevel;
		this.lp = lightPanel;
		this.time = 10; //TODO ll.getTime();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		time--;
		lp.getTimeLabel().setText(Integer.toString(time));
		if (time == 0) {//ll.getTime()) {
			//display you suck window
			lp.endLevel();
		}
		
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}