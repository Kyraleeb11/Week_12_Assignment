package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach //executed before each test method 
	void setUp() throws Exception {
		testDemo = new TestDemo(); //Initializes a new TestDemo instance
	}
    // Parameterized test method using data from argumentsForAddPositive method
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		 // If expectException is false, assert that the addition is correct
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
            // If expectException is true, expect an IllegalArgumentException
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class).hasMessage("Both parameters must be positive!");
		}
	}
    // Static method providing test data for the parameterized test
	static Stream<Arguments> argumentsForAddPositive() {
	    return Stream.of(
	        arguments(2, 4, 6, false),
	        arguments(0, 0, 0, true), // Adjusted for zero as a valid input
	        arguments(-2, 3, 1, true)
	    );
	}
	@Test
	 void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        // Additional test logic for pairs of positive numbers
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
        assertThat(testDemo.addPositive(7, 8)).isEqualTo(15);
        assertThat(testDemo.addPositive(15, 25)).isEqualTo(40);
	}
	// Testing the isPrime method
    @Test
    void testIsPrime() {
        // Test for a prime number
        assertTrue(testDemo.isPrime(7), "7 should be prime");

        // Test for a non-prime number
        assertFalse(testDemo.isPrime(9), "9 should not be prime");

        // Test for 1 (not a prime number)
        assertFalse(testDemo.isPrime(1), "1 should not be prime");

        // Test for a negative number (not a prime number)
        assertFalse(testDemo.isPrime(-5), "-5 should not be prime");
    }
    @Test
    void assertThatNumberSquaredIsCorrect() {
        // Create a spy of the TestDemo class. This is created to partially mock the object, allowing to control the behavior of specific methods. 
        TestDemo testDemo = new TestDemo();
        TestDemo mockDemo = spy(testDemo);

        // Mock the getRandomInt method to always return 5. When getRandomInt is called on mockDemo, it will return 5 regardless of it's actual implementation
        doReturn(5).when(mockDemo).getRandomInt();

        // Call the method under test (randomNumberSquared). Since getRandomInt has been mocked to return 5, the behavior of randomNumberSquared will be 
        //influenced by this mock
        int fiveSquared = mockDemo.randomNumberSquared();

        //This checks that the value of fiveSquared is equal to the expected value of 25.
        assertThat(fiveSquared).isEqualTo(25);
}
}
