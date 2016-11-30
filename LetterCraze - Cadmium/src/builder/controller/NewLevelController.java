package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import builder.view.*;
//import builder.model.*;

public class NewLevelController implements ActionListener {
	//BuilderApplication bApp;
	//Level level;
	//LevelCreatorPanel levelCreatorView;
	//MainMenu mainMenu;
	MainMenuPanel mmv;
	
	public NewLevelController(/*Level lvl, LevelCreatorPanel lcv, MainMenu mm,*/ MainMenuPanel mainMenuPanel){
		//this.level = lvl;
		//this.levelCreatorView = lcv;
		//this.mainMenu = mm;
		this.mmv = mainMenuPanel;
		//this.bApp = bApp;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = mmv.getContentPane();
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
 
		//mainMenuView.setVisible(false);
		//mainMenuView.invalidate();
		
		//bApp.getLevelCreatorPanel().setVisible(true);
		//levelCreatorView.validate();
	}
}
