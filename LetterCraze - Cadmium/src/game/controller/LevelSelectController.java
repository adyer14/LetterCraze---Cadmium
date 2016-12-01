package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JPanel;
import game.model.Model;
import game.view.LevelSelectPanel;

public class LevelSelectController implements ActionListener {

	Model m;
	LevelSelectPanel lsp;
	String lvlType;
	int lvlNum;
	
	public LevelSelectController(Model model, LevelSelectPanel levelSelectPanel, String levType, int levNum) {
		this.m = model;
		this.lsp = levelSelectPanel;
		this.lvlType = levType;
		this.lvlNum = levNum;
	}

	public void actionPerformed(ActionEvent e) {
		
		String levelID = lvlType + "Panel" + lvlNum;
		JPanel contentPane = lsp.getContentPane();
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, levelID);
		
		//It was not getting through to the logic in the open level function
		//I don't think the board gets added
		//Board puz = new Board();
/*
		int[] stars = {1,2,3};
		PuzzleLevel level = new PuzzleLevel(stars , puz, 1);
		LevelPanel levelpanel = new LevelPanel(m);
		this.app.getContentPane().add(levelpanel);
		lvlSlctPnl.setVisible(false);
		levelpanel.setVisible(true);
	*/
		
//	    source = (JButton) e.getSource();
//	    String buttonName = source.getName();
//	    openLevel(buttonName);
	}
	
	
	
/*	public void openLevel(String levelName){
		Board puz = new Board();
		int[] stars = {1,2,3};
		String type = levelName.substring(0,1);
		String sNum = levelName.substring(levelName.length() - 1, levelName.length());
		int lvlNum;
		//this might work
//		PuzzleLevel level = new PuzzleLevel(stars , puz, 1);
//		LevelPanel levelpanel = new LevelPanel(m);
//		this.app.getContentPane().add(levelpanel);
//		lvlSlctPnl.setVisible(false);
//		levelpanel.setVisible(true);
		
		switch (sNum){
		case "1":
			lvlNum = 1;
			break;
		case "2":
			lvlNum = 2;
			break;
		case "3":
			lvlNum = 3;
			break;
		case "4":
			lvlNum = 4;
			break;
		case "5":
			lvlNum = 5;
			break;
		default:
			System.out.println(sNum + " has no associated level");
			break;
		}
		if (type == "p"){
//			PuzzleLevel level = new PuzzleLevel(stars , puz, 1);
//			LevelPanel levelpanel = new LevelPanel(m);
//			this.app.getContentPane().add(levelpanel);
//			lvlSlctPnl.setVisible(false);
//			levelpanel.setVisible(true);
			
			}

		else if (type == "l"){
//			LightningLevel level = new LightningLevel();
//			//init level
//			//show level
		}
		else {
//			ThemeLevel level = new ThemeLevel(stars , puz, 1);
//			//init level
//			//show level
		}
	}*/

}
