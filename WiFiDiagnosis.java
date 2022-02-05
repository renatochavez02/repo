/*
 * Class: CMSC203 
 * Assignment: #1
 * Instructor: Ahmed Tarek
 * Description: This program steps through some problems with Internet connectivity.
 * 				Assuming the user's computer uses WiFi that connects to a router which connects to an 
 * 				Internet Service Provider (ISP) which connects to the Internet. We will go through some 
 * 				potential solutions to the problem depending on the user's input.
 * Due: 2/7/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Renato Chavez
*/

import java.util.Scanner;

public class WiFiDiagnosis {

	public static void main(String[] args) {
		// Declare the input that will be used to get answers from the user
		Scanner input = new Scanner(System.in);
		// Display the message that will star guiding the user through steps
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis"
				+ " might work.");
		// Display the first step and ask the user if the problem is solved
		System.out.println("\nFirst step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		String answer1 = input.nextLine();
		/* With the switch statement, if the user solved the problem, end the program, 
		if it did not solve the problem, continue with step 2, and if a invalid entry is entered,
		display an error message*/
		switch (answer1)
		{
			// User solved the problem, end program
			case "yes":
				System.out.println("Rebooting your computer seemed to work.");
				System.out.println("Programmer: Renato Chavez");
				return;
			// User did not solve the problem, proceed with step 2
			case "no":
				break;
			// An invalid entry is entered, display an error message and end the program
			default:
				System.out.println("Invalid entry.");
				System.out.println("Programmer: Renato Chavez");
				return;
		}
		// Assuming the user did not solve the answer, repeat process with step 2.
		System.out.println("Second step: reboot your router");
		System.out.println("Now are you able to connect with the internet? (yes or no)");
		String answer2 = input.nextLine();
		switch (answer2)
		{
			case "yes":
			System.out.println("Rebooting your router seemed to work.");
			System.out.println("Programmer: Renato Chavez");
			return;
			case "no":
			break;
			default:
			System.out.println("Invalid entry.");
			System.out.println("Programmer: Renato Chavez");
			return;
		}
		// If the user still not able to solve the problem, proceed with step 3 with the same idea
		System.out.println("Third step: make sure the cables to your router are plugged in firmly and your "
				+ "router is getting power");
		System.out.println("Now are you able to connect with the internet? (yes or no)");
		String answer3 = input.nextLine();
		switch (answer3)
		{
			case "yes":
			System.out.println("Making sure the cables to your router are plugged in firmly and your router"
					+ "is getting power seemed to work.");
			System.out.println("Programmer: Renato Chavez");
			return;
			case "no":
			break;
			default:
			System.out.println("Invalid entry.");
			System.out.println("Programmer: Renato Chavez");
			return;
		}
		// The user is still not able to solve the wifi problem, proceed with a fourth step with the same idea
		System.out.println("Fourth step: move your computer closer to your router");
		System.out.println("Now are you able to connect with the internet? (yes or no)");
		String answer4 = input.nextLine();
		switch (answer4)
		{
			case "yes":
			System.out.println("Moving your computer closer to your router seemed to work.");
			System.out.println("Programmer: Renato Chavez");
			return;
			case "no":
			break;
			default:
			System.out.println("Invalid entry.");
			System.out.println("Programmer: Renato Chavez");
			return;
		}
		// Finally, is the user cannot solve the problem with any step, suggest contacting the user's ISP
		// And end the program
		System.out.println("Fifth step: Contact your ISP");
		System.out.println("Make sure your ISP is hooked up to your router.");
		System.out.println("Programmer: Renato Chavez");
	}

}
