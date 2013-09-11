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
public class Main {
	public static HashMap <Integer, ArrayList<String>> dictionary;

	public static void main(String[] args){
		EvilHangman game;
		if(args.length > 1){
			dictionary = Load.loadDictionary("dictionary.txt");
			}
		else{
			UserInteraction.printToScreen("No Dictionary file specified, using the dictionary.txt located in current directory");
			dictionary = Load.loadDictionary("dictionary.txt");
		}
		game = new EvilHangman(dictionary);
		game.play();
	}

}
