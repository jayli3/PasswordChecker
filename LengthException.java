/**
 * The LengthException class represents an exception that is thrown when a 
 * password does not meet the minimum length requirement.
 * This exception indicates that the password fails to meet the requirement of 
 * being at least 6 characters long.
 * 
 * @author JLi
 *
 */
public class LengthException extends Exception {
	public LengthException() {
		/**
	     * Constructs a new LengthException with a default error message.
	     */
		super("The password must be at least 6 characters long");
	}
}
