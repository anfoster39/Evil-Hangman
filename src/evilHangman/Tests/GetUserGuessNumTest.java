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
public class GetUserGuessNumTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	    System.setSecurityManager(new NoExitManager(System.getSecurityManager()));
	}

	@Test
	public void okNumber(){
		String message = new String ("failed to return the ok number");
		String message1 = new String ("failed to print prompt");
		System.setIn(new ByteArrayInputStream("3\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		assertEquals(message, 3, test.getUserGuesses());
		assertEquals(message1, "\nPlease enter the number of guesses you want: ", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void negativeNumber(){
		String message = new String ("failed to print error message and exit on negative number");
		System.setIn(new ByteArrayInputStream("-5\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		test.getUserGuesses();
		
		assertEquals(message, "\nPlease enter the number of guesses you want: "
		+ "You cannot have 0 or less guesses. Goodbye\n", printMessage.toString());
	}
	
	@Test
	public void tooBigNumber(){
		String message = new String ("failed to print error message on too big number");
		String message2 = new String ("failed to return 26 if guesses are too high");
		System.setIn(new ByteArrayInputStream("100\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		int guesses = test.getUserGuesses();
		
		assertEquals(message, "\nPlease enter the number of guesses you want: " + 
				"\nThere are only 26 letters in the alphabet, you can have at most 26 guesses. " +
					"You will have 26 guesses.\n", printMessage.toString());
		assertEquals(message2, 26, guesses);
	}
		
	@After
	public void cleanUp() {
		System.setOut(null);
	    System.setIn(stdin);
	}

}
