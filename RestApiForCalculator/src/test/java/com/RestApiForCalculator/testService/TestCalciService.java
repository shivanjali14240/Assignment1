package com.RestApiForCalculator.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.service.CalciServiceImpl;

@SpringBootTest
public class TestCalciService {
	@InjectMocks
	private CalciServiceImpl calciService;

	@Test
	public void testAdd() {
		int result = calciService.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	public void testSub() {
		int result = calciService.substract(3, 1);
		assertEquals(2, result);
	}

	@Test
	public void testMultiply() {
		int result = calciService.multiply(2, 2);
		assertEquals(4, result);
	}

	@Test
	public void testDivison() {
		double result = calciService.divison(6.0, 2.0);
		assertEquals(3.0, result, 0.001); // The third parameter is the delta for double comparison
	}

	@Test
	public void testSquare() {
		int num = 5;
		int result = calciService.square(num);
		assertEquals(25, result);
	}

	@Test
	public void testSquareRoot() {
		int num = 25;
		int result = calciService.squareRoot(num);
		assertEquals(5, result);
	}

	@Test
	public void testSquareRootWithNegativeNumber() {

		int num = -5;

		assertThrows(IllegalArgumentException.class, () -> calciService.squareRoot(num));
	}

	@Test
	public void testFactorial() {

		int num = 5;

		long result = calciService.factorial(num);

		assertEquals(120L, result);
	}

	@Test
	public void testFactorialWithNegativeNumber() {

		int num = -5;

		assertThrows(IllegalArgumentException.class, () -> calciService.factorial(num));
	}

	 @Test
	    public void testMaxMinWithValidInput() {
	        int[] numbers = {23, 11, 45, 7, 36};
	       

	        Response result = calciService.maxMin(numbers);

	        assertEquals(45, result.getMax());
	        assertEquals(7, result.getMin());
	    }

	    @Test
	    public void testMaxMinWithEmptyInput() {
	        int[] numbers = {};
	        
	        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
	            () -> calciService.maxMin(numbers)
	        );

	        assertEquals("Input array is empty", exception.getMessage());
	    }
	}
