package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.view.*;
//import builder.model.*;

public class ExitLevelController  implements ActionListener {
	//Level level;
	LevelCreatorPanel lcp;
	//MainMenu mainMenu;
	//MainMenuPanel mainMenuView;
	
	public ExitLevelController(/*Level lvl,*/ LevelCreatorPanel levelCreatorPanel){
		//this.level = lvl; 
		this.lcp = levelCreatorPanel;
		//this.mainMenu = mm;
		//this.mainMenuView = mmv;
	}
	
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = lcp.getContentPane();
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);

	}
  
}
