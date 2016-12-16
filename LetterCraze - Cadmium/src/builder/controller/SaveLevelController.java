package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import builder.model.*;
import builder.view.*;

/**
 * Controller to save a level to a file.
 *
 */
public class SaveLevelController implements ActionListener {
	Level lvl;
	LevelCreatorPanel lcp;

	public SaveLevelController(Level lvl, LevelCreatorPanel levelCreatorPanel){
		this.lvl = lvl;
		this.lcp = levelCreatorPanel;
	}

	@Override
	public void actionPerformed(ActionEvent ae){
		updateAllValues();
		try{
			lvl.saveLevel();

		} catch (Exception e){
			System.out.println(e);
		}
	}
/**
 * updateAllValues takes values from the creator and ensures that they are valid
 * Sets star values, titles and so on
 */
	public void updateAllValues() {
		int[] tempStarValues = new int[3];
		String levType = lvl.getLevelType();
		try {
			if (levType == "THEME") {
				lvl.setThemeName(lcp.getThemeNameTextField().getText());
				lvl.setThemeWords(lcp.getThemeWordsTextPane().getText());
			}
			else {
				tempStarValues[0] = Integer.parseInt(lcp.getStar1TextField().getText());
				tempStarValues[1] = Integer.parseInt(lcp.getStar2TextField().getText());
				tempStarValues[2] = Integer.parseInt(lcp.getStar3TextField().getText());
				lvl.setStarValues(tempStarValues);
				if (lvl.getLevelType() == "PUZZLE")
					lvl.setNumMoves(Integer.parseInt(lcp.getMovesTextField().getText()));
				if (lvl.getLevelType() == "LIGHTNING")
					lvl.setTime(Integer.parseInt(lcp.getTimeTextField().getText()));
			}
		} catch(NumberFormatException e){
			System.out.println("Not all fields have been filled");
		}

	}
}
