package org.navaneet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	MathUtils mathUtiles;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("this needs to run before all");
	}
	
	@BeforeEach
	void init() {
		mathUtiles = new MathUtils();
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up....");
	}

	@Test
	void testAdd() {
//		System.out.println("This test ran");
//		MathUtils mathUtiles = new MathUtils();
		int expected = 2;
		int actual = mathUtiles.add(1, 1); // change (1, 2) for test error
		assertEquals(expected, actual, "The Add method should add 2 numbers");
	}

	@Test
	void testDiv() {
//		MathUtils mathUtiles = new MathUtils();
		assertThrows(ArithmeticException.class, () -> mathUtiles.div(1, 0), "divid by zero should throw error");
	}

	@Test
	void testComputeCircleArea() {
//		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtiles.computeCircleArea(10), "should return the area of circle");
	}

}
