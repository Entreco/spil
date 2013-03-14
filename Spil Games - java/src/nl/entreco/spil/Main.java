package nl.entreco.spil;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import nl.entreco.spil.dto.Board;
import nl.entreco.spil.exceptions.InvalidInputFormatException;
import nl.entreco.spil.io.InputReader;

/**
 * {@link .Main.java}
 *
 * This is the entry point.
 * Requirements:
 * 	- create a valid .txt file in the root of the project
 *	
 * @author Entreco © Entreco - 2013
 */
public class Main {
	
	/****************************************
	 * Debug Settings
	 ***************************************/
	
	/** Set to true to show debug output */
	public static final boolean	DEBUG	= false;	// false in release
	
	/****************************************
	 * App Entry point:
	 * 
	 * 1) Parses a text file
	 * 2) Prints the Maximum blob size
	 ***************************************/
	public static void main(String[] args) {
		// ArrayList with all the boards
		ArrayList<Board> cases = null;
		
		// Read the input File
		try {
			
			cases = InputReader.readInput("inputs.txt");
			long start = System.currentTimeMillis();
			// All Boards are now parsed, let's solve them
			for (Board board : cases) {
				System.out.println(board.findBiggestBlob());
			}
			System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
		} catch (FileNotFoundException e) {
			System.err.println("file not found e:" + e.getLocalizedMessage());
		} catch (InvalidInputFormatException e) {
			e.printStackTrace();
			System.err.println("file has an invalid format:" + e.getLocalizedMessage());
		}
		
	}
}
