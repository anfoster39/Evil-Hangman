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
import evilHangman.UserInteraction;

/**
 * @author Anne
 *
 */
public class GetUserGuessNumTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman(null);

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}

	@Test
	public void okNumber(){
		String message = new String ("failed to return the ok number");
		System.setIn(new ByteArrayInputStream("3\n".getBytes()));
		assertEquals(message, 3, test.getUserGuesses());
	}
	
	@Test
	public void negativeNumber(){
		String message = new String ("failed to print error message and exit on negative number");
		System.setIn(new ByteArrayInputStream("-5\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		test.getUserGuesses();
		
		assertEquals(message, "Negative Error Message", printMessage.toString());
	}
	
	@Test
	public void tooBigNumber(){
		String message = new String ("failed to print error message on too big number");
		String message2 = new String ("failed to return 26 if guesses are too high");
		System.setIn(new ByteArrayInputStream("100\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		assertEquals(message, "Large Number Error Message", printMessage.toString());
		assertEquals(message2, 26, test.getUserGuesses());
	}
		
	@After
	public void cleanUp() {
		System.setOut(null);
	    System.setIn(stdin);
	}

}
