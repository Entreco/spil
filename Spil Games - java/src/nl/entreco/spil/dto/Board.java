/**
 * {@link nl.entreco.spil.dto.Board.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.dto;

import java.util.ArrayList;
import java.util.List;

import nl.entreco.spil.exceptions.InvalidInputFormatException;
import nl.entreco.spil.utils.Log;

/**
 * Class representing a Board
 */
public class Board {
	
	/****************************************
	 * FIELDS
	 ***************************************/
	
	/** Number of Rows on the board */
	private int	mRows;
	/** Number of Columns on the board */
	private int	mCols;
	
	/** Datastructure holding all {@link Cell} 's */
	private Cell[][]	mCells;
	
	/****************************************
	 * CONSTRUCTORS
	 ***************************************/
	
	/**
	 * Constructor<br />
	 * Creates an 2-dimensional array of
	 * {@link Cell} objects.
	 * 
	 * @param _rows number of rows
	 * @param _cols number of columns
	 */
	public Board(int _rows, int _cols) {
		mRows = _rows;
		mCols = _cols;
		mCells = new Cell[mRows][mCols];
	}
	
	/** Adds a single row to the board.
	 *  Replaces any previous values that
	 *  might be present at this row
	 * 
	 * @param line formatted without spaces e.g. 110010
	 * @param row index of the row to insert the elements
	 * @throws InvalidInputFormatException
	 */
	public void addRow(String line, int row) throws InvalidInputFormatException {
		if (line.length() != mCols) { throw new InvalidInputFormatException("m != line.length()"); }
		Cell[] element = mCells[row];
		for (int cols = 0; cols < mCols; cols++) {
			element[cols] = new Cell(line.charAt(cols), row, cols);
		}
	}
	
	/**
	 * Uses a Recursive function
	 * to
	 * @return the size of the biggest blob in the board
	 */
	public int findBiggestBlob() {
		
		// First, reset any potential visited states
		resetVisitedState();
		
		// Array to store potential blobs
		List<Integer> blobs = new ArrayList<Integer>();
		// Store the biggest blob
		int biggestBlob = 0;
		// Loop through all cells
		for (Cell[] mCell : mCells) {
			for (Cell element : mCell) {
				// If already visited -> skip
				if (element.isVisited()) {
					continue;
				}
				
				
				if (!element.isEmpty()) {
					Blob blob = new Blob();
					// Add cell to the blob
					blob.add(element);
					element.setVisited(true);
					// Recursive call
					checkNeighbours(element, blob);
					int blobSize = blob.getBlobSize();
					blobs.add(blobSize);
					if (blobSize > biggestBlob) {
						biggestBlob = blobSize;
					}
				}
			}
		}
		return biggestBlob;
	}
	
	/**
	 * Check all neighboring cells to
	 * see if they are connected to the blob
	 * 
	 * NOTE: this is a recursive void
	 * 
	 * @param cell
	 * @param blob
	 */
	private void checkNeighbours(Cell cell, Blob blob) {
		
		int r = cell.getRow();
		int c = cell.getCol();
		
		Log.log("checking checkNeighbours of(" + r + "," + c + ")");
		
		/** Top Left */
		checkCell(getCell(r - 1, c - 1), blob);
		/** Top */
		checkCell(getCell(r - 1, c), blob);
		/** Top Right */
		checkCell(getCell(r - 1, c + 1), blob);
		/** Left */
		checkCell(getCell(r, c - 1), blob);
		/** Right */
		checkCell(getCell(r, c + 1), blob);
		/** Bottom Left */
		checkCell(getCell(r + 1, c - 1), blob);
		/** Bottom */
		checkCell(getCell(r + 1, c), blob);
		/** Bottom Right */
		checkCell(getCell(r + 1, c + 1), blob);
	}
	
	/**
	 * Check a single cell to see if it belongs
	 * to a blob
	 * @param c cell to check
	 * @param b blob
	 */
	private void checkCell(Cell c, Blob b) {
		if (c == null) { return; }
		if (b == null) { throw new IllegalArgumentException("Something wrong with my logic"); }
		
		Log.log("checking cell(" + c.getRow() + "," + c.getCol() + ")");
		if (c.isVisited()) {
			return;
		}
		
		// Set visited state
		c.setVisited(true);
		if (!c.isEmpty()) {
			Log.log("bingo cell(" + c.getRow() + "," + c.getCol() + ") -> checkNeighbours()");
			b.add(c);
			c.setBlob(b);
			checkNeighbours(c, b);
		}
	}
	
	/****************************************
	 * UTILS
	 ***************************************/
	
	/**
	 * Get Cell at
	 * @param r row on the board
	 * @param c column on the board
	 * @return the cell at the specified indices or null if we're out of bounds
	 */
	private Cell getCell(int r, int c) {
		if (r >= 0 && r < mRows && c >= 0 && c < mCols) {
			if (mCells != null) {
				Cell[] row = mCells[r];
				return row[c];
			}
		}
		return null;
	}
	
	/**
	 * Helper function to reset a boards
	 * original state && will remove
	 * any references to 'old' Blobs
	 * 
	 */
	private final void resetVisitedState() {
		for (Cell[] mCell : mCells) {
			for (Cell element : mCell) {
				element.setVisited(false);
				element.setBlob(null);
			}
		}
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board:\n");
		for (Cell[] mCell : mCells) {
			for (Cell element : mCell) {
				builder.append(element);
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
