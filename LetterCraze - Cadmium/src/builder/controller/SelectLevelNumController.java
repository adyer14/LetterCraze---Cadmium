package builder.controller;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.Level;
import builder.view.LevelCreatorPanel;

import java.awt.event.ActionEvent;

/**
 * Controller to select the level number being worked on (from drop down menu).
 *
 */
public class SelectLevelNumController implements ActionListener {
	
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public SelectLevelNumController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		JComboBox<String> cb = (JComboBox<String>) ae.getSource();
		String levelNum = (String) cb.getSelectedItem();
		
		System.out.println("The level number chosen is " + levelNum);
		
		if (levelNum.equals("1")){
			lvl.setLevelNum(1);
			
		} else if (levelNum.equals("2")){
			lvl.setLevelNum(2);
			
		} else if (levelNum.equals("3")){
			lvl.setLevelNum(3);
			
		} else if (levelNum.equals("4")){
			lvl.setLevelNum(4);
			
		} else if (levelNum.equals("5")){
			lvl.setLevelNum(5);
			
		} else {
			lvl.setLevelNum(0);
		}
	}

}
