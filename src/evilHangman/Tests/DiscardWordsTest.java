/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class DiscardWordsTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	
	EvilHangman test = new EvilHangman(null);
	
	ArrayList<String> wordList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(printMessage));
		
		wordList = new ArrayList<String>();
		wordList.add("cat");
		wordList.add("hat");
		wordList.add("dog");
		wordList.add("god");
		wordList.add("boy");
		wordList.add("toy");
		wordList.add("lit");
		wordList.add("let");
		
	}

	@Test
	public void eliminateWordsTest() {
		String message = new String ("Did not eliniate all words with letter");
		
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("cat");
		expectedResult.add("hat");
		expectedResult.add("lit");
		expectedResult.add("let");
		
		assertEquals(message, expectedResult, test.discardWords(wordList, 'o'));
	}
	
	@Test
	public void NoEliminationsTest() {
		String message = new String ("Eliniate words without letter");
		
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("cat");
		expectedResult.add("hat");
		expectedResult.add("dog");
		expectedResult.add("god");
		expectedResult.add("boy");
		expectedResult.add("toy");
		expectedResult.add("lit");
		expectedResult.add("let");
		
		assertEquals(message, expectedResult, test.discardWords(wordList, 'z'));
	}

}
