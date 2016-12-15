package builder.controller;

import builder.model.*;
import builder.view.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
/**
 * Controller for getting words from the themeWordsTextPane
 *
 */
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
		
				//lvl.setThemeWords(new ArrayList<String>());
				
				// make sure the words in the JTextPane are the same in the list by renewing the list
				//for(String s: tp.getText().split("\\n")) {
				//	lvl.addThemeWord(s);
				//}
				
			} catch (Exception e) {
				// just put old value back in
				//tp.setText("" + lvl.getWord());
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
