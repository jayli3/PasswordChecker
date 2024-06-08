/**
 * The NoLowerAlphaException class represents an exception that is thrown when a 
 * password does not contain any lowercase alphabetic characters.
 * This exception indicates that the password fails to meet the requirement of 
 * having at least one lowercase alphabetic character.
 * 
 * @author JLi
 *
 */
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		/**
	     * Constructs a new NoLowerAlphaException with a default error message.
	     */
		super("The password must contain at least one lowercase alphabetic character");
	}
}
