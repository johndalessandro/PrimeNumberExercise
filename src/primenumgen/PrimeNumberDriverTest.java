package primenumgen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeNumberDriverTest
{
	PrimeNumberDriver driver;
	
	ByteArrayOutputStream stdoutReceiver;
	
	@BeforeEach
	void setUp() throws Exception
	{
		stdoutReceiver = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdoutReceiver, true));
	}

	@Test
	void testValidIntInput()
	{
		System.setIn(new ByteArrayInputStream("7\n".getBytes()));
		// can't create the driver until after stdin has been redirected
		driver = new PrimeNumberDriver();
		assertEquals(7, driver.getIntInput("Enter an integer: "));
	}

	@Test
	void testRejectFloatInput()
	{
		System.setIn(new ByteArrayInputStream("5.5\n7\n".getBytes()));
		driver = new PrimeNumberDriver();
		assertEquals(7, driver.getIntInput("Enter an integer: "));
	}
	
	@Test
	void testRejectAlphaInput()
	{
		System.setIn(new ByteArrayInputStream("foo\n7\n".getBytes()));
		driver = new PrimeNumberDriver();
		assertEquals(7, driver.getIntInput("Enter an integer: "));
	}
	
	@Test
	void testRejectEmptyStringInput()
	{
		System.setIn(new ByteArrayInputStream("\n7\n".getBytes()));
		driver = new PrimeNumberDriver();
		assertEquals(7, driver.getIntInput("Enter an integer: "));
	}
	
	@Test
	void testRestOfLineGobbled()
	{
		System.setIn(new ByteArrayInputStream("Here is an invalid input\n7\n".getBytes()));
		driver = new PrimeNumberDriver();
		assertEquals(7, driver.getIntInput("Enter an integer: "));
	}
	
	@Test
	void testMainMethodNonEmptyResult()
	{
		System.setIn(new ByteArrayInputStream("7900\n7920\n".getBytes()));
		PrimeNumberDriver.main(new String[] {});
		String expectedOutput = "Enter the starting value: Enter the ending value: "
				+ String.format("The prime numbers between 7900 and 7920 are:%n7901%n7907%n7919%n");
		assertEquals(expectedOutput, stdoutReceiver.toString());
	}
	
	@Test
	void testMainMethodEmptyResult()
	{
		System.setIn(new ByteArrayInputStream("90\n95\n".getBytes()));
		PrimeNumberDriver.main(new String[] {});
		String expectedOutput = "Enter the starting value: Enter the ending value: "
				+ String.format("There are no prime numbers between 90 and 95.%n");
		assertEquals(expectedOutput, stdoutReceiver.toString());
	}
}
