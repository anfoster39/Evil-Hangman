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
public class PlayNormalTest {
	private final ByteArrayOutputStream printMessage = new ByteArrayOutputStream();
	private final InputStream stdin = System.in;
	
	EvilHangman test = new EvilHangman();
	
	ArrayList<Character> guesses;


	@Before
	public void setUp(){
		System.setOut(new PrintStream(printMessage));
		System.setSecurityManager(new NoExitManager(System.getSecurityManager()));
		
		guesses = new ArrayList<Character>();
	}

	
	@Test(expected=SecurityException.class)
	public void letterInWord() {
		String message1 = new String ("Did not add the letter to the word");
		
		System.setIn(new ByteArrayInputStream("a\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playNormal("cat", 5, 4, 3, guesses);

		assertEquals(message1, "Status is: _ a _ \n" + "You have 1 guesses remaining.\n"+
				"Letters Guessed: a" + "\nSorry, you lost. The word was cat", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void letterNotInWord() {
		String message1 = new String ("Did not add the letter to the word");
		
		System.setIn(new ByteArrayInputStream("z\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playNormal("cat", 5, 4, 3, guesses);

		assertEquals(message1, "Status is: _ _ _ \n" + "You have 1 guesses remaining.\n"+
				"Letters Guessed: z" + "\nSorry, you lost. The word was cat", printMessage.toString());
	}
	
	@Test(expected=SecurityException.class)
	public void normalWin() {
		guesses.add('c');
		guesses.add('t');
		
		String message1 = new String ("Did not trigger win condition");
		
		System.setIn(new ByteArrayInputStream("a\n".getBytes()));
		UserInteraction.scanner = new Scanner (System.in);
		
		test.playNormal("cat", 5, 4, 3, guesses);

		assertEquals(message1, "Status is: c _ t \n" + "You have 1 guesses remaining.\n"+
				"Letters Guessed: c t" + "\nCongratulations! you won!", printMessage.toString());
	}
	
	@After
	public void cleanUp() {
	    System.setOut(null);
	    System.setIn(stdin);  
	}

}
