package builder.controller;

import builder.model.*;
import builder.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class SelectLevelTypeController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public SelectLevelTypeController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		JComboBox<String> cb = (JComboBox<String>) ae.getSource();
		String levelType = (String) cb.getSelectedItem();
		
		System.out.println("The level type chosen is " + levelType);
		
		if (levelType.equals("PUZZLE")){
			levelCreatorView.setUpPuzzle();
		} else if (levelType.equals("LIGHTNING")){
			levelCreatorView.setUpLightning();
		} else if (levelType.equals("THEME")){
			levelCreatorView.setUpTheme();
		} else {
			levelCreatorView.setUpDefault();
		}
	}
}
