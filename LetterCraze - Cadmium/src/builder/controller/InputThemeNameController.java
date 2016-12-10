package builder.controller;

import java.awt.TextField;
import java.awt.event.ActionEvent;

import builder.model.*;
import builder.view.*;

public class InputThemeNameController {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputThemeNameController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	public void ActionPerformed(ActionEvent ae){
		TextField tf = (TextField) ae.getSource();
		update (tf);
	}
	
	void update (TextField tf) {
		try {
			String name = tf.getText();
			lvl.setThemeName(name);
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + lvl.getThemeName());
		}
	}
}
