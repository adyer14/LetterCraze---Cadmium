package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.view.*;

/**
 * Controller for navigating from the level select to the main menu
 *
 */
public class ReturnToMainMenuController  implements ActionListener {
	SelectLevelPanel slp;
	
	public ReturnToMainMenuController(SelectLevelPanel levelCreatorPanel){
		this.slp = levelCreatorPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = slp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "mainMenuPanel");
	}
  
}
