package com.scott.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyMultiplyTest {

	@Test
	public void testMultiply() {
		assertEquals(200, new MyMultiply(100,2).multiply());
		// fail("Not yet implemented");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		//int result;
		MyMultiply test = new MyMultiply(200, 1);
		System.out.print(test.multiply());
		
	}
	

}
