import java.util.*;
import java.util.stream.*;

/**
 * Text analysis program that performs various operations on user text.
 * Users can count characters, words, and unique words, find the most common character,
 * check character or word frequency, insert new text without resetting the program, and exit the program.
 *
 * @author Liam-York Robertson
 */
public class StringManipulation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // used for user inputs
		System.out.println("Welcome to the Text Analysis Tool\n");
		System.out.println("Please insert the text you would like to analyse:");
		StringBuilder userInput = new StringBuilder(s.nextLine());
		while (true) {
			System.out.println("\nSelect one of the analysis options below:\n");
			System.out.println("1. Character Count");
			System.out.println("2. Word Count");
			System.out.println("3. Most Common Character");
			System.out.println("4. Character Frequency");
			System.out.println("5. Word Frequency");
			System.out.println("6. Unique Words");
			System.out.println("7. Analyse New Text");
			System.out.println("8. Exit\n");
			System.out.println("Enter choice: ");
			try {
				int userChoice1 = s.nextInt();
				s.nextLine(); // consumes above, otherwise case 7 consumes the newline
				System.out.println();
				switch (userChoice1) {
					case 1 -> {
						int charCount = characterCount(userInput);
						System.out.println("Character count of your text (including spaces, punctuation, and special characters): " + charCount);
					}
					case 2 -> {
						int wordCount = wordCount(userInput);
						System.out.println("Word count of your text is: " + wordCount);
					}
					case 3 -> {
						char commonChar = mostCommonCharacter(userInput);
						System.out.println("The most common character in your text is: " + commonChar);
					}
					case 4 -> {
						System.out.println("Please insert the character you would like to check the frequency of"
								+ " (including spaces, punctuation, and special characters): ");
						try {
							char userChar = s.next().charAt(0);
							int charCount = characterFrequency(userInput, userChar);
							System.out.println("\nThe character (" + userChar + ") appears " + charCount + " times");
						} catch (Exception e) {
							System.out.println("Invalid input. Enter one character");
						}
					}
					case 5 -> {
						System.out.println("Please insert the word you would like to check the frequency of: ");
						try {
							String userWord = s.nextLine();
							int wordCount = wordFrequency(userInput, userWord);
							System.out.println("\nThe word (" + userWord + ") appears " + wordCount + " times");
						} catch (Exception e ) {
							System.out.println("Invalid input. Enter one word");
						}
					}
					case 6 -> {
						int uniqueWords = uniqueWords(userInput);
						System.out.println("There are " + uniqueWords + " unique words in your text");
					}
					case 7 -> {
	                    System.out.println("Insert the new Text you would like to analyse:");
	                    userInput = new StringBuilder(s.nextLine());
	                }
					case 8 -> {
						System.out.println("Thank you for using the program!");
						System.exit(0);
					}
					default -> {
						System.out.println("Invalid input. Insert a number between 1 and 8");
					}
				}
			} catch (Exception e) {
				System.out.println("Insert a number between 1 and 8");
				s.nextLine(); // consumes invalid input, otherwise there would be an infinite loop
			}
		}
	}
	
	/**
     * Counts the number of characters in the user's text, including spaces, special characters and punctuation.
     * 
     * @param text user input text
     * @return total character count
     */
	private static int characterCount(StringBuilder text) {
		return (text.length());
	}
	
	/**
     * Counts the number of words in the user's text.
     * 
     * @param text user input text
     * @return total word count
     */
	private static int wordCount(StringBuilder text) {
		String[] userWords = text.toString().split(" ");
		return (userWords.length);
	}
	
	/**
     * Finds the most common character in the user's text, excluding spaces.
     * 
     * @param text user input text
     * @return most frequently occurring character
     */
	private static char mostCommonCharacter(StringBuilder text) {
		String basicString = text.toString().trim().replaceAll(" ", "").toLowerCase();
		String[] arrayOfChar = basicString.split("");
		char charMax = ' ';
		int count = 0;
		
		for (int i = 0; i < arrayOfChar.length; i++) {
			int tempCount = 0;
			for (int j = 0; j < arrayOfChar.length; j++) {
				if (arrayOfChar[i].equals(arrayOfChar[j])) {
					tempCount++;
				}
			}
			if (tempCount > count) {
				count = tempCount;
				charMax = arrayOfChar[i].charAt(0);
			}
		}
		
		return (charMax);
	}
	
	/**
     * Counts the frequency of a specific character in the user's text (case-insensitive).
     * 
     * @param text user's input text
     * @param c character to count
     * @return frequency of the character
     */
	private static int characterFrequency(StringBuilder text, char c) {
		String basicString = text.toString().trim().replaceAll(" ", "").toLowerCase();
		String[] arrayOfChar = basicString.split("");
		String newC = Character.toString(c).toLowerCase();
		
		int count = 0;
		
		for (int i = 0; i < arrayOfChar.length; i++) {
			if (arrayOfChar[i].equals(newC)) {
				count++;
			}
		}
		
		return (count);
	}
	
	/**
     * Counts the frequency of a specific word in the user's text (case-insensitive).
     * 
     * @param text user input text
     * @param userWord word to count
     * @return frequency of the word
     */
	private static int wordFrequency(StringBuilder text, String userWord) {
		String basicString = text.toString().trim().toLowerCase();
		String[] stringArray = basicString.split("\\W+");
		String newString = userWord.toLowerCase();
		
		int count = 0;
		
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].equals(newString)) {
				count++;
			}
		}
		
		return (count);
	}
	
	/**
     * Counts the number of unique words in the user's text (case-insensitive).
     * 
     * @param text user input text
     * @return count of unique words
     */
	private static int uniqueWords(StringBuilder text) {
		String basicString = text.toString().trim().toLowerCase();
		String[] stringArray = basicString.split("\\W+");
		List<String> removedDuplicates = Arrays.stream(stringArray)
				.distinct()
				.collect(Collectors.toList());
		
		int uniWords = removedDuplicates.size();
		
		return (uniWords);
	}
}