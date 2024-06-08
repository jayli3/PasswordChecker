import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for checking password validity and related operations
 * 
 * @author JLi
 *
 */

public class PasswordCheckerUtility {	
	
	/**
     * Checks if the given password is valid.
     *
     * @param password the password to be checked
     * @return true if the password is valid, false otherwise
     * @throws LengthException if the password length is less than 6 characters
     * @throws NoUpperAlphaException if the password contains no uppercase alphabetic character
     * @throws NoLowerAlphaException if the password contains no lowercase alphabetic character
     * @throws NoDigitException if the password contains no digit
     * @throws NoSpecialCharacterException if the password contains no special character
     * @throws InvalidSequenceException if the password contains more than two of the same character in sequence
     */
	public static boolean isValidPassword(String password) throws LengthException,
		NoUpperAlphaException, NoLowerAlphaException, NoDigitException, 
		NoSpecialCharacterException, InvalidSequenceException {
		try {
			return isValidLength(password) && hasUpperAlpha(password) 
					&& hasLowerAlpha(password) && hasDigit(password) && 
					hasSpecialChar(password) && !NoSameCharInSequence(password);
		} catch (LengthException e){
			throw new LengthException();
		} catch (NoUpperAlphaException e) {
			throw new NoUpperAlphaException();
		} catch (NoLowerAlphaException e) {
			throw new NoLowerAlphaException();
		} catch (NoDigitException e) {
			throw new NoDigitException();
		} catch (NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException();
		} catch (InvalidSequenceException e) {
			throw new InvalidSequenceException();
		}
	}
	
	/**
     * Checks if the password is weak (between 6 and 9 characters).
     *
     * @param password the password to be checked
     * @return true if the password is weak, false otherwise
     * @throws WeakPasswordException if the password length is between 6 and 9 characters, 
     *     although the password may be otherwise valid
     */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		try {
			if (hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException();
			}
			return !isValidPassword(password);
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException |
	             NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) {
	        return false;
		}
	}
	
	/**
     * Retrieves a list of invalid passwords from the provided list.
     *
     * @param passwords the list of passwords to be checked
     * @return an ArrayList containing invalid passwords and associated error messages
     */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for (String password : passwords) {
			try {
				isValidPassword(password);
				isWeakPassword(password);
			} catch (Exception e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
	
	/**
     * Compares two passwords to check if they match.
     *
     * @param password the first password to be compared
     * @param passwordConfirm the second password to be compared
     * @throws UnmatchedException if the passwords do not match
     */
	public static void comparePasswords(String password, String passwordConfirm) 
	throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
     * Compares two passwords to check if they match.
     *
     * @param password the first password to be compared
     * @param passwordConfirm the second password to be compared
     * @return true if the passwords match, false otherwise
     */
	public static boolean comparePasswordsWithReturn(String password, 
														String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/**
     * Checks if the given password has between 6 and 9 characters.
     *
     * @param password the password to be checked
     * @return true if the password has between 6 and 9 characters, false otherwise
     */
	private static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() <= 9 && password.length() >=6) {
			return true;
		}
		return false;
	}
	
	/**
     * Checks if the given password contains at least one digit.
     *
     * @param password the password to be checked
     * @return true if the password contains at least one digit
     * @throws NoDigitException if the password contains no digit
     */
	private static boolean hasDigit(String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit((password.charAt(i)))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
     * Checks if the given password contains at least one lowercase alphabetic character.
     *
     * @param password the password to be checked
     * @return true if the password contains at least one lowercase alphabetic character
     * @throws NoLowerAlphaException if the password contains no lowercase alphabetic character
     */
	private static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
     * Checks if the given password contains at least one special character.
     *
     * @param password the password to be checked
     * @return true if the password contains at least one special character
     * @throws NoSpecialCharacterException if the password contains no special character
     */
	private static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new NoSpecialCharacterException();
        }
        return true;
	}
	
	/**
     * Checks if the given password contains at least one uppercase alphabetic character.
     *
     * @param password the password to be checked
     * @return true if the password contains at least one uppercase alphabetic character
     * @throws NoUpperAlphaException if the password contains no uppercase alphabetic character
     */
	private static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
     * Checks if the given password meets the minimum length requirement.
     *
     * @param password the password to be checked
     * @return true if the password meets the minimum length requirement
     * @throws LengthException if the password length is less than 6 characters
     */
	private static boolean isValidLength(String password) throws LengthException{
		if (password.length() < 6) {
			throw new LengthException();
		} 
		return true;
	}
	
	/**
     * Checks if the given password contains more than two of the same character in sequence.
     *
     * @param password the password to be checked
     * @return false if the password doesn't contains more than two of the same character in sequence
     * @throws InvalidSequenceException if the password contains more than two of the same character in sequence
     */
	private static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for (int i = 0; i < password.length() - 2; i++) {
			if (password.charAt(i) == password.charAt(i + 1) && 
					password.charAt(i) == password.charAt(i + 2)) {
				throw new InvalidSequenceException();
			}
		}
		return false;
	}
}
