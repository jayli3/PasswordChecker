/**
 * The NoUpperAlphaException class represents an exception that is thrown when a 
 * password does not contain any uppercase alphabetic characters.
 * This exception indicates that the password fails to meet the requirement of 
 * having at least one uppercase alphabetic character.
 * 
 * @author JLi
 *
 */

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		/**
	     * Constructs a new NoUpperAlphaException with a default error message.
	     */
		super("The password must contain at least one uppercase alphabetic character");
	}
}
