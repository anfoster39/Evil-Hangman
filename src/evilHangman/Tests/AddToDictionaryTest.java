/**
 * 
 */
package evilHangman.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import evilHangman.Load;

/**
 * @author Anne
 *
 */


public class AddToDictionaryTest {
	HashMap<Integer, ArrayList<String>> testDictionary;
	
	@Before
	public void setUp(){
		testDictionary = new HashMap<Integer, ArrayList<String>>();
	}

	@Test
	public void addKeyAndWord() {
		Load.addtoDictionary(testDictionary, "a");
		
		assertTrue(testDictionary.containsKey(1));
		assertTrue(testDictionary.get(1).contains("a"));
	}
	
	@Test
	public void addWordKeyExists() {
		Load.addtoDictionary(testDictionary, "to");
	
		assertTrue(testDictionary.containsKey(2));
		assertTrue(testDictionary.get(2).contains("to"));
		
		Load.addtoDictionary(testDictionary, "at");
		assertTrue(testDictionary.get(2).contains("to"));
	}
	
	

}
