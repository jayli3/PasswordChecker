/**
 * WeakPasswordException class thrown when a password is considered weak due to 
 * containing fewer than 10 characters.
 *
 * @author JLi
 */

public class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		/**
		 * Constructs a new WeakPasswordException with the default detail message.
		 */
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
}
