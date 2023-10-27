package com.RestApiForCalculator.service;

import org.springframework.stereotype.Service;

import com.RestApiForCalculator.model.Response;

@Service
public interface CalciService {
	int add(int num1, int num2);

	int substract(int num1, int num2);

	int multiply(int num1, int num2);

	double divison(double num1, double num2);

	int square(int num);

	int squareRoot(int num);

	long factorial(int num);

	Response maxMin(int[] numbers);

}
