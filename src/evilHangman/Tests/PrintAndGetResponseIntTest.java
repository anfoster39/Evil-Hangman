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
public class PrintAndGetResponseIntTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	EvilHangman test = new EvilHangman();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(printMessage));
	}
		
	@Test
	public void testIntInput(){
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return the input");
		
		System.setIn(new ByteArrayInputStream("3".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int response = UserInteraction.printAndGetResponseInt("Enter a number");
		
		assertEquals(message1, "Enter a number", printMessage.toString());
		assertEquals(message2, 3, response);
	
	}
	
	@Test
	public void testNegIntInput(){
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return negative input");
		
		System.setIn(new ByteArrayInputStream("-10".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int response = UserInteraction.printAndGetResponseInt("Enter a number");
		
		assertEquals(message1, "Enter a number", printMessage.toString());
		assertEquals(message2, -10, response);
	
	}
	
	@Test
	public void testSpacesInput(){
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return input without spaces");
		
		System.setIn(new ByteArrayInputStream("   5".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int response = UserInteraction.printAndGetResponseInt("Enter a number");
		
		assertEquals(message1, "Enter a number", printMessage.toString());
		assertEquals(message2, 5, response);
	
	}
	
	@Test
	public void testMultipleSpacesInput(){
		String message1 = new String ("failed to print the right string");
		String message2 = new String ("failed to return input without spaces and second int");
		
		System.setIn(new ByteArrayInputStream("   5  2".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		int response = UserInteraction.printAndGetResponseInt("Enter a number");
		
		assertEquals(message1, "Enter a number", printMessage.toString());
		assertEquals(message2, 5, response);
	
	}
	
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);   
	}



}
