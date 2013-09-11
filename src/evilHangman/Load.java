/**
 * 
 */
package evilHangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Anne
 *
 */
public class Load {
    static BufferedReader bufferedReader;
    
    public static HashMap<Integer, ArrayList<String>> loadDictionary(String filename){
    	readFile(filename);
    	HashMap<Integer, ArrayList<String>> dictionary = new HashMap<Integer, ArrayList<String>>();
    	String next;
    	while ((next = readLine()) != null){
    		addtoDictionary(dictionary, next);
    	}
    	close();
		return dictionary;
    }
    

	public static void readFile(String fileName){
        FileReader fileReader = null;
        try {
               fileReader = new FileReader(fileName);
        }
        catch(FileNotFoundException e) {
            UserInteraction.printToScreen("\nProgram cannot find dictionary file:"+fileName);
            System.exit(0);
        }
        bufferedReader = new BufferedReader(fileReader);
    }
    
    static String readLine() {
       try {
      
           return bufferedReader.readLine();
       }
       catch(IOException e) {
           e.printStackTrace();
       }
       return null;
    }
    
    /**
   	 * @param dictionary
   	 * @param next
   	 */
   	public static void addtoDictionary(HashMap<Integer, ArrayList<String>> dictionary,String word) {
   		Integer length = word.length();
   		if (!dictionary.containsKey(length)){
   			dictionary.put(length, new ArrayList<String>());
   		}
   		dictionary.get(length).add(word);
   			
   	}
    
    static void close() {
        try {
            bufferedReader.close();
        }
        catch(IOException e) {
            
        }
    }

}
