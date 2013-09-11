/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
	EvilHangman test = new EvilHangman();
	private ArrayList<Character> guessList; 

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	    guessList = new ArrayList<Character>();
	}
		
	@Test
	public void okCharTest(){
		String message1 = new String ("failed to get correct input");
		String message2 = new String ("failed to print message");
		
		System.setIn(new ByteArrayInputStream("a\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		char result = test.getGuess(guessList);
		
		assertEquals(message2, "\nWhat is your guess? ", printMessage.toString());
		assertEquals(message1, 'a', result);
	}
	
	@Test
	public void UppercaseTest(){
		String message1 = new String ("failed to convert uppercase to lowercase");
		String message2 = new String ("failed to print message");
		
		System.setIn(new ByteArrayInputStream("A\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess(guessList);
		
		assertEquals(message2, "\nWhat is your guess? ", printMessage.toString());
		assertEquals(message1, 'a', result);
	}
	
	@Test
	public void numberInputTest(){
		String message1 = new String ("failed to print message");
		String message3 = new String ("failed to get correct input");
		
		System.setIn(new ByteArrayInputStream("3 h".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess(guessList);
		
		assertEquals(message1, "\nWhat is your guess? " + "\nPlease enter a letter: ", printMessage.toString());
		assertEquals(message3, 'h', result);
	
	}
	
	@Test
	public void specialCharInputTest(){
		String message1 = new String ("failed to print message");
		String message3 = new String ("failed to get correct input");
		
		System.setIn(new ByteArrayInputStream("! b".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess(guessList);
		
		assertEquals(message1, "\nWhat is your guess? " + "\nPlease enter a letter: ", printMessage.toString());
		assertEquals(message3, 'b', result);
	
	}
	
	@Test
	public void duplicateCharInputTest(){
		String message1 = new String ("failed to print message");
		String message2 = new String ("failed to reprint message");
		
		guessList.add('b');
		
		System.setIn(new ByteArrayInputStream("b c".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		char result = test.getGuess(guessList);
		
		assertEquals(message1, "\nWhat is your guess? You have already guessed b"
		+ "\nPlease enter a letter: ", printMessage.toString());
		assertEquals(message2, 'c', result);
	
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);   
	}


}
