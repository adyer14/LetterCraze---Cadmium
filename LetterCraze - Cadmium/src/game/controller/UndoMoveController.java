package game.controller;

import game.model.Level;
import game.model.Move;
import game.undo.UndoManager;
import game.view.LevelPanel;
/**
 * Undo move allows a game to return to a previous state
 *
 */
public class UndoMoveController {
	Level level;
	LevelPanel levPanel;
/**
 * Constructor
 * @param l Level
 * @param lp LevelPanel
 */
	public UndoMoveController(Level l, LevelPanel lp) {
		this.level = l;
		this.levPanel = lp;
	}
/**
 * Calls an instance of UndoManager
 * @return boolean
 */
	public boolean process(){
		UndoManager mgr = UndoManager.instance();

		// see if there is anything that can be undone
		Move m = mgr.removeLastMove();
		if (m == null) { return false; }
		
		// now complete the request, if possible, and update GUI and model
		if (!m.undoMove()) {
			return false;
		}
		
		// refresh GUI with new information
		levPanel.refresh();
		
		return true;
	}
}