package game.undo;

import java.util.Stack;
import game.model.Move;

public class UndoManager {
	/** UndoManager code lifted straight from Professor Heineman's TrivialEBC project */
	
	static UndoManager instance = null;
	
	/** Not visible outside of this package. */
	UndoManager() {
		
	}
	
	/** Undo stack. Moves are pushed onto here as they are undo. */
	Stack<Move> undoStack = new Stack<Move>();
	
	public static UndoManager instance() {
		if (instance == null) {
			instance = new UndoManager();
		}
		
		return instance;
	}

	/**
	 * Record the move which can be undone in the future.
	 * 
	 * @param move
	 */
	public void recordMove(Move move) {
		undoStack.add(move);
	}
	
	/**
	 * Prepare for undo by getting last move.
	 */
	public Move removeLastMove() {
		if (undoStack.isEmpty()) { return null; }
		return undoStack.pop();
	}
	
	public Stack<Move> getUndoStack() {
		return undoStack;
	}
	
	public int getSizeOfStack() {
		return undoStack.size();
	}
}
