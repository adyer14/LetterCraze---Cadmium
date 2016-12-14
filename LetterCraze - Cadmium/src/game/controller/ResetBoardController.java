package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.model.Level;
import game.model.Model;
import game.view.LevelPanel;

public class ResetBoardController implements ActionListener{
	Level level;
	LevelPanel levPanel;
	Model m;
	private String levType;
	private int levNum;

	public ResetBoardController(Model m, String levType, int levNum, LevelPanel lp) {
		this.m = m;
		this.levType = levType;
		this.levNum = levNum;
		this.levPanel = lp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.level = this.m.getSpecificLevel(levType, levNum);
		level.resetLevel();
		levPanel.refresh();
	}
}