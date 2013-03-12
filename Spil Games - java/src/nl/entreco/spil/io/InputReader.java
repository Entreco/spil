/**
 * {@link nl.entreco.spil.io.InputReader.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import nl.entreco.spil.dto.Board;
import nl.entreco.spil.exceptions.InvalidInputFormatException;


/**
 * Reads input from a text file
 * and creates a {@link Board}
 * with all values setup according
 * to the text file:
 * 
 * TEXT FILE SPECS:
 * 	#1: 	Number of cases
 * 	#2: 	N M -> dimensions of the {@link Board} N<=1 M<=100
 * 	#3:
 */
public class InputReader {
	
	/** Character used for Splitting */
	private static final String	SPACE	= " ";
	/** Sequence indicating End Of File */
	private static final String	EOF		= "0 0";
	/** Max numbers of Rows for a {@link Board} */
	private static final int	MAX_N	= 100;		// Probably a typo in the assignment: 1<=N, we use 100
	/** Max number of Columns for a {@link Board} */
	private static final int	MAX_M	= 100;
	
	/**
	 * 
	 * @param _filename : name of a file place in root dir
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Board> readInput(String _filename) throws FileNotFoundException, InvalidInputFormatException {
		// Create an ArrayList of Cases
		ArrayList<Board> cases = new ArrayList<Board>();
		
		// Create our file
		File file = new File(_filename);
		Scanner in = new Scanner(file);
		
		try {
			// Go through the input file
			int caseCounter = 0; // Keeps track how many cases we need
			// Get the number of cases
			int numCases = Integer.parseInt(in.nextLine());
			
			while (caseCounter < numCases) {
				
				// Get the number of Rows / Cols
				String line = in.nextLine().trim();
				
				// Check for EOF condition "0 0"
				if (InputReader.EOF.equals(line)) {
					break;
				}
				
				// Check the format
				String[] rowsAndColumns = line.split(InputReader.SPACE);
				int n = Integer.parseInt(rowsAndColumns[0]);
				int m = Integer.parseInt(rowsAndColumns[1]);
				
				// Constrain NxM according to the specs
				n = Math.min(InputReader.MAX_N, n);
				m = Math.min(InputReader.MAX_M, m);
				Board board = new Board(n, m);
				int rowCounter = 0;
				while (rowCounter < n) {
					line = in.nextLine();
					
					// Add single row
					board.addRow(line.trim(), rowCounter);
					rowCounter++;
				}
				// Add Board to the list
				cases.add(board);
				caseCounter++;
			}
		} catch (IllegalArgumentException e) {
			// If an exception occurs, close the reader
			// and blame it on the "Invalid format";
			in.close();
			in = null;
			throw new InvalidInputFormatException(e.getLocalizedMessage());
		}
		
		in.close();
		in = null;
		
		return cases;
	}
}
