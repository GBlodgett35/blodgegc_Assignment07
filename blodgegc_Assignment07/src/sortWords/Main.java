/***
 * Name: Greg Blodgett and Tiffany Litteral
 * Assignment number: Group Assignment 
 * Course #, and section: Course 2045, Section 1
 * Due date: 3/13/18
 * Description: A program that sorts a text file of 234937 words
 * Citations: 
 * Anything else:
 */

package sortWords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * A program that sorts a text file and looks for:
 * The longest word
 * The letter that appears the most
 * The letter that appears the least
 * The average word length
 * The most Q's that appear in a single word
 * @author blodgegc & Tiffany
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		//Create arrays for the letters and counters for those letters
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0 , j = 0 ,k = 0 , l = 0, m = 0, n = 0, o = 0 ,p = 0 , q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0;
		int[] letterCounters = {a, b, c, d, e, f, g, h, i , j ,k , l, m, n, o ,p , q, r, s, t, u, v, w, x, y, z};
		String[] letters = {
				"a",
				"b", 
				"c", 
				"d", 
				"e", 
				"f",
				"g",
				"h",
				"i",
				"j",
				"k",
				"l",
				"m",
				"n",
				"o" ,
				"p" ,
				"q", 
				"r",
				"s" , 
				"t",
				"u",
				"v",
				"w",
				"x",
				"y",
				"z"
				 };
		int biggestLength=0;
		int averageWordLength =0;
		//Create an arrayList for the length of each word
		ArrayList<Integer> averageWordLengthArray = new ArrayList<Integer>(234000);
		int qCounter=0;
		int biggestQCount = 0;
		
		try {
				//Create a buffered reader to extract text from said same file 
			    BufferedReader in = new BufferedReader(
				new FileReader("words.txt"));
			    String line = in.readLine();
			    //While there is still another line, do this loop
		        while (line!=null) {
		        	
		            String word = line;
		            int wordLength = word.length();
		            //Add the word length of each word to the ArrayList
		            averageWordLengthArray.add(wordLength);
		            //Make all the words lower case so we don't have to worry about case sensitivity
		            word.toLowerCase();
		            //Go through each letter in each word
		            for(int num =0; num < wordLength; num++)
		            {
		            	char character = word.charAt(num);
		            	for(int foo =0; foo < letters.length; foo++)
		            	{
		            		//Go through the array for each letter and if it's equal to a letter, add one to the counter for that letter
		            		if(String.valueOf(character).equals(letters[foo]))
		            		{
		            			letterCounters[foo]++;
		            		}
		            	}
		            	//If the letter is a Q add one to the Q counter
		            	if(String.valueOf(character).equals("q"))
	            		{
	            			qCounter++;
	            		}
		            }
		            //If the amount of Q's in the word is greater than the biggest found number of Q's in a word, set the biggest Q counter to the qCounter
		            if(qCounter > biggestQCount)
		            {
		            	biggestQCount = qCounter;
		            }
		            qCounter=0;
		            //Read the next line
		            line = in.readLine();
		        }
		        //Sort the arrays so that the letter that appears the most is at the first position
		        Arrays.sort(letterCounters);
		        //Sort the arrayList so that the biggest length is at the last position
		        Collections.sort(averageWordLengthArray);
		        biggestLength = averageWordLengthArray.get(averageWordLengthArray.size()-1);
		        int sum =0;
		        //Add together all the word lengths
		        for(int foo2 =0; foo2<averageWordLengthArray.size(); foo2++)
		        {
		        	sum+= averageWordLengthArray.get(foo2);
		        }
		        //Divide by the amount of words
		        averageWordLength = sum / averageWordLengthArray.size();
		        in.close(); 	//Close the resource
		        //Print out the results
		        System.out.println("Letter that appears the most: " + letters[0]);
		        System.out.println("Longest word: " + biggestLength);
		        System.out.println("Most Q's in a single word: " + biggestQCount);
		        System.out.println("Letter that appears the least: " + letters[letterCounters.length-1]);
		        System.out.println("Average letters in each word: "+ averageWordLength);
			} 
		    catch (FileNotFoundException exception) {
		        exception.printStackTrace();
		    }

	}

}
