/**
 * The NoSpecialCharacterException class represents an exception that is thrown 
 * when a password does not contain any special characters.
 * This exception indicates that the password fails to meet the requirement of 
 * having at least one special character.
 * 
 * @author JLi
 *
 */
public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException() {
		/**
	     * Constructs a new NoSpecialCharacterException with a default error message.
	     */
		super("The password must contain at least one special character");
	}
}
