/**
 * The UnmatchedException class represents an exception that is thrown when two 
 * passwords do not match.
 * This exception occurs when a user attempts to confirm a password that does 
 * not match the original password.
 * 
 * @author JLi
 *
 */
public class UnmatchedException extends Exception {
	public UnmatchedException() {
		/**
		 * Constructs a new UnmatchedException with a default error message.
		 */
		super("Passwords do not match");
	}
}
