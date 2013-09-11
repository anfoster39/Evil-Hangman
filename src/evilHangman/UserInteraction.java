/**
 * 
 */
package evilHangman;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Anne
 *
 */
public class UserInteraction {
	public static Scanner scanner = new Scanner (System.in);
	private final static int badInput = -88;

	public static void printToScreen(String print){
		System.out.print(print);
	}
	
	public static String printAndGetResponseString (String print){
		System.out.print(print);
		try{
			return scanner.next();
		}
		catch (NoSuchElementException e){
			return " ";
		}
	}
	
	/**
	 * Asks user for input. 
	 * If input is not in the form of an int, 
	 * it will ask again until there is an int
	 * @param print
	 * @return
	 */
	public static int printAndGetResponseInt (String print){
		String input;
		int result = badInput;
		while (result == badInput){
			System.out.print(print);
			try{
				input = scanner.next();
				try{
					result = Integer.parseInt(input);
					return result;
				}
				catch (NumberFormatException e){
				}
			}
			catch (NoSuchElementException e){
				
			}
		}
		return result;
	}



}
