package primenumgen;

import java.util.List;

/**
 * Interface for a prime number generator.
 * 
 * @author John D'Alessandro
 * @version 30-Nov-2021
 */
public interface PrimeNumberGenerator
{
	/**
	 * Generates all of the prime numbers between <code>startingValue</code> and <code>endingValue</code>, inclusive of both endpoints.
	 * 
	 * @param startingValue the first value to check for primeness
	 * @param endingValue the last value to check for primeness
	 * @return a list of all primes between <code>startingValue</code> and <code>endingValue</code>, inclusive of both endpoints
	 */
	List<Integer> generate(int startingValue, int endingValue);
	
	/**
	 * Checks whether the given value is prime.
	 * 
	 * @param value the value to check for primeness
	 * @return <code>true</code> if <code>value</code> is prime, <code>false</code> otherwise
	 */
	boolean isPrime(int value);
}
