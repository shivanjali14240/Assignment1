package com.RestApiForCalculator.testCalciController;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.RestApiForCalculator.CalciController;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.service.CalciService;

@WebMvcTest(CalciController.class)
public class TestCalciCalculator {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalciService calciService;

	@Test
	public void testAddition() throws Exception {
		int num1 = 4;
		int num2 = 2;
		int expectedResult = 6;
		when(calciService.add(num1, num2)).thenReturn(expectedResult);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculatorapi/v1/addition?num1=4&num2=2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(expectedResult))
				.andExpect(MockMvcResultMatchers.jsonPath("$.details").value("4+2=6"));

	}

	@Test
	public void testSubtraction() throws Exception {
		int num1 = 4;
		int num2 = 2;
		int expectedResult = 2;
		when(calciService.substract(num1, num2)).thenReturn(expectedResult);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculatorapi/v1/subtraction?num1=4&num2=2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(expectedResult))
				.andExpect(MockMvcResultMatchers.jsonPath("$.details").value("4-2=2"));
	}

	@Test
	public void testMultiplication() throws Exception {
		int num1 = 2;
		int num2 = 2;
		int expectedResult = 4;
		when(calciService.multiply(num1, num2)).thenReturn(expectedResult);
		mockMvc.perform(MockMvcRequestBuilders.get("/calculatorapi/v1/multiplication?num1=2&num2=2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(expectedResult))
				.andExpect(MockMvcResultMatchers.jsonPath("$.details").value("2*2=4"));

	}

	@Test
	public void testDivision() throws Exception {
		double num1 = 6.0;
		double num2 = 2.0;
		double expectedResult = 3.0;

		when(calciService.divison(num1, num2)).thenReturn(expectedResult);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculatorapi/v1/division?num1=6.0&num2=2.0"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(expectedResult))
				.andExpect(MockMvcResultMatchers.jsonPath("$.details").value("6.0/2.0=3.0"));
	}

	@Test
	public void testSquare() throws Exception {
		when(calciService.square(5)).thenReturn(25);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/calculatorapi/v1/square/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(25))
                .andExpect(MockMvcResultMatchers.jsonPath("$.details").value("square of 5=25"));
    
	}

	@Test
	public void testSquareroot() throws Exception {
		when(calciService.squareRoot(16)).thenReturn(4);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/calculatorapi/v1/squareroot/16")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.details").value("Squareroot of 16=4"));
    
	}

	@Test
	public void testFactorial() throws Exception {
		 when(calciService.factorial(5)).thenReturn(120L);

	        mockMvc.perform(MockMvcRequestBuilders
	                .get("/calculatorapi/v1/factorial/5")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(120))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.details").value("Factorial of 5=120"));
	    }

	@Test
	public void testMaxMin() throws Exception {
		int[] numbers = { 23, 11, 45, 7, 36 };
		Response expectedResponse = new Response(45, 7);

		when(calciService.maxMin(numbers)).thenReturn(expectedResponse);

		mockMvc.perform(MockMvcRequestBuilders.post("/calculatorapi/v1/max-min").contentType(MediaType.APPLICATION_JSON)
				.content("{\"numbers\":[23,11,45,7,36]}")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.max").value(45))
				.andExpect(MockMvcResultMatchers.jsonPath("$.min").value(7));
	}

	@Test
	public void testMaxMinWithEmptyInput() throws Exception {
		int[] numbers = {};
		String errorMessage = "Input array is empty";

		when(calciService.maxMin(numbers)).thenThrow(new IllegalArgumentException(errorMessage));

		mockMvc.perform(MockMvcRequestBuilders.post("/calculatorapi/v1/max-min").contentType(MediaType.APPLICATION_JSON)
				.content("{\"numbers\":[]}")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.details").value(errorMessage));
	}

}
