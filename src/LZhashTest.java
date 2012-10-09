import static org.junit.Assert.*;

import org.junit.Test;

import java.security.SecureRandom;

public class LZhashTest {

	@Test
	public void testEncode() {
		ILZ encoder = new LZhash();
		String test = "";
		String result = "";
		SecureRandom r = new SecureRandom();
		int j;
		
		try
		{
			for(int attempts = 0; attempts < 5; attempts++)
			{
				for(int i = 1; i < 1000; i++)
				{
					for(j = 0; j < i; j++)
						test += r.nextInt(1);
					result = encoder.encode(test);
					assertEquals("Incorrect encoding!", test, LZDecoder.decode(result));
					test = "";
					result = "";
				}
			}
		}
		catch(Exception e)
		{
			System.err.printf("An exception occurred: %s\n", e.getMessage());
			System.err.printf("Input string was: %s, Output string was: %s\n", test, result);
			fail("An uncaught exception occurred!");
		}
	}
	
	@Test
	public void testEmptyString()
	{
		ILZ encoder = new LZhash();
		assertEquals("Empty string should encode to '0'", "0",encoder.encode(""));
	}

	
}
