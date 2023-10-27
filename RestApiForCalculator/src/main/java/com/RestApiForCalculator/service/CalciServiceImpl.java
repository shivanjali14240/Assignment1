package com.RestApiForCalculator.service;

import org.springframework.stereotype.Service;

import com.RestApiForCalculator.model.Response;

@Service
public class CalciServiceImpl implements CalciService {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public double divison(double num1, double num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("Division of zero is not allowed");
		}
		return num1 / num2;
	}

	@Override
	public int square(int num) {
		return num * num;
	}

	@Override
	public int squareRoot(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("Square root of a negative number is not allowed.");
		}
		return (int) Math.sqrt(num);
	}

	@Override
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
}
