package com.igorqueiroz.teste;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Igor Queiroz
 * 
 * The present class goal is to find the most repeated sequence of characters among a given String.
 *
 */
public class Questao02 {
	
	/**
	 * Takes a String as parameters and iterates it searching for repeated characters, then returns the most repeated one.
	 * @param phrase
	 * @return
	 */
	static String searchMostRepeatedSequence(final String phrase) {
        String mostRepeated;
        if (phrase != null && phrase.length() > 0) {
            mostRepeated = "";
            final List<StringBuilder> sequences = new ArrayList<StringBuilder>();
            final int size = phrase.length();
            
            for (int i = 0; i < size; i++) {
                final char currentCharacter = phrase.charAt(i);
                StringBuilder sequence = new StringBuilder(i);
                sequence.append(currentCharacter);
                
                for (int k = i + 1; k < size; k++) {
                    final char proxCaracter = phrase.charAt(k);
                    
                    if (currentCharacter == proxCaracter) {
                        sequence.append(currentCharacter);
                    } else {
                        sequences.add(sequence);
                        break;
                    }
                }
            }
            for (StringBuilder sequence : sequences) {
                if (sequence.length() > mostRepeated.length()) {
                    mostRepeated = sequence.toString();
                }
            }
        } else {
            mostRepeated = "";
        }
        return mostRepeated;
    }

	public static void main(String[] args) {

		long startOfProcess = System.currentTimeMillis();
        final String phrase = "Programmmmmmmmmmmmmming in Java is suuuuuuuuuuuuuuuuupeer funnnnnnnnnnnnnnnnnnnnnnn ";
        
        System.gc();
        
        String result = searchMostRepeatedSequence(phrase);
        System.out.println("Most repeated: " + result + " with " + result.length() + " occurrences.");
        
        long endOfProcess = System.currentTimeMillis();
        System.out.println("Time spent: " + (endOfProcess - startOfProcess) + " miliseconds");
	}

}
