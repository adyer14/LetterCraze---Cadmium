package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import game.model.Dictionary;
import game.model.Level;
import game.view.LevelPanel;

public class ChooseWordController implements MouseListener {

	Level level;
	LevelPanel levPanel;
	Dictionary dict;
	
	public ChooseWordController(Level l, LevelPanel lp, Dictionary dict){
		this.level = l;
		this.levPanel = lp;
		this.dict = dict;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//if mousePressed flag set add letter to word
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//none
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// set flag, can start capturing values of tiles
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//finish word hand off to check word
	}
	
	
}
