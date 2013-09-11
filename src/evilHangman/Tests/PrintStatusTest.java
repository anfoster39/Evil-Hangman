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

/**
 * @author Anne
 *
 */
public class PrintStatusTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	EvilHangman test = new EvilHangman();
	ArrayList<Character> testGuesses;

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	    testGuesses = new ArrayList <Character> ();
	}

	@Test
	public void printMessageNoWord(){
		String message = new String ("failed to print the right status");
		test.printStatus(null, 8, 0, 5, testGuesses);
		assertEquals(message, "\n\nStatus is: _ _ _ _ _ \n" + "You have 8 guesses remaining.\n"+
				"Letters Guessed: \n", printMessage.toString());
	}
	
	@Test
	public void printMessageWordNoGoodGuess(){
		String message = new String ("failed to print the right status");
		test.printStatus("test", 8, 0, 4, testGuesses);
		assertEquals(message, "\n\nStatus is: _ _ _ _ \n" + "You have 8 guesses remaining.\n"+
				"Letters Guessed: \n", printMessage.toString());
	}
	
	@Test
	public void printMessageWordWithGuess(){
		String message = new String ("failed to print the right status");
		testGuesses.add('a');
		testGuesses.add('b');
		testGuesses.add('t');
		test.printStatus("test", 8, 0, 4, testGuesses);
		assertEquals(message, "\n\nStatus is: t _ _ t \n" + "You have 8 guesses remaining.\n"+
				"Letters Guessed: a b t \n", printMessage.toString());
	}
	
	@Test
	public void printMessageWordWithGuessCapital(){
		String message = new String ("failed to print the right status");
		testGuesses.add('a');
		testGuesses.add('b');
		testGuesses.add('t');
		test.printStatus("TEST", 8, 0, 4, testGuesses);
		assertEquals(message, "\n\nStatus is: t _ _ t \n" + "You have 8 guesses remaining.\n"+
				"Letters Guessed: a b t \n", printMessage.toString());
	}
		
	@After
	public void cleanUp() {
	    System.setOut(null);
	}


}
