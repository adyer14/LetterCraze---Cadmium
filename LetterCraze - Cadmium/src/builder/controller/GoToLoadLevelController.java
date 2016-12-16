package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.model.*;
import builder.view.*;

public class GoToLoadLevelController implements ActionListener{
	BuilderApplication app;
	
	public GoToLoadLevelController(BuilderApplication app){
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 1; i < 6; i++) {
			app.getLoadLevelPanel().getPuzzleButton(i).setEnabled(app.getLoadLevelPanel().doesFileExist("PUZZLE", i));
			app.getLoadLevelPanel().getLightningButton(i).setEnabled(app.getLoadLevelPanel().doesFileExist("LIGHTNING", i));
			app.getLoadLevelPanel().getThemeButton(i).setEnabled(app.getLoadLevelPanel().doesFileExist("THEME", i));
		}
		
		JPanel contentPane = app.getMainMenuPanel().getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "loadLevelPanel");
	}
}
