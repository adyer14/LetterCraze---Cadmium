package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import builder.model.Level;
import game.*;
import game.view.LevelPanel;

public class UndoMoveController implements ActionListener{
	Level level;
	LevelPanel levPanel;



public UndoMoveController(Level l, LevelPanel lp) {
	this.level = l;
	this.levPanel = lp;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}