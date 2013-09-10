/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
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
public class EndGameTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	EvilHangman test = new EvilHangman(null);

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}

	@Test
	public void printWinMessage(){
		String message = new String ("failed to print the winning string");
		test.endGame(true, "test");
		assertEquals(message, "Win message, word test", printMessage.toString());
	}
		
	@Test
	public void printLooseMessage(){
		String message = new String ("failed to print the winning string");
		test.endGame(false, "Sorry");
		assertEquals(message, "Win message, word test", printMessage.toString());
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	}


}
