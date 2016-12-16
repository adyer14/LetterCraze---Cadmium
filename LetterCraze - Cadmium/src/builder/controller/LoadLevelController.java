package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.model.Level;
import builder.view.BuilderApplication;
import builder.view.SelectLevelPanel;

public class LoadLevelController implements ActionListener{

	Level level = new Level();
	BuilderApplication app;
	String pathName;
	
	
	public LoadLevelController(BuilderApplication app, String levelName, int levelNum){
		this.app = app;
		this.pathName = "src/levels/"+ levelName + levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel contentPane = app.getLoadLevelPanel().getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "levelCreatorPanel");
		
		level = level.loadLevel(this.pathName);
		app.getLevelCreatorPanel().loadIn(level);
		
	}

}
