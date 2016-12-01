package game.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import game.model.Level;
import game.model.Model;
import game.view.LevelPanel;

public class ExitLevelController  implements ActionListener {
	Model m;
	LevelPanel lp;
	
	public ExitLevelController(Model model, LevelPanel levelPanel){
		this.m = model; 
		this.lp = levelPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		JPanel contentPane = lp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.next(contentPane);

	}

}
