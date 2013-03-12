/**
 * {@link nl.entreco.spil.exceptions.InvalidInputFormatException.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.exceptions;


/**
 *
 */
public class InvalidInputFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2470570028310313571L;
	
	/****************************************
	 * CONSTRUCTORS
	 ***************************************/

	/** Simple constructor
	 * 
	 * @param msg the error message
	 */
	public InvalidInputFormatException(String msg) {
		super(msg);
	}
}
