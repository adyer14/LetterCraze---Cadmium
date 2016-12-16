package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.view.*;

/**
 * Controller for navigating from the level creator view to the main menu
 * @param lcp Level Creator Panel to display once a level is exited
 */
public class ExitLevelController  implements ActionListener {
	LevelCreatorPanel lcp;
	
	public ExitLevelController( LevelCreatorPanel levelCreatorPanel){
		this.lcp = levelCreatorPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = lcp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "mainMenuPanel");
	}
  
}
