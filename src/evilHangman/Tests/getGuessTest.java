/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
public class getGuessTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman(null);

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}
		
	@Test
	public void okCharTest(){
		String message1 = new String ("failed to get correct input");
		String message2 = new String ("failed to print message");
		
		System.setIn(new ByteArrayInputStream("a".getBytes()));
		char result = test.getGuess();
		
		assertEquals(message2, "Ask to enter guess", printMessage.toString());
		assertEquals(message1, 'a', result);
	}
	
	@Test
	public void numberInputTest(){
		String message1 = new String ("failed to print message");
		String message2 = new String ("failed to reprint message");
		String message3 = new String ("failed to get correct input");
		
		System.setIn(new ByteArrayInputStream("3/n h".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess();
		
		assertEquals(message1, "Message", printMessage.toString());
		assertEquals(message2, "Message", printMessage.toString());
		assertEquals(message3, 'h', result);
	
	}
	
	@Test
	public void specialCharInputTest(){
		String message1 = new String ("failed to print message");
		String message2 = new String ("failed to reprint message");
		String message3 = new String ("failed to get correct input");
		
		System.setIn(new ByteArrayInputStream("!/n b".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess();
		
		assertEquals(message1, "Message", printMessage.toString());
		assertEquals(message2, "Message", printMessage.toString());
		assertEquals(message3, 'b', result);
	
	}
	
	@Test
	public void duplicateCharInputTest(){
		String message1 = new String ("failed to print message");
		String message2 = new String ("failed to reprint message");
		
		System.setIn(new ByteArrayInputStream("b/nb/nc".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		test.getGuess();
		char result = test.getGuess();
		
		assertEquals(message1, "Message", printMessage.toString());
		assertEquals(message1, "Message", printMessage.toString());
		assertEquals(message2, 'c', result);
	
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);   
	}


}
