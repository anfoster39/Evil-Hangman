/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;
import evilHangman.UserInteraction;

/**
 * @author Anne
 *
 */
public class GetUserGuessesTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}

	@Test
	public void OKnumber(){
		String message = new String ("failed to return the ok number");
		System.setIn(new ByteArrayInputStream("3\n".getBytes()));
		assertEquals(message, 3, test.getUserGuesses());

	}
		
	@After
	public void cleanUp() {
	    System.setOut(null);
	    
	}

}
