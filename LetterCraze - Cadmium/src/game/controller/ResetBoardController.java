package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.model.Level;
import game.model.Model;
import game.undo.UndoManager;
import game.view.LevelPanel;
/**
 * Resetting the board removes existing tile information and repopulates existing squares with new random tiles
 *
 */
public class ResetBoardController implements ActionListener{
	Level level;
	LevelPanel levPanel;
	Model m;
	private String levType;
	private int levNum;
/**
 * Constructor
 * @param m Model
 * @param levType String
 * @param levNum Int
 * @param lp LevelPanel
 */
	public ResetBoardController(Model m, String levType, int levNum, LevelPanel lp) {
		this.m = m;
		this.levType = levType;
		this.levNum = levNum;
		this.levPanel = lp;
	}
/**
 * Uses undo to clear the entire stack and refresh the board
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.level = this.m.getSpecificLevel(levType, levNum);
		UndoManager mgr = UndoManager.instance();
		for (int i = 0; i < mgr.getSizeOfStack(); i++) {
			mgr.removeLastMove();
		}
		level.resetLevel();
		levPanel.refresh();
		levPanel.repaint();
	}
}