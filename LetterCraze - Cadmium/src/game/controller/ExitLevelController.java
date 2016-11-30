package game.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import game.model.Level;
import game.view.LevelPanel;

public class ExitLevelController  implements ActionListener {
	Level lvl;
	LevelPanel lp;
	
	public ExitLevelController(Level level, LevelPanel levelPanel){
		this.lvl = level; 
		this.lp = levelPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = lp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.next(contentPane);

	}

}
