package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.model.*;
import builder.view.*;

public class GoToDeleteLevelController implements ActionListener{
	BuilderApplication app;
	
	public GoToDeleteLevelController(BuilderApplication app){
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 1; i < 6; i++) {
			app.getDeleteLevelPanel().getPuzzleButton(i).setEnabled(app.getDeleteLevelPanel().doesFileExist("PUZZLE", i));
			app.getDeleteLevelPanel().getLightningButton(i).setEnabled(app.getDeleteLevelPanel().doesFileExist("LIGHTNING", i));
			app.getDeleteLevelPanel().getThemeButton(i).setEnabled(app.getDeleteLevelPanel().doesFileExist("THEME", i));
		}
		
		JPanel contentPane = app.getMainMenuPanel().getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "deleteLevelPanel");
	}
}
