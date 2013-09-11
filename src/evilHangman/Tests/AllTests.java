/**
 * 
 */
package evilHangman.Tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DiscardWordsTest.class, EndGameTest.class, getGuessTest.class, GetUserWordLengthTest.class, 
	GetUserGuessNumTest.class, GuessedWordTest.class, PlayEvilTest.class, PlayNormalTest.class,
	PrintToScreenTest.class, PrintAndGetResponseIntTest.class, PrintAndGetResponseStringTest.class,
	PrintStatusTest.class, PruneDictionaryTest.class })

/**
 * @author Anne
 *
 */
public class AllTests {

}
