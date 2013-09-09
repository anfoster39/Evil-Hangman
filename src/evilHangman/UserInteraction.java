/**
 * 
 */
package evilHangman;

import java.util.Scanner;

/**
 * @author Anne
 *
 */
public class UserInteraction {
	public static Scanner scanner = new Scanner (System.in);

	public static void printToScreen(String print){
		System.out.print(print);
	}
	
	public static String printAndGetResponse (String print){
		System.out.print(print);
		return(scanner.next());
	}
}
