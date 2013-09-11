/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;
import evilHangman.NoExitManager;

/**
 * @author Anne
 *
 */
public class EndGameTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	EvilHangman test = new EvilHangman();
	ArrayList<Character> testGuesses;

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	    System.setSecurityManager(new NoExitManager(System.getSecurityManager()));
	}

	@Test(expected=SecurityException.class)
	public void looseMessage(){
		String message = new String ("failed to print the right message");
		test.endGame(false, "Sorry");
		assertEquals(message, "\nSorry, you lost. The word was Sorry", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void winMessage(){
		String message = new String ("failed to print the right message");
		test.endGame(true, "test");
		assertEquals(message, "\nCongratulations! you won!", printMessage.toString());
	}
		
	@After
	public void cleanUp() {
	    System.setOut(null);
	}


}
