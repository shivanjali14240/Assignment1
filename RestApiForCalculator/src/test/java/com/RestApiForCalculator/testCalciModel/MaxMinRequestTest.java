package com.RestApiForCalculator.testCalciModel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.RestApiForCalculator.model.MaxMinRequest;

public class MaxMinRequestTest {
	@Test
	public void testGetNumbers() {
		MaxMinRequest request = new MaxMinRequest();
		int[] numbers = { 1, 2, 3 };
		request.setNumbers(numbers);
		assertArrayEquals(numbers, request.getNumbers());
	}
}
