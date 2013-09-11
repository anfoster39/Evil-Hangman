/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class DiscardWordsTest {
	EvilHangman test = new EvilHangman();
	
	ArrayList<String> wordList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wordList = new ArrayList<String>();
		wordList.add("cat");
		wordList.add("hat");
		wordList.add("dog");
		wordList.add("god");
		wordList.add("boy");
		wordList.add("TOY");
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
		String message = new String ("Did not return list that was the same as the input list");
		
		assertEquals(message, wordList, test.discardWords(wordList, 'z'));
	}
	
	@Test
	public void returnNullTest() {
		String message = new String ("Did not return null if all words would be eliminated");
		
		wordList.remove("dog");
		wordList.remove("god");
		wordList.remove("boy");
		
		assertNull(message, test.discardWords(wordList, 't'));
	}

}
