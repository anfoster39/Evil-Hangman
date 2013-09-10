/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class GetUserWordLengthTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	EvilHangman test = new EvilHangman(null);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}

	@Test
	public void testOkNum() {
		String message = new String("The getUserWordLength does not approve of ok numbers");
		int result = test.getUserWordLength();
		
		ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
		System.setIn(in);
		
		assertEquals(message, result, 5);
	}
	
	@Test
	public void testNegativeNum() {
		String message = new String("The getUserWordLength does not exit on negative numbers");
		
		ByteArrayInputStream in = new ByteArrayInputStream("-5".getBytes());
		System.setIn(in);
		int result = test.getUserWordLength();
		
		assertEquals(message, "Error message", printMessage.toString());
		assertNull(message, result);
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	}

}
