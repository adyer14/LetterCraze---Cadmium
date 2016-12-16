package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.model.Level;
import game.model.Model;
import game.undo.UndoManager;
import game.view.LCApplication;
/**
 * This controller responds to a button press to select a level to initialize for play
 *
 */
public class LevelSelectController implements ActionListener {

	Model m;
	LCApplication app;
	String lvlType;
	int lvlNum;
	Level level;
	/**
	 * Constructor
	 * @param model
	 * @param application
	 * @param levType
	 * @param levNum
	 */
	public LevelSelectController(Model model, LCApplication application, String levType, int levNum) {
		this.m = model;
		this.app = application;
		this.lvlType = levType;
		this.lvlNum = levNum;
	}
/**
 * display selected level
 */
	public void actionPerformed(ActionEvent e) {
		
		String levelID = lvlType + "Panel" + lvlNum;
		JPanel contentPane = app.getLevelSelectPanel().getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, levelID);
        
        this.level = this.m.getSpecificLevel(lvlType, lvlNum);

		level.resetLevel();
		switch (lvlType) {
		case "puzzle":
			app.getPuzzlePanel(lvlNum).refresh();
			app.getPuzzlePanel(lvlNum).repaint();
			break;
		case "lightning":
			app.getLightningPanel(lvlNum).refresh();
			app.getLightningPanel(lvlNum).repaint();
			break;
		case "theme":
			app.getThemePanel(lvlNum).refresh();
			app.getThemePanel(lvlNum).repaint();
			break;
		}
		
        
        if (lvlType == "lightning") {
        	Timer timer = app.getLightningPanel(lvlNum).getTimer();
        	timer.start();
        }
	}

}
