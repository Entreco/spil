/**
 * {@link nl.entreco.spil.dto.Blob.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * A Blob represents a chain of {@link Cell}'s<br />
 * Cells inside a Blob can be connected:<br />
 * 	- Horizontally<br />
 * 	- Vertically<br />
 * 	- Diagonally<br />
 * 
 */
public class Blob {
	
	/** Reference to all cells in the Blob */
	private List<Cell>	mConnectedCells	= new ArrayList<Cell>();
	
	/****************************************
	 * CONSTRUCTORS
	 ***************************************/
	
	/** Empty Constructor */
	public Blob() {
	}
	
	
	/** Add a cell to the connected compontents
	 * of this Blob<br />
	 * @param cell to add to this blob
	 */
	public void add(Cell cell) {
		mConnectedCells.add(cell);
	}
	
	/**
	 * @return the number of connected Cells
	 */
	public int getBlobSize() {
		return mConnectedCells.size();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blob(size:" + mConnectedCells.size() + ")";
	}
}
