package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.Level;
import builder.view.SelectLevelPanel;

public class DeleteLevelController implements ActionListener{

	Level level = new Level();
	SelectLevelPanel slp;
	String pathName;
	String levType;
	int levNum;
	
	
	public DeleteLevelController(SelectLevelPanel levelSelect, String levelName, int levelNum){
		this.slp = levelSelect;
		this.levType = levelName;
		this.levNum = levelNum;
		this.pathName = "src/levels/" + levelName + levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		level.deleteLevel(this.pathName);
		System.out.println("goodbye forever");
		switch (levType) {
		case "PUZZLE": slp.getPuzzleButton(levNum).setEnabled(false);
		break;
		case "LIGHTNING": slp.getLightningButton(levNum).setEnabled(false);
		break;
		case "THEME": slp.getThemeButton(levNum).setEnabled(false);
		break;
		default:
            throw new IllegalArgumentException("What the hell sort of level type did you input");

		}
		
		
	}

}