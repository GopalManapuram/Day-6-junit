package com.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class) // Enables test execution in a specific order
class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUP() {
		calculator = new Calculator(); // Initialize Calculator before each test
	}
	
	// Test Addition
	@Order(1)  // Highest priority (Lowest number = highest priority)
	@ParameterizedTest
	@CsvSource({
		"3, 5, 8",    // Two positives
		"-3, -5, -8", // Two negatives
		"0, 5, 5",    // Zero with positive
		"0, 0, 0"     // Zero with zero
	})
	void testAddition(int i, int j, int expected) {
		int result = calculator.add(i, j);
		assertEquals(expected, result, i + " + " + j + " should be " + expected);
	}

	// Test Subtraction
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"10, 5, 5",
		"-5, -3, -2",
		"0, 5, -5",
		"0, 0, 0"
	})
	void testSubtraction(int i, int j, int expected) {
		int result = calculator.subtract(i, j);
		assertEquals(expected, result, i + " - " + j + " should be " + expected);
	}

	// Test Multiplication
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"3, 5, 15",
		"-3, -5, 15",
		"0, 5, 0",
		"0, 0, 0"
	})
	void testMultiplication(int i, int j, int expected) {
		int result = calculator.multiply(i, j);
		assertEquals(expected, result, i + " * " + j + " should be " + expected);
	}

	// Test Division
	@Order(4)
	@ParameterizedTest
	@CsvSource({
		"10, 2, 5",
		"-10, -2, 5",
		"0, 5, 0"
	})
	void testDivision(int i, int j, int expected) {
		int result = calculator.divide(i, j);
		assertEquals(expected, result, i + " / " + j + " should be " + expected);
	}

	// Test Division by Zero
	@Order(5) // Lowest priority since it’s an exception test
	@Test
	void testDivisionByZero() {
		assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Division by zero should throw exception");
	}
}
