package builder.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builder.model.Level;
import builder.view.SelectLevelPanel;

public class LoadLevelController implements ActionListener{

	Level level = new Level();
	SelectLevelPanel slp;
	String pathName;
	
	
	public LoadLevelController(SelectLevelPanel levelSelect, String levelName, int levelNum){
		this.slp = levelSelect;
		this.pathName = "src/levels/"+ levelName + levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel contentPane = slp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "levelCreatorPanel");
		
		level.loadLevel(this.pathName);
		
	}

}
