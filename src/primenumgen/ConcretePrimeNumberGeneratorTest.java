package primenumgen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcretePrimeNumberGeneratorTest
{
	ConcretePrimeNumberGenerator generator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		generator = new ConcretePrimeNumberGenerator();
	}
	
	@Test
	void test1IsNotPrime()
	{
		assertEquals(false, generator.isPrime(1));
	}
	
	@Test
	void test0IsNotPrime()
	{
		assertEquals(false, generator.isPrime(0));
	}
	
	@Test
	void testNegativeNumberIsNotPrime()
	{
		assertEquals(false, generator.isPrime(-5));
	}

	@Test
	void test2IsPrime()
	{
		assertEquals(true, generator.isPrime(2));
	}

	@Test
	void testEvenOtherThan2IsNotPrime()
	{
		assertEquals(false, generator.isPrime(6));
	}
	
	@Test
	void test3IsPrime()
	{
		assertEquals(true, generator.isPrime(3));
	}
	
	@Test
	void test7IsPrime()
	{
		assertEquals(true, generator.isPrime(7));
	}
	
	@Test
	void testSquareOfPrimeIsNotPrime()
	{
		assertEquals(false, generator.isPrime(9));
	}
	
	@Test
	void testProductOfPrimesIsNotPrime()
	{
		assertEquals(false, generator.isPrime(35));
	}
	
	@Test
	void testGenerateFunctionReturnsList()
	{
		assertTrue(generator.generate(0, 0) instanceof List<?>);
	}
	
	@Test
	void testGenerateFunctionReturnsAllPrimesInRange()
	{
		List<Integer> expected = Arrays.asList(new Integer[] {7901, 7907, 7919});
		assertEquals(expected, generator.generate(7900, 7920));
	}
	
	@Test
	void testGenerateAccuratelyComputesSmallPrimes()
	{
		List<Integer> expected = Arrays.asList(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101});
		assertEquals(expected, generator.generate(0, 102));
	}
	
	@Test
	void testRangeContainingNoPrimes()
	{
		assertTrue(generator.generate(90, 95).isEmpty());
	}
	
	@Test
	void testOrderOfGenerateArgsEquivalent()
	{
		assertEquals(generator.generate(7900, 7920), generator.generate(7920, 7900));
	}
	
	@Test
	void testEqualArgsWhenPrime()
	{
		List<Integer> expected = Arrays.asList(new Integer[] {7});
		assertEquals(expected, generator.generate(7, 7));
	}
	
	@Test
	void testEqualArgsNotPrime()
	{
		assertTrue(generator.generate(15, 15).isEmpty());
	}
}
