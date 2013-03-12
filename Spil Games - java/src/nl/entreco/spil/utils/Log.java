/**
 * {@link nl.entreco.spil.utils.Log.java}
 *
 * @author Entreco © Entreco - 2013
 */
package nl.entreco.spil.utils;

import nl.entreco.spil.Main;


/**
 * Simple Wrapper to use
 * for Logging.
 * 
 * Depends on {@link Main.DEBUG}
 * for the actual logging.
 * 
 * {@see Log#log(String)}
 */
public class Log {
	
	/**
	 * Uses System.out.println()
	 * only if {@link Main.DEBUG} is
	 * set to true.<br />
	 * <br />
	 * @param msg the message to log
	 */
	public static void log(String msg) {
		if (Main.DEBUG) {
			System.out.println(msg);
		}
	}
}
