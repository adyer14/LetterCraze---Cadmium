package game.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import game.model.Level;
import game.model.Model;
import game.view.LevelPanel;
import game.view.LevelSelectPanel;

public class ExitLevelController  implements ActionListener {
	Model m;
	LevelPanel lp;
	Level level;
	LevelSelectPanel lsp;
	private String levType;
	private int levNum;
	
	public ExitLevelController(Model model, String levType, int levNum, LevelPanel levelPanel, LevelSelectPanel lsp){
		this.m = model;
		this.levType = levType;
		this.levNum = levNum;
		this.lp = levelPanel;
		this.lsp = lsp;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.level = this.m.getSpecificLevel(levType, levNum);

		JPanel contentPane = lp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "levelSelectPanel");
        
        lsp.updateStars(level);
        if ((level.getMostStars() > 0) && (level.getLevelNumber() < 5)) 
        	lsp.unlockNext(level);
	}

}
