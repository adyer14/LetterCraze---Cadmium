package game.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import game.model.Level;
import game.view.BoardPanel;
import game.view.TilePanel;

public class ChooseWordController implements MouseListener {

	Level level;
	BoardPanel bp;
	private boolean isWordBeingCreated = false;
	
	public ChooseWordController(/*Level l, */BoardPanel bp){
		//this.level = l;
		this.bp = bp;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// set flag, can start capturing values of tiles
		isWordBeingCreated = true;
		
		// update graphics
		JButton selectedButton = (JButton) arg0.getSource();
		TilePanel tp = (TilePanel)selectedButton.getParent();
		tp.setSelected();
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		//if mousePressed flag set add letter to word
		
		// update graphics
		JButton selectedButton = (JButton) arg0.getSource();
		TilePanel tp = (TilePanel)selectedButton.getParent();
		if (isWordBeingCreated) {
			tp.setSelected();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//finish word hand off to check word
		isWordBeingCreated = false;
		
		// reset graphics
		bp.resetTiles();	
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// keep the button selected after exiting container
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
