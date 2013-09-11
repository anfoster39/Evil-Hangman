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
	public HashMap <Integer, ArrayList<String>> dictionary;
	private final static int badInput = -88;

	/**
	 * Loads the dictionary file. If no file is given it will try to load dictionary.txt
	 * @param filename File path of the dictionary file
	 */
	public EvilHangman(HashMap <Integer, ArrayList<String>> _dictionary){
			dictionary = _dictionary;
	}
	
	/**
	 * For testing purposes. Loads the game without any dictionary file. 
	 */
	public EvilHangman(){
		}
	
	/**
	 * Starts the game by getting the word length and guess number from the user then calls PlayEvil
	 */
	public void play(){
		int wordLength = getUserWordLength();
		ArrayList<String>Words = pruneDictionary(wordLength);
		int guessesNum = getUserGuesses();
		playEvil(Words, guessesNum, 0, wordLength, new  ArrayList<Character>());
	}
	
	/**
	 * Prompts user for number of letters in secret word, 
	 * if length is less then one, gives error message and exits
	 * @return Word length from user
	 */
	public int getUserWordLength(){
		int length = badInput;
//		while (length == badInput){
			length = UserInteraction.printAndGetResponseInt("\nPlease enter the number of letters in the secret word: ");
//		}
		if(length < 1){
			UserInteraction.printToScreen("\nThere cannot be a word of length " + length+ ". Goodbye\n");
			System.exit(-1);
		}
		return length;
	}
	
	/**
	 * Goes through the dictionary and returns only the list with the correct number of letters.
	 * if no words of the desired length exist, gives an error message and exits.
	 * @param dictionary Dictionary that contains all the words
	 * @param length The Length of the words desired
	 * @return The ArrayList of words of the length
	 */
	public ArrayList<String> pruneDictionary(Integer length){
		if(dictionary.containsKey(length)){
			return dictionary.get(length);
		}
		else{
			UserInteraction.printToScreen("\nThere are no words of length " + length + " in the dictionary. Goodbye\n");
			System.exit(0);
			return null;
		}		
	}
	
	/**
	 * Asks user for number of guesses
	 * If negative gives error message and exits
	 * If over 26, prints message and uses 26
	 * @return The number of guesses from user
	 */
	public int getUserGuesses(){
		int guesses = UserInteraction.printAndGetResponseInt("\nPlease enter the number of guesses you want: ");
		while (guesses == badInput){
			guesses = UserInteraction.printAndGetResponseInt("\nPlease enter the number of letters in the secret word: ");
		}
		if(guesses < 1){
			UserInteraction.printToScreen("You cannot have 0 or less guesses. Goodbye\n");
			System.exit(-1);
		}
		if(guesses > 26){
			UserInteraction.printToScreen("\nThere are only 26 letters in the alphabet, you can have at most 26 guesses. " +
					"You will have 26 guesses.\n");
			guesses = 26;
		}
		return guesses;
	}
	
	/**
	 * Play Evil will go through the list of words and eliminate every word that has the letter the user guesses.
	 * if all words would be eliminated, then it switches to playNormal()
	 * @param dictionary List of words to of correct size
	 * @param numOfGuesses Number of Guesses 
	 * @param currentGuessNum
	 * @param numOfLetters
	 * @param guesses
	 */
	public void playEvil(ArrayList<String> wordList, int numOfGuesses, int currentGuessNum, int numOfLetters, ArrayList<Character> guesses){
		if(wordList.size() == 1){
			playNormal(wordList.get(0), numOfGuesses, currentGuessNum, numOfLetters, guesses);
		}
		printStatus(null, numOfGuesses, currentGuessNum, numOfLetters, guesses);
		if(numOfGuesses <= currentGuessNum){
			endGame(false, wordList.get(0));
		}
		char guess = getGuess(guesses);
		guesses.add(guess);
		currentGuessNum++;
		ArrayList<String> newList = discardWords(wordList, guess);
		if (newList == null){
			playNormal(wordList.get(0), numOfGuesses, currentGuessNum, numOfLetters, guesses);
		}
		UserInteraction.printToScreen("\nSorry, '" + guess + "' is not in the word");
		playEvil(newList, numOfGuesses, currentGuessNum, numOfLetters, guesses);
	}
	
	/**
	 * Plays Hangman with regular rules
	 * @param word
	 * @param numOfGuesses
	 * @param currentGuessNum
	 * @param numOfLetters
	 * @param guesses
	 */
	public void playNormal(String word, int numOfGuesses, int currentGuessNum, int numOfLetters, ArrayList<Character> guesses){
		printStatus(word, numOfGuesses, currentGuessNum, numOfLetters, guesses);
		if(guessedWord(word, guesses)){
			endGame(true, word);
		}
		if(numOfGuesses <= currentGuessNum){
			endGame(false, word);
		}
		char guess = getGuess(guesses);
		guesses.add(guess);
		currentGuessNum++;
		if (!word.toLowerCase().contains(""+guess)){
			UserInteraction.printToScreen("\nSorry, '" + guess + "' is not in the word");
		}
		playNormal(word, numOfGuesses, currentGuessNum, numOfLetters, guesses);
	}
	
	/**
	 * Get the guess from the user. 
	 * @return always return the lowercase of the letter
	 */
	public char getGuess(ArrayList<Character> guesses){
		char letter = '\n';
		String guess = UserInteraction.printAndGetResponseString("\nWhat is your guess? ");
		while(letter == '\n'){
			for(int i = 0; i < guess.length(); i++){
				if ((guess.charAt(i) >= 65) && (guess.charAt(i) <= 90)){
					letter = guess.charAt(i);
					letter += 32; //to convert to lowercase
					if(guesses.contains(letter)){ //to ensure that the user does not enter the same letter multiple times
						UserInteraction.printToScreen("You have already guessed " + letter);
						letter = '\n';
						continue;
					}
					return letter;
				}
				if ((guess.charAt(i) >= 97) && (guess.charAt(i) <= 122)){
						letter = guess.charAt(i);
						if(guesses.contains(letter)){ //to ensure that the user does not enter the same letter multiple times
							UserInteraction.printToScreen("You have already guessed " + letter);
							letter = '\n';
							continue;
						}
						return letter;
				}
			}
			guess = UserInteraction.printAndGetResponseString("\nPlease enter a letter: ");
		}
		return letter;
	}
	
public void printStatus(String word, int numOfGuesses, int currentGuessNum, int numOfLetters, ArrayList<Character> guesses){
	//ensures there is no out of bounds errors if the numOfLetters is incorrect
	if ((word != null) && (word.length() != numOfLetters)){
		numOfLetters = word.length();
	}
	if(word != null){
		word = word.toLowerCase();
	}
	String print = ("\n\nStatus is: ");
	for (int i = 0; i < numOfLetters; i++){
		if (word != null){
			if(guesses.contains(word.charAt(i))){
				print += word.charAt(i) + " ";
				continue;
			}
		}
		print += "_ ";
	}
	print += "\nYou have " + (numOfGuesses - currentGuessNum) + " guesses remaining.\n"
			+ "Letters Guessed: ";
	for (char letter : guesses){
		print += letter + " ";
	}
	print +="\n";
	UserInteraction.printToScreen(print);
	}
	
	/**
	 * Goes through the list of words and eliminates those that have the letter specified in it
	 * Will return null if all words will be eliminated
	 * @param wordList List of words to sort
	 * @param letter Letter which to eliminate words with
	 * @return
	 */
	public ArrayList<String> discardWords(ArrayList<String> wordList, char letter){
		ArrayList<String> newList = new ArrayList<String>();
		for(String word : wordList){
			if (!word.toLowerCase().contains(""+letter)){
				newList.add(word);
			}
		}
		if (newList.size() == 0){
			newList = null;
		}
		return newList;
	}
	
	
	public boolean guessedWord(String word, ArrayList<Character> guesses){
		word = word.toLowerCase();
		for(int i = 0; i < word.length(); i++){
			if (!guesses.contains(word.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public void endGame(Boolean win, String word){
		if(win){
			UserInteraction.printToScreen("\n\nCongratulations! you won!");
			System.exit(0);
		}
		UserInteraction.printToScreen("\n\nYou lost. The word was " + word);
		System.exit(0);
	}
	
}
