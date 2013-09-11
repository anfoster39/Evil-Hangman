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
import evilHangman.NoExitManager;
import evilHangman.UserInteraction;

/**
 * @author Anne
 *
 */
public class PlayEvilTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	
	EvilHangman test = new EvilHangman();
	
	ArrayList<String> wordList;
	ArrayList<Character> guesses;


	@Before
	public void setUp(){
		System.setOut(new PrintStream(printMessage));
		System.setSecurityManager(new NoExitManager(System.getSecurityManager()));
		
		wordList = new ArrayList<String>();
		wordList.add("cat");
		wordList.add("hat");
		wordList.add("dog");
		wordList.add("got");
		wordList.add("bot");
		wordList.add("toy");
		wordList.add("lit");
		wordList.add("let");
		
		guesses = new ArrayList<Character>();
	}

	
	//check that there are more then 1 word in arrayList & that guesses are not up
	//if so, switch to normal mode or end game
	//print current status
	//ask for guess
	//discard any word with that letter
	//if new list != null, tell that guess is incorrect
	//is no words are left, tell that guess is correct GOTO normal mode with first word

	@Test(expected=SecurityException.class)
	public void eliminateWordsandContinueTest() {
		String message1 = new String ("Did not eliniate words with letter");
		String message2 = new String ("Did not elminate the right number of words");
		String message3 = new String ("Did not print correct message");
		
		System.setIn(new ByteArrayInputStream("o\n ".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playEvil(wordList, 5, 4, 3, guesses);
		
		assertFalse(message1, wordList.contains("bot"));
		assertEquals(message2, 3, wordList.size());
		assertEquals(message3, "Status is: _ _ _ _ _ \n" + "You have 5 guesses remaining.\n"+
				"Letters Guesses: \nSorry, o is not in the word" +
				"\nSorry, you lost. The word was cat", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void noWordsEliminatedTest() {
		String message1 = new String ("Did not eliniate words with letter");
		String message2 = new String ("Did not elminate the right number of words");
		String message3 = new String ("Did not print correct message");
		
		System.setIn(new ByteArrayInputStream("z\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playEvil(wordList, 5, 4, 3, guesses);
		
		assertFalse(message1, wordList.contains("bot"));
		assertEquals(message2, 8, wordList.size());
		assertEquals(message3, "Status is: _ _ _ _ _ \n" + "You have 5 guesses remaining.\n"+
				"Letters Guessed: \nSorry, z is not in the word" +
				"\nSorry, you lost. The word was cat", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void endGameTest(){
		String message = new String ("failed to print the right message");
		test.playEvil(wordList, 5, 5, 5, guesses);
		assertEquals(message, "\nSorry, you lost. The word was cat", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void shiftToNormalTest() {
		wordList = new ArrayList<String>();
		wordList.add("a");
		wordList.add("b");
		
		String message1 = new String ("Did not eliniate words with letter");
		String message2 = new String ("Did not elminate the right number of words");
		String message3 = new String ("Did not print correct message");
		
		System.setIn(new ByteArrayInputStream("b\n a".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playEvil(wordList, 5, 3, 3, guesses);
		
		assertFalse(message1, wordList.contains("a"));
		assertEquals(message2, 1, wordList.size());
		assertEquals(message3, "Status is: a \n" + "You have 2 guesses remaining.\n"+
				"Letters Guessed:  \n" +
				"\nCongratulations! you won!", printMessage.toString());
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);  
	}

}
