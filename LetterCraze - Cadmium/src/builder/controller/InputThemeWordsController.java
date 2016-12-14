package builder.controller;

import builder.model.*;
import builder.view.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextPane;

public class InputThemeWordsController implements KeyListener {
	Level lvl;
	LevelCreatorPanel levelCreatorView;
	
	public InputThemeWordsController(Level lvl, LevelCreatorPanel levelCreatorView){
		this.lvl = lvl;
		this.levelCreatorView = levelCreatorView;
	}
	
	@Override
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyChar() == KeyEvent.VK_ENTER){
			JTextPane tp = (JTextPane) ke.getSource();
			try {
		
				String word = tp.getText();
				lvl.addThemeWord(word);
				
			} catch (Exception e) {
				// just put old value back in
				tp.setText("" + lvl.getWord());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		return;
	}

}
