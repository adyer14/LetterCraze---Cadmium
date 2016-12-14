package builder.controller;

import builder.model.*;
import builder.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetLevelController implements ActionListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public ResetLevelController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		lvl.resetLevel();
		//JPanel panel = levelCreatorView.getContentPane();
		levelCreatorView.reset();
		levelCreatorView.repaint();
	}
	
}
