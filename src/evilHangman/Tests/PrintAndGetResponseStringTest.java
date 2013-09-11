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
 * Referenced code by dfa on StackOverflow to help set up the testing the System.out.print
 * junit on http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
 * 
 * 
 */
public class PrintAndGetResponseStringTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}
	
	@Test
	public void testStirngInput(){
		
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return the input as an int");
		
		System.setIn(new ByteArrayInputStream("ok".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		String response = UserInteraction.printAndGetResponseString("How are you today?");
		
		assertEquals(message1, "How are you today?", printMessage.toString());
		assertEquals(message2, "ok", response);
	}
	
	@Test
	public void testCharInput(){
		
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return the input as an int");
		
		System.setIn(new ByteArrayInputStream("a".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		String response = UserInteraction.printAndGetResponseString("Enter a letter: ");
		
		assertEquals(message1, "Enter a letter: ", printMessage.toString());
		assertEquals(message2, "a", response);
	}
	
	@Test
	public void testSpacesInput(){
		
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return the input as an int");
		
		System.setIn(new ByteArrayInputStream("   A".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		String response = UserInteraction.printAndGetResponseString("Enter a letter: ");
		
		assertEquals(message1, "Enter a letter: ", printMessage.toString());
		assertEquals(message2, "A", response);
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);   
	}



}
