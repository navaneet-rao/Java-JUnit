package org.navaneet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
//import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class MathUtilsTest {

	MathUtils mathUtiles;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("this needs to run before all");
	}

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println("");
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " With Tags " + testInfo.getTags());
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
	@Tag("Math")
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
	@DisplayName("multiplation method")
	@Tag("Math")
	void testMulti() {
//		assertEquals(4, mathUtiles.mul(2, 2), "should return the right product");
		assertAll(() -> assertEquals(4, mathUtiles.mul(2, 2)), () -> assertEquals(0, mathUtiles.mul(2, 0)),
				() -> assertEquals(-2, mathUtiles.mul(2, -1)));
	}

	@Test
//	@EnabledOnOs(OS.LINUX)
	@EnabledOnOs(OS.WINDOWS)
	@Tag("Math")
	void testDiv() {
//		MathUtils mathUtiles = new MathUtils();
		boolean isServerUp = false;
		assumeTrue(isServerUp); // will skip when false
		assertThrows(ArithmeticException.class, () -> mathUtiles.div(1, 0), "divid by zero should throw error");
	}

//	@Test
	@RepeatedTest(3)
	void testComputeCircleArea(RepetitionInfo repetitionInfo) {
//		MathUtils mathUtils = new MathUtils();
//		repetitionInfo.
		assertEquals(314.1592653589793, mathUtiles.computeCircleArea(10), "should return the area of circle");
	}

	@Test
	@Disabled
	@DisplayName("This method should not run")
	@Tag("Circle")
	void testDisabled() {
		fail("This test should be disabled");
	}

}
