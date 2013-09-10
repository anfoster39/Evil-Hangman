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
public class PlayEvilTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	
	EvilHangman test = new EvilHangman();
	
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
		wordList.add("got");
		wordList.add("bot");
		wordList.add("toy");
		wordList.add("lit");
		wordList.add("let");
		
	}

	
	//check that there are more then 1 word in arrayList & that guesses are not up
	//if so, switch to normal mode or end game
	//print current status
	//ask for guess
	//discard any word with that letter
	//if new list != null, tell that guess is incorrect
	//is no words are left, tell that guess is correct GOTO normal mode with first word

	@Test
	public void eliminationTest() {
		String message1 = new String ("Did not eliniate ");
	}

}
