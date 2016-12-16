package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import game.model.Model;
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
        
        if (lvlType == "lightning") {
        	Timer timer = app.getLightningPanel(lvlNum).getTimer();
        	timer.start();
        }
	}

}
