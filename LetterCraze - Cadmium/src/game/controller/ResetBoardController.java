package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import game.model.Level;
import game.view.LevelPanel;

public class ResetBoardController implements ActionListener{
	Level level;
	LevelPanel levPanel;

public ResetBoardController(Level l, LevelPanel lp) {
	this.level = l;
	this.levPanel = lp;
}


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}