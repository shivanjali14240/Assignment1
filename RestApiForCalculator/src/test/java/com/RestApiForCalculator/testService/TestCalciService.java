package com.RestApiForCalculator.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.RestApiForCalculator.model.RequestResponseTimestampEntity;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.repository.CalciRepo;
import com.RestApiForCalculator.service.CalciServiceImpl;

@SpringBootTest
public class TestCalciService {
	@Autowired
	private CalciServiceImpl calciService;

	@MockBean
	private CalciRepo calciRepo;

	@Test
	void testAdd() {
		int result = calciService.add(3, 4);
		assertEquals(7, result);
	}

	@Test
	void testSubtract() {
		int result = calciService.substract(8, 3);
		assertEquals(5, result);
	}

	@Test
	void testMultiply() {
		int result = calciService.multiply(5, 6);
		assertEquals(30, result);
	}

	@Test
	void testDivision() {
		double result = calciService.divison(10.0, 2.0);
		assertEquals(5.0, result, 0.0001);
	}

	@Test
	void testDivisionByZero() {
		assertThrows(IllegalArgumentException.class, () -> calciService.divison(10.0, 0.0));
	}

	@Test
	void testSquare() {
		int result = calciService.square(4);
		assertEquals(16, result);
	}

	@Test
	void testSquareRoot() {
		int result = calciService.squareRoot(9);
		assertEquals(3, result);
	}

	@Test
	void testSquareRootOfNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () -> calciService.squareRoot(-4));
	}

	@Test
	void testFactorial() {
		long result = calciService.factorial(5);
		assertEquals(120, result);
	}

	@Test
	void testFactorialOfNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () -> calciService.factorial(-3));
	}

	@Test
	void testMaxMin() {
		int[] numbers = { 4, 8, 2, 10, 5 };
		Response result = calciService.maxMin(numbers);
		assertEquals(10, result.getMax());
		assertEquals(2, result.getMin());
	}

	@Test
	void testMaxMinWithEmptyArray() {
		int[] numbers = {};
		assertThrows(IllegalArgumentException.class, () -> calciService.maxMin(numbers));
	}

	@Test
	void testSaveLog() {
		calciService.saveLog("testRequest", "testResponse");
		verify(calciRepo, times(1)).save(any(RequestResponseTimestampEntity.class));
	}
}
