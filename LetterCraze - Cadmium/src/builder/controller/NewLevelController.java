package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.view.*;

public class NewLevelController implements ActionListener {
	MainMenuPanel mmv;
	
	public NewLevelController( MainMenuPanel mainMenuPanel){
		this.mmv = mainMenuPanel;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = mmv.getContentPane();
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
	}
}
