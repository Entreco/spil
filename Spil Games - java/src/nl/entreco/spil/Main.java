package nl.entreco.spil;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import nl.entreco.spil.dto.Board;
import nl.entreco.spil.exceptions.InvalidInputFormatException;
import nl.entreco.spil.io.InputReader;

/**
 * {@link .Main.java}
 *
 * @author Entreco © Entreco - 2013
 */
/**
 *
 */
public class Main {
	
	/****************************************
	 * Debug Settings
	 ***************************************/
	
	/** Shows all println Messages */
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
		} catch (FileNotFoundException e) {
			if (Main.DEBUG) {
				e.printStackTrace();
			}
			System.err.println("file not found");
		} catch (InvalidInputFormatException e) {
			if (Main.DEBUG) {
				e.printStackTrace();
			}
			System.err.println("file has an invalid format");
		}
		
		// All Boards are now parsed, let's solve them
		for (Board board : cases) {
			System.out.println(board.findBiggestBlob());
		}
	}
}
