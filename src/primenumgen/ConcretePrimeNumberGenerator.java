package primenumgen;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the <code>PrimeNumberGenerator</code> interface.
 * 
 * @author John D'Alessandro
 * @version 30-Nov-2021
 */
public class ConcretePrimeNumberGenerator implements PrimeNumberGenerator
{
	/**
	 * Generates all of the prime numbers between <code>startingValue</code> and <code>endingValue</code>, inclusive of both endpoints.
	 * 
	 * @param startingValue the first value to check for primeness
	 * @param endingValue the last value to check for primeness
	 * @return a list of all primes between <code>startingValue</code> and <code>endingValue</code>, inclusive of both endpoints
	 */
	@Override
	public List<Integer> generate(int startingValue, int endingValue)
	{
		List<Integer> primes = new ArrayList<>();
		// swap startingValue and endingValue if needed so that startingValue <= endingValue
		if (startingValue > endingValue)
		{
			int temp = endingValue;
			endingValue = startingValue;
			startingValue = temp;
		}
		for (int i = startingValue; i <= endingValue; i++)
			if (isPrime(i))
				primes.add(i);
		return primes;
	}

	/**
	 * Checks whether the given value is prime.
	 * 
	 * @param value the value to check for primeness
	 * @return <code>true</code> if <code>value</code> is prime, <code>false</code> otherwise
	 */
	@Override
	public boolean isPrime(int value)
	{
		if (value <= 1)
			return false;
		// 2 is the only even prime
		if (value % 2 == 0)
			return value == 2;
		// given any integers a and b such that a * b == value, we know that a <= Math.sqrt(value) || b <= Math.sqrt(value) must be true,
		// so we only need to check the odd integers <= Math.sqrt(value) for divisibility in order to establish whether value is prime
		for (int test = 3; test <= Math.sqrt(value); test += 2)
			if (value % test == 0)
				return false;
		// if value is odd and not divisible by any odd number <= Math.sqrt(value), value must be prime
		return true;
	}

}
