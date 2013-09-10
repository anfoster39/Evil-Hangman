/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import evilHangman.EvilHangman;

/**
 * @author Anne
 *
 */
public class CheckLetterInWordTest {
	EvilHangman test = new EvilHangman(null);

	@Test
	public void testLetterInWord() {
		assertTrue(test.checkLetterInWord("start", 'a'));
	}
	
	@Test
	public void testLetterNotInWord() {
		assertFalse(test.checkLetterInWord("start", 'z'));
	}

}
