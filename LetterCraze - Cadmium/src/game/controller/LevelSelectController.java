package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import game.model.Board;
import game.model.LightningLevel;
import game.model.PuzzleLevel;
import game.model.ThemeLevel;

public class LevelSelectController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    JButton source = (JButton) e.getSource();
	    String buttonName = source.getName();
	    openLevel(buttonName);
	}
	
	public void openLevel(String levelName){
		Board puz = new Board();
		int[] stars = {1,2,3};
		String type = levelName.substring(0,1);
		String sNum = levelName.substring(levelName.length() - 1, levelName.length());
		int lvlNum;
		switch (sNum){
		case "1":
			lvlNum = 1;
			break;
		case "2":
			lvlNum = 2;
			break;
		case "3":
			lvlNum = 3;
			break;
		case "4":
			lvlNum = 4;
			break;
		case "5":
			lvlNum = 5;
			break;
		default:
			System.out.println(sNum + " has no associated level");
			break;
		}
		if (type == "p"){
			PuzzleLevel level = new PuzzleLevel(stars , puz, 1);
			//init level
			//show level
			}

		else if (type == "l"){
			LightningLevel level = new LightningLevel();
			//init level
			//show level
		}
		else {
			ThemeLevel level = new ThemeLevel(stars , puz, 1);
			//init level
			//show level
		}
	}

}
