package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
		
		if (updateAllValues()) 
			lvl.saveLevel();
		else
			System.err.println("Theme has either not enough or too many words");
	}
/**
 * updateAllValues takes values from the creator and ensures that they are valid
 * Sets star values, titles and so on
 */
	public boolean updateAllValues () {
		int[] tempStarValues = new int[3];
		String levType = lvl.getLevelType();
		int numLet = 0;
			if (levType == "THEME") {
				lvl.setThemeName(lcp.getThemeNameTextField().getText());
				lvl.setThemeWords(lcp.getThemeWordsTextPane().getText());
				List<String> items = Arrays.asList(lvl.getThemeWords().split("\\n"));
				int numWords = items.size();
				System.out.println("numWords: " + numWords);
				for (int i = 0; i < numWords; i++) {
					numLet = numLet + items.get(i).length();
				}
				tempStarValues[2] = numWords;
				tempStarValues[1] = numWords-1;
				tempStarValues[0] = numWords-2;
				lvl.setStarValues(tempStarValues);
				if (numWords < 3 || numLet > 36)
					return false;
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
		return true;
	}
}
