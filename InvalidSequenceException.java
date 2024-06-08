/**
 * The InvalidSequenceException class represents an exception that is thrown 
 * when a password contains more than two of the same character in sequence.
 * This exception indicates that the password violates the rule of having 
 * more than two of the same character consecutively.
 * 
 * @author JLi
 *
 */

public class InvalidSequenceException extends Exception{
	public InvalidSequenceException() {
		/**
	     * Constructs a new InvalidSequenceException with a default error message.
	     */
		super("The password cannot contain more than two of the same character in sequence.");
	}
}
