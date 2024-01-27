package org.navaneet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
//import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

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
	@DisplayName("Testing add method")
	void testAdd() {
//		System.out.println("This test ran");
//		MathUtils mathUtiles = new MathUtils();
		int expected = 2;
		int actual = mathUtiles.add(1, 1); // change (1, 2) for test error
		assertEquals(expected, actual, "The Add method should add 2 numbers");
	}

	@Nested
	@DisplayName("Add Method")
	class AddTest {
		@Test
		@DisplayName("When adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, mathUtiles.add(1, 1), "should return the right sum");
		}

		@Test
		@DisplayName("When adding two negative numbers")
		void testAddNegative() {
			assertEquals(-2, mathUtiles.add(-1, -1), "should return the right sum");
		}
	}

	@Test
//	@EnabledOnOs(OS.LINUX)
	void testDiv() {
//		MathUtils mathUtiles = new MathUtils();
		boolean isServerUp = false;
		assumeTrue(isServerUp); // will skip when false
		assertThrows(ArithmeticException.class, () -> mathUtiles.div(1, 0), "divid by zero should throw error");
	}

	@Test
	void testComputeCircleArea() {
//		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtiles.computeCircleArea(10), "should return the area of circle");
	}

	@Test
	@Disabled
	@DisplayName("This method should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}

}
