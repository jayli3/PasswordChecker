
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> passwords = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		// Add the passwords with issues to the ArrayList
        passwords.add("PASSWORD1!"); // No lowercase alphabetic character
        passwords.add("Password!");  // No digit
        passwords.add("Pass1!?");     // Password is OK, but between 6 and 10 characters
        passwords.add("Paaass1!");   // Password has more than two of the same characters in a row
        passwords.add("ValidPass1!?");// Valid password
        passwords.add("P1!");        // Length of password is less than 6 characters
        passwords.add("password1!"); // No uppercase alphabetic character
        passwords.add("PASSWORD1!"); // No lowercase alphabetic character
        passwords.add("Password!");  // No digit
        passwords.add("Password1");  // No special character
        passwords.add("Paaass1!");   // More than 2 of the same character in sequence
        passwords.add("Pass1!");     // Weak password, 6-9 characters
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		// First test case: a password of valid length 
        String validPassword = "ValidPass1!?";
        try {
            assertTrue("Valid password should not throw an exception", 
            		PasswordCheckerUtility.isValidPassword(validPassword));
        } catch (LengthException e) {
	    	fail("Should not throw LengthException");
	    } catch (Exception e) {
        	fail("Valid password should not throw any exception");
        }

        // Second test case: a password of less than 6 characters (should throw LengthException)
        String shortPassword = "P1!";
        try {
            PasswordCheckerUtility.isValidPassword(shortPassword);
            assertTrue("Password did not throw LengthException", false);
        } catch (LengthException e) {
            assertTrue("Password shorter than 6 characters should throw LengthException", true);
        } catch (Exception e) {
        	fail("Password should throw LengthException");
        }
	}

	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		// First test case: a password with at least one uppercase alpha character
	    String validPassword = "ValidPass1!?";
	    try {
	        assertTrue("Valid password should not throw an exception",
	                PasswordCheckerUtility.isValidPassword(validPassword));
	    } catch (NoUpperAlphaException e) {
	    	fail("Should not throw NoupperAlphaException");
	    } catch (Exception e) {
	        fail("Valid password should not throw any exception");
	    }

	    // Second test case: a password with no uppercase alpha character (should throw NoUpperAlphaException)
	    String passwordNoUpper = "noupperalpha1!?";
	    try {
	        PasswordCheckerUtility.isValidPassword(passwordNoUpper);
            assertTrue("Password did not throw NoUpperAlphaException", false);
	    } catch (NoUpperAlphaException e) {
	        assertTrue("Password without uppercase alpha character should throw NoUpperAlphaException", true);
	    } catch (Exception e) {
	        fail("Password should throw NoUpperAlphaException");
	    }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		// First test case: a password with at least one lowercase alpha character
	    String validPassword = "ValidPass1!?";
	    try {
	        assertTrue("Valid password should not throw an exception",
	                PasswordCheckerUtility.isValidPassword(validPassword));
	    } catch (NoLowerAlphaException e) {
	    	fail("Should not throw NoupperLowerException");
	    }catch (Exception e) {
	        fail("Valid password should not throw any exception");
	    }

	    // Second test case: a password with no lowercase alpha character (should throw NoLowerAlphaException)
	    String passwordNoLower = "NOLOWERALPHA1!?";
	    try {
	        PasswordCheckerUtility.isValidPassword(passwordNoLower);
            assertTrue("Password did not throw NoUpperAlphaException", false);
	    } catch (NoLowerAlphaException e) {
	        assertTrue("Password without lowercase alpha character should throw NoLowerAlphaException", true);
	    } catch (Exception e) {
	        fail("Password should throw NoLowerAlphaException");
	    }
	}
	/**
	 * Test if the password has between 6 and 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		// First test case: a strong password with 10 characters
	    String strongPassword = "StrongPass1!?";
	    try {
	        assertFalse("Strong password should not be considered weak",
	                PasswordCheckerUtility.isWeakPassword(strongPassword));
	    } catch (Exception e) {
	        fail("Strong password should not throw any exception");
	    }
	    
	    // Second test case: a weak password with 7 characters (should throw WeakPasswordException)
	    String weakPassword = "WeakPaaa";
	    try {
	        PasswordCheckerUtility.isWeakPassword(weakPassword);
            assertTrue("Password did not throw WeakPasswordException", false);
	    } catch (WeakPasswordException e) {
	        assertTrue("Password with between 6 and 9 characters should throw WeakPasswordException", true);
	    } catch (Exception e) {
	        fail("Password should throw WeakPasswordException");
	    }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		// First test case: a strong password with no invalid sequence
	    String strongPassword = "StrongPass1!?";
	    try {
	        assertTrue("Strong password should not be considered weak",
	                PasswordCheckerUtility.isValidPassword(strongPassword));
	    } catch (InvalidSequenceException e) {
	    	fail("Should not throw InvalidSequenceException");	
	    } catch (Exception e) {
	        fail("Strong password should not throw any exception");
	    }

	    // Second test case: a weak password with more than 2 of the same 
	    // character in sequence (should throw InvalidSequenceException)
	    String weakPassword = "WeakPaaaass1!?";
	    try {
	        PasswordCheckerUtility.isValidPassword(weakPassword);
            assertTrue("Password did not throw InvalidSequenceException", false);

	    } catch (InvalidSequenceException e) {
	        assertTrue("Password with more than 2 of the same character in sequence should throw InvalidSequenceException", true);
	    } catch (Exception e) {
	        fail("Password should throw InvalidSequenceException");
	    }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		// First test case: a password with at least one digit
	    String passwordWithDigit = "Password123!";
	    try {
	        assertTrue("Password with at least one digit should be valid",
	                PasswordCheckerUtility.isValidPassword(passwordWithDigit));
	    } catch (Exception e) {
	        fail("Valid password should not throw any exception");
	    }

	    // Second test case: a password without any digit (should throw NoDigitException)
	    String passwordWithoutDigit = "NoDigitPassword!";
	    try {
	        PasswordCheckerUtility.isValidPassword(passwordWithoutDigit);
            assertTrue("Password did not throw NoDigitException", false);
	    } catch (NoDigitException e) {
	        assertTrue("Password without any digit should throw NoDigitException", true);
	    } catch (Exception e) {
	        fail("Password should throw NoDigitException");
	    }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		 // Test cases with valid passwords
	    String[] validPasswords = {
	        "ValidPassword123!",
	        "SecurePass@2022",
	        "StrongPassword2!!"
	    };

	    for (String password : validPasswords) {
	        try {
	            assertTrue("Valid password should not throw any exception",
	                    PasswordCheckerUtility.isValidPassword(password));
	        } catch (Exception e) {
	            fail("Valid password should not throw any exception");
	        }
	    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		 // First password: No lowercase alphabetic character
	    Scanner in = new Scanner(invalidPasswords.get(0));
	    assertEquals(in.next(), "PASSWORD1!");
	    String comment = in.nextLine().trim();
	    assertTrue(comment.contains("lowercase"));
	    // The password must contain at least one lowercase alphabetic character
	    
	    // Second password: No digit
	    in = new Scanner(invalidPasswords.get(1));
	    assertEquals(in.next(), "Password!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("digit"));
	    // The password must contain at least one digit
	    
	    // Third password: More than two of the same character in sequence
	    in = new Scanner(invalidPasswords.get(2)); 
	    assertEquals(in.next(), "Paaass1!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("sequence"));
	    // The password cannot contain more than two of the same character in sequence
	    
	    // Fourth password: Length of password is less than 6 characters
	    in = new Scanner(invalidPasswords.get(3)); 
	    assertEquals(in.next(), "P1!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("long"));
	    // The password must be at least 6 characters long
	    
	    // Fifth password: No uppercase alphabetic character
	     in = new Scanner(invalidPasswords.get(4));
	    assertEquals(in.next(), "password1!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("uppercase"));
	    // The password must contain at least one uppercase alphabetic character
	    
	    // Sixth password: No lowercase alphabetic character
	    in = new Scanner(invalidPasswords.get(5));
	    assertEquals(in.next(), "PASSWORD1!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("lowercase"));
	    // The password must contain at least one lowercase alphabetic character
	    
	    // Seventh password: No digit
	    in = new Scanner(invalidPasswords.get(6)); 
	    assertEquals(in.next(), "Password!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("digit"));
	    // The password must contain at least one digit
	    
	    // Eighth password: No special character
	    in = new Scanner(invalidPasswords.get(7)); 
	    assertEquals(in.next(), "Password1");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("special character"));
	    // The password must contain at least one special character
	    
	    // Ninth password: More than two of the same character in sequence
	    in = new Scanner(invalidPasswords.get(8)); 
	    assertEquals(in.next(), "Paaass1!");
	    comment = in.nextLine().trim();
	    assertTrue(comment.contains("sequence"));
	    // The password cannot contain more than two of the same character in sequence
		
	    in.close();
	}
	
}
