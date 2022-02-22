/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: This program creates a random number from 1 to 100 and prompts the user to guess that number.
 * As the user is guessing, the program narrows down the choices according to the previous user's guesses 
 * until the random number is guessed. 
 * Due: 02/21/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Renato Chavez
*/

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		// Declare the scanner input for reading value from the user
		Scanner input = new Scanner(System.in);
		// Declare the variables that will be used throughout the program
		int guess;
		int answer;
		// Call the RNG class that was provided to us
		answer = RNG.rand();
		int max = 100;
		int min = 0;

		// Prompt the user to enter the first guess
		System.out.println("Enter your first guess");
		guess = input.nextInt();
		System.out.println("Number of guesses is 1");
		while (guess != answer)
		{
			// Display the number of guesses by calling the getCount() method every time a new
			// guess is entered by the user
			if ((int)RNG.getCount() / 2 != 0)
				System.out.println("Number of guesses is " + (((int)RNG.getCount() / 2) + 1));
			// With the method inputValidation from the RNG class, set the max, min, and guess values
			while(!RNG.inputValidation(guess, min, max))
			{
				guess = input.nextInt();
			}
			// If the guess entered by the user is greater than the answer
			// Display that the answer is too high and set the guess as the new max
			if (guess > answer)
			{
				max = guess;
				System.out.println("Your guess is too high");
			}
			// If the guess entered by the user is smaller than the answer
			// Display that the answer is too low and set the guess as the new min
			else if (guess < answer)
			{
				min = guess;
				System.out.println("Your guess is too low");
			}
		}
		
		// If the guess is the answer, display the number of guesses and 
		// congratulate the user
		if (guess == answer)
		{
			System.out.println("Number of guesses is " + (((int)RNG.getCount() / 2) + 1));
			System.out.println("Congratulations, you guessed correctly");
			// Ask the user if they would like to play again 
			System.out.println("Try again? (enter 1 for yes or 2 for no)");
			// If they want to play again, reset the count with resetCount() method and repeat the driver program
			if (input.nextInt() == 1)
			{
				RNG.resetCount();
				main(args);
			}
			// if the user does not want to play again, thank the user, display the name of the programmer, and
			// terminate the running thread
			else 
			{
				System.out.println("Thanks for playing...");
				System.out.println("\nProgrammer: Renato Chavez");
				System.exit(0);
			}
			
		}
		
	}
	
}
