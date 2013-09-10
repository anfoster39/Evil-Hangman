/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class GuessedWordTest {
	EvilHangman test = new EvilHangman(null);
	ArrayList<Character> guesses;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		guesses = new ArrayList<Character>();
		
	}

	@Test
	public void testGuessedWordAllCorectLetters() {
		String message = new String("did not recognize that all chars were in word");
		guesses.add('s');
		guesses.add('t');
		guesses.add('a');
		guesses.add('r');
		
		assertTrue(message, test.guessedWord("Start", guesses));
	}
	
	@Test
	public void testGuessedWordExtraLetters() {
		String message = new String("did not recognize that word was guessed with extra letters");
		guesses.add('s');
		guesses.add('t');
		guesses.add('a');
		guesses.add('r');
		guesses.add('b');
		guesses.add('c');
		guesses.add('d');
		guesses.add('e');
		guesses.add('f');
		guesses.add('g');
		
		assertTrue(message, test.guessedWord("Start", guesses));
	}
	
	@Test
	public void testGuessedWordMissingLetters() {
		String message = new String("did not recognize that word was missing letters");
		guesses.add('s');
		guesses.add('t');
		guesses.add('a');
		
		assertFalse(message, test.guessedWord("Start", guesses));
	}

	
	@Test
	public void testGuessedWordMissingLettersExtra() {
		String message = new String("did not recognize that word was guessed with extra letters");
		guesses.add('s');
		guesses.add('t');
		guesses.add('a');
		guesses.add('b');
		guesses.add('c');
		guesses.add('d');
		guesses.add('e');
		guesses.add('f');
		guesses.add('g');
		
		assertFalse(message, test.guessedWord("Start", guesses));
	}
	
	@Test
	public void testGuessedWordNoLetters() {
		String message = new String("did not return false with an empty lsit");
		
		assertFalse(message, test.guessedWord("Start", guesses));
	}
}
