/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class PruneDictionaryTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	HashMap<Integer, ArrayList<String>> testDictionary; 
	EvilHangman test = new EvilHangman();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		testDictionary = new HashMap<Integer, ArrayList<String>>();
		testDictionary.put(1, new ArrayList<String>());
		testDictionary.put(2, new ArrayList<String>());
		testDictionary.put(3, new ArrayList<String>());
		testDictionary.get(1).add("a");
		testDictionary.get(2).add("an");
		testDictionary.get(2).add("to");
		testDictionary.get(2).add("it");
		testDictionary.get(3).add("the");
		testDictionary.get(3).add("cat");
		testDictionary.get(3).add("hat");
		testDictionary.get(3).add("but");
		test.dictionary = testDictionary;
		
		System.setOut(new PrintStream(printMessage));
		
	}

	@Test
	public void testOKNum() {
		ArrayList<String> testWordListOne = new ArrayList<String>();
		testWordListOne.add("a");
		String message = new String("Prune Dictionary does not give the right Array List");
		
		assertTrue(message, test.pruneDictionary(1).equals(testWordListOne));
		
	}
	 
	@Test(expected=SecurityException.class)
	public void testNoNum() {
		String message = new String("Gives error message if there is no words of that length in the dictionary");
		test.pruneDictionary(5);
		assertEquals(message, "There are no words of length 5 in the dictionary. Goodbye\n", printMessage.toString());
	}
	
	@Test
	public void testOKNumLarger() {
		ArrayList<String> testWordListThree = new ArrayList<String>();
		testWordListThree.add("the");
		testWordListThree.add("cat");
		testWordListThree.add("hat");
		testWordListThree.add("but");
		String message = new String("Prune Dictionary does not give the right Array List for longer lists");
		assertTrue(message, test.pruneDictionary(3).equals(testWordListThree));
	}

}
