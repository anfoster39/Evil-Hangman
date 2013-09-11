/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;
import evilHangman.NoExitManager;
import evilHangman.UserInteraction;

/**
 * @author Anne
 *
 */
public class GetUserWordLengthTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	    System.setSecurityManager(new NoExitManager(System.getSecurityManager()));
	}

	@Test
	public void testOkNum() {
		String message = new String("The getUserWordLength does not approve of ok numbers");
		String message1 = new String("The getUserWordLength does print right message asking for input");
		
		System.setIn(new ByteArrayInputStream("5".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int result = test.getUserWordLength();
		
		assertEquals(message1, "\nPlease enter the number of letters in the secret word: ", printMessage.toString());
		assertEquals(message, result, 5);
	}
	
	@Test
	public void testSpacesBeforeNum() {
		String message = new String("The getUserWordLength does not approve of ok numbers");
		String message1 = new String("The getUserWordLength does print right message asking for input");
		
		System.setIn(new ByteArrayInputStream("   5".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int result = test.getUserWordLength();
		
		assertEquals(message1, "\nPlease enter the number of letters in the secret word: ", printMessage.toString());
		assertEquals(message, result, 5);
	}
	
	@Test(expected=SecurityException.class)
	public void testNegativeNum() {
		String message = new String("The getUserWordLength does not exit on negative numbers");
		
		System.setIn(new ByteArrayInputStream("-5".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		test.getUserWordLength();
		
		assertEquals(message, "\nThere cannot be a word of length -5. Goodbye\n", printMessage.toString());

	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);  
	}

}
