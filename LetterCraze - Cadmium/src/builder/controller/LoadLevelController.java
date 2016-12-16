package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.model.*;
import builder.view.*;

public class LoadLevelController implements ActionListener{
	MainMenuPanel mmp;
	
	public LoadLevelController(MainMenuPanel mainMenuView){
		this.mmp = mainMenuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = mmp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "loadLevelPanel");
	}
}
