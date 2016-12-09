package builder.controller;

import java.awt.TextField;
import java.awt.event.ActionEvent;

import builder.model.*;
import builder.view.*;

public class InputTimeController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputTimeController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	public void ActionPerformed(ActionEvent ae){
		TextField tf = (TextField) ae.getSource();
		update (tf);
	}
	
	void update (TextField tf) {
		try {
			int num = Integer.valueOf(tf.getText());
			
			if(num == lvl.getTime()){
				return;
			} else {
				lvl.setTime(num);
			}
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getTime());
		}
	}
}
