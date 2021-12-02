package primenumgen;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class for the prime number generator.
 * 
 * @author John D'Alessandro
 * @version 30-Nov-2021
 */
public class PrimeNumberDriver
{
	/**
	 * Scanner used to get input from the keyboard.
	 */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Prompts the user to enter an integer, repeating the prompt if a non-integer is entered.
	 * 
	 * @param prompt the message to display to the user
	 * @return the integer entered by the user
	 */
	public int getIntInput(String prompt)
	{
		boolean validInput = false;
		int input = 0;
		do
		{
			System.out.print(prompt);
			try
			{
				input = in.nextInt();
				// clear the trailing newline from the input buffer
				in.nextLine();
				validInput = true;
			}
			catch (InputMismatchException e)
			{
				// clear anything that might be leftover in the input buffer
				in.nextLine();
				System.out.println("Please enter an integer.");
			}
		} while (!validInput);
		return input;
	}
	
	/**
	 * Runs the program.
	 */
	public void run()
	{
		ConcretePrimeNumberGenerator generator = new ConcretePrimeNumberGenerator();
		int startValue = getIntInput("Enter the starting value: ");
		int endValue = getIntInput("Enter the ending value: ");
		List<Integer> primes = generator.generate(startValue, endValue);
		if (primes.isEmpty())
			System.out.printf("There are no prime numbers between %d and %d.%n", startValue, endValue);
		else
		{
			System.out.printf("The prime numbers between %d and %d are:%n", startValue, endValue);
			for (Integer i : primes)
				System.out.println(i);
		}
	}
	
	public static void main(String[] args)
	{
		new PrimeNumberDriver().run();
	}
}
