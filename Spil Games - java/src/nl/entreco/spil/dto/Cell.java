/**
 * {@link nl.entreco.spil.dto.Cell.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.dto;


/**
 * A single cell
 */
public class Cell {
	
	/****************************************
	 * FIELDS
	 ***************************************/
	private int			mRow;
	private int			mCol;
	private char		mValue;
	private boolean		mIsVisited	= false;
	
	/** A Cell can only be part of a single {@link Blob} */
	private static Blob	mBlob		= null;
	
	/****************************************
	 * CONSTRUCTORS
	 ***************************************/
	
	/**
	 * Create a single cell.
	 * @param c character, has to be 0 or 1
	 */
	public Cell(char c, int row, int col) {
		if (!('1' == c || '0' == c)) { throw new IllegalArgumentException("Char has to be 0 or 1"); }
		mValue = c;
		mRow = row;
		mCol = col;
	}
	
	/****************************************
	 * GETTERS && SETTERS
	 ***************************************/
	
	/**
	 * 
	 * @return the row of this cell
	 */
	public int getRow() {
		return mRow;
	}
	
	/**
	 * @return the col of this cell
	 */
	public int getCol() {
		return mCol;
	}
	
	/**
	 * 
	 * @return true if the value == '1', false otherwise
	 */
	public boolean isEmpty() {
		return mValue == '0';
	}
	
	/** Store the visited state
	 * 
	 * @param _visited
	 */
	public void setVisited(boolean _visited) {
		mIsVisited = _visited;
	}
	
	/**
	 * @return true, if this cell was already visited
	 */
	public boolean isVisited() {
		return mIsVisited;
	}
	
	public Blob getBlob() {
		return Cell.mBlob;
	}
	
	public void setBlob(Blob blob) {
		Cell.mBlob = blob;
	}
	
	/****************************************
	 * UTILS
	 ***************************************/

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + mValue;
	}
}
