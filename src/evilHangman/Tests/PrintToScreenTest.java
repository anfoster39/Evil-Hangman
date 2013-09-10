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
 * Referenced code by dfa on StackOverflow to help set up the testing the System.out.print
 * junit on http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
 */
public class PrintToScreenTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}

	@Test
	public void printMessage(){
		String message = new String ("failed to print the right string");
		UserInteraction.printToScreen("test");
		assertEquals(message, "test", printMessage.toString());
	}
		
	@After
	public void cleanUp() {
	    System.setOut(null);
	}


}
