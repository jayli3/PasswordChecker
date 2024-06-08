/**
 * The NoDigitException class represents an exception that is thrown when a 
 * password does not contain any digit characters.
 * This exception indicates that the password fails to meet the requirement of 
 * having at least one digit character.
 * 
 * @author JLi
 *
 */

public class NoDigitException extends Exception {
	public NoDigitException() {
		/**
	     * Constructs a new NoDigitException with a default error message.
	     */
		super("The password must contain at least one digit");
	}
}
