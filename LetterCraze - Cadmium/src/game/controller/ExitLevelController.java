package game.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import game.model.Level;
import game.model.Model;
import game.view.LevelPanel;
import game.view.LevelSelectPanel;
import game.view.LightningPanel;
/**
 * This is the exit level controller for all levels except for the lightning level
 * This relies on a button press to save score and return to the level select menu
 *
 */
public class ExitLevelController  implements ActionListener {
	Model m;
	LevelPanel lp;
	Level level;
	LevelSelectPanel lsp;
	private String levType;
	private int levNum;
	/**
	 * Constructor
	 * @param model Model
	 * @param levType String
	 * @param levNum Int
	 * @param levelPanel LevelPanel
	 * @param lsp LevelSelectPanel
	 */
	public ExitLevelController(Model model, String levType, int levNum, LevelPanel levelPanel, LevelSelectPanel lsp){
		this.m = model;
		this.levType = levType;
		this.levNum = levNum;
		this.lp = levelPanel;
		this.lsp = lsp;
	}
	/**
	 * Returns to the level select panel
	 */
	public void actionPerformed(ActionEvent e) {
		this.level = this.m.getSpecificLevel(levType, levNum);
		JPanel contentPane = lp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "levelSelectPanel");
        
        if (level.getMostStars() > 0) {
        	lsp.updateStars(level);
        	level.setIsUnlocked(true);
        	if (level.getLevelNumber() < 5) {
        		Level nextLevel = this.m.getSpecificLevel(levType, levNum+1);
        		if (!nextLevel.getIsUnlocked())
        			lsp.unlockNext(level);
        	}
        }
        
    	if (levType == "lightning") {
    		((LightningPanel) lp).endLevel();
    		((LightningPanel) lp).resetLightning();
    	}
    	
	}

}
