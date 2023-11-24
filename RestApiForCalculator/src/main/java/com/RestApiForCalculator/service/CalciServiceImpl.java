package com.RestApiForCalculator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.RestApiForCalculator.model.RequestResponseTimestampEntity;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.repository.CalciRepo;

import lombok.AllArgsConstructor;

@Service
public class CalciServiceImpl implements CalciService {

	@Autowired
	CalciRepo calcirepo;

	@Override
	@Cacheable(value = "CalculatorCache", key = "'addition:' + #num1 + ',' + #num2", unless = "#result == null")
	public int add(int num1, int num2) {

		return num1 + num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'substration:' + #num1 + ',' + #num2", unless = "#result == null")
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'multiplication:' +#num1 + ',' + #num2", unless = "#result == null")
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'division:' + #num1 + ',' + #num2", unless = "#result == null")
	public double divison(double num1, double num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("Division of zero is not allowed");
		}
		return num1 / num2;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'square:'+ #num", unless = "#result == null")
	public int square(int num) {
		return num * num;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'squareroot:'+#num", unless = "#result == null")
	public int squareRoot(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("Square root of a negative number is not allowed.");
		}
		return (int) Math.sqrt(num);
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'factorial:'+#num", unless = "#result == null")
	public long factorial(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("Factorial of a negative number is not allowed.");
		}
		long result = 1;
		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

	@Override
	@Cacheable(value = "CalculatorCache", key = "'maxMin:'+ #numbers", unless = "#result == null")
	public Response maxMin(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException("Input array is empty");
		}

		int max = numbers[0];
		int min = numbers[0];

		for (int num : numbers) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}

		return new Response(max, min);
	}

	public void saveLog(String request, String response) {
		RequestResponseTimestampEntity res = new RequestResponseTimestampEntity();
		res.setRequest(request);
		res.setResponse(response);
		res.setTimestamp(new java.util.Date());
		calcirepo.save(res);
	}


}
