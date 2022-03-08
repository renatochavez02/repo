/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: This program encrypts and decrypts code using two different 
 * approaches; Caesar Cipher (substitution cipher) and Bellaso which uses a key word. 
 * This program will encrypt, or decrypt code as needed by the user with any of these approaches.
 * Due: 03/07/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Renato Chavez
*/
public class CryptoManager {
	
	// declare constant variables that will be used throughout the program in the different methods 
	private static final int LOWER_BOUND = 32;
	private static final int UPPER_BOUND = 95;
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// set the boolean to true 
		boolean flag = true;
		// create a for loop with iterations equal to the number of characters in the string 
		for(int i = 0; i < plainText.length(); i++)
		{
			// if a character on the string is less than the lower boundary or greater than the upper boundary set to false
			if(!((int)plainText.charAt(i) >= LOWER_BOUND && (int)plainText.charAt(i) <= UPPER_BOUND))
			{
				flag = false;
				break;
			}
					
		}
		// return the value of boolean
		return flag;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// call the method for wrapping around 
		key = Wrapping(key);
		// create an empty string that will be filled out
		String result = "";
		// create a for loop that will iterate the amount of times of characters within the string 
		for(int i = 0; i < plainText.length(); i++)
		{
			result += Character.toString((char)((int)plainText.charAt(i) + key));
		}
		// return the result
		return result;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// create an empty string 
		String result = "";
		// while the length is less than the string wrap around 
		while(bellasoStr.length() < plainText.length())
		{
			bellasoStr += bellasoStr.substring(0, (plainText.length() - bellasoStr.length()));
		}
		for(int i = 0; i < plainText.length(); i++)
		{
			char c = (char)Wrapping((int)plainText.charAt(i) + (int)bellasoStr.charAt(i));
			result += Character.toString(c);
		}
		// return result 
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// call the method for wrapping around a character outside of the range 
		key = Wrapping(key);
		// create an empty string 
		String org = "";
		// create a loop that iterates as many times as characters in the string
		for(int i = 0; i < encryptedText.length(); i++)
		{
			org += Character.toString((char)((int)encryptedText.charAt(i) - key));
		}
		// return result 
		return org;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// create an empty string to be filled out with characters
		String result = "";
		// while the length of bellaso is less than the string taken from user wrap around 
		while(bellasoStr.length() < encryptedText.length())
		{
			bellasoStr += bellasoStr.substring(0, (encryptedText.length() - bellasoStr.length()));
		}
		
		for(int i = 0; i < encryptedText.length(); i++)
		{
			char c = (char)Wrapping((int)encryptedText.charAt(i) - (int)bellasoStr.charAt(i));
			result += Character.toString(c);
		}
		// return result 
		return result;
	}
	
	/**
	 * This method will work when the numbers are larger than the upper bound
	 * so it can wrap around to get a number within the bounds 32 and 95
	 * @param key that is larger than the upper bound to be wrapped
	 * @return the key within the bounds
	 */
	public static int Wrapping(int key)
	{
		// if the key is greater than the upper bound wrap around the number so it is within the range 
		while(key > UPPER_BOUND)
		{
			key -= (UPPER_BOUND - LOWER_BOUND);
		}
		// return the wrapped key 
		return key;
	}

	

	
}