/**
 * 
 */
package evilHangman;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Anne
 *
 */
public class EvilHangman {
	ArrayList<String> dictionary;
	char[] guessesChar;
	public int guessNum;
	public int currentGuess;
	public int gameState;


	public static void main(String[] args){
		//TODO load arg1 as dictionary
		//TODO if no dictionary print message and load default
		//TODO get word length
		//TODO prune Dictionary
		//TODO get number of guesses 
		//TODO play Evil hangman
	}
	
	public int getUserWordLength(){
		//TODO prompt user for number of letters in secret word 
		//(check that it is positive, if not display error and terminate) 
		return (Integer) null;
	}
	
	public ArrayList<String> pruneDictionary(HashMap<Integer, ArrayList<String>> Ditctionary, int length){
		//TODO return the ArrayList at the correct hashmap location
		//TODO if no words for length, terminate
		return null;
	}
	
	public int getUserGuesses(){
		//TODO should be a positive number less then 26
		//TODO if greater then 26, set guesses to 26 and display some message ("there are only 26 letters in the English language) 
		return (Integer) null;
	}
	
	public void playEvil(ArrayList<String> dictionary, int numOfGuesses, int currentGuessNum, int numOfLetters, ArrayList<Character> guesses){
		//TODO check that there are more then 1 word in arrayList & that guesses are not up
			//if so, switch to normal mode or end game
		//TODO print current status
		//TODO ask for guess
		//TODO discard any word with that letter
		//TODO if new list != null, tell that guess is incorrect
		//TODO is no words are left, tell that guess is correct GOTO normal mode with first word
	}
	
	public char getGuess(){
		//TODO ask to enter a guess
		//TODO check that user entered a char, if not repeat
		return (Character) null;
	}
	
	public ArrayList<String> discardWords(ArrayList<String> wordList, char letter){
		//TODO go through each word and discard it if it has the letter in it
		return null;
	}
	
	public void playNormal(String word, int numOfGuesses, int currentGuessNum, int numOfLetters, ArrayList<Character> guesses){
		//TODO check number of guesses if game over, end game
		//TODO print current
		//TODO ask for guess
		//TODO check if letter is in word
		//TODO check if word is complete, is so end game
		//TODO loop back
	}
	
	public void endGame(Boolean win, String word){
		//TODO print out if player won or lost and the word if they lost
		//TODO ask if want to play again
	}
	
}
