package org.navaneet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
//		System.out.println("This test ran");
		MathUtils mathUtiles = new MathUtils();
		int expected = 2;
		int actual = mathUtiles.add(1, 1); // change (1, 2) for test error
		assertEquals(expected, actual, "The Add method should add 2 numbers");
		
	}

	@Test
	void testComputeCircleArea() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "should return the area of circle");
		
	}
	
}
