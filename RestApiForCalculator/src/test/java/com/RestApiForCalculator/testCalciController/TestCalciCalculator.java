package com.RestApiForCalculator.testCalciController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.RestApiForCalculator.CalciController;
import com.RestApiForCalculator.model.MaxMinRequest;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.service.CalciServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCalciCalculator {

	@Mock
	private CalciServiceImpl calciService;

	@InjectMocks
	private CalciController calciController;

	@Test
	void addition() {
		int num1 = 5;
		int num2 = 10;
		int expectedResult = 15;

		when(calciService.add(num1, num2)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.addition(num1, num2);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).add(num1, num2);
		verify(calciService, times(1)).saveLog(eq(num1 + ", " + num2), anyString());
	}

	@Test
	void subctraction() {
		int num1 = 10;
		int num2 = 5;
		int expectedResult = 5;

		when(calciService.substract(num1, num2)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.subtraction(num1, num2);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).substract(num1, num2);
		verify(calciService, times(1)).saveLog(eq(num1 + ", " + num2), anyString());
	}

	@Test
	void multiplication() {
		int num1 = 5;
		int num2 = 10;
		int expectedResult = 50;

		when(calciService.multiply(num1, num2)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.multiplication(num1, num2);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).multiply(num1, num2);
		verify(calciService, times(1)).saveLog(eq(num1 + ", " + num2), anyString());
	}

	@Test
	void testDivision() {
		double num1 = 10;
		double num2 = 2;
		double expectedResult = 5;

		when(calciService.divison(num1, num2)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.division(num1, num2);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).divison(num1, num2);
		verify(calciService, times(1)).saveLog(eq(num1 + ", " + num2), anyString());
	}

	@Test
	void squareRoot() {
		int num = 25;
		int expectedResult = 5;

		when(calciService.squareRoot(num)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.squareRoot(num);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).squareRoot(num);
		verify(calciService, times(1)).saveLog(eq("num"), anyString());
	}

	@Test
	void factorial() {
		int num = 5;
		long expectedResult = 120;

		when(calciService.factorial(num)).thenReturn(expectedResult);

		ResponseEntity<Response> responseEntity = calciController.factorial(num);

		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());

		Response responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals(expectedResult, responseBody.getAnswer());

		verify(calciService, times(1)).factorial(num);
		verify(calciService, times(1)).saveLog(eq("num"), anyString());
	}

	@Test
	void maxMin() {
		int[] numbers = { 3, 7, 1, 9, 5 };
		Response expectedResponse = new Response();
		expectedResponse.setAnswer(9);
		expectedResponse.setDetails("Max: 9, Min: 1");

		when(calciService.maxMin(numbers)).thenReturn(expectedResponse);

		Response actualResponse = calciController.maxMin(new MaxMinRequest(numbers));

		assertNotNull(actualResponse);
		assertEquals(expectedResponse.getAnswer(), actualResponse.getAnswer());
		assertEquals(expectedResponse.getDetails(), actualResponse.getDetails());

		verify(calciService, times(1)).maxMin(numbers);
		verify(calciService).saveLog(eq("[3, 7, 1, 9, 5]"), eq(" [answer=9, details=Max: 9, Min: 1 ]"));
	}

}
