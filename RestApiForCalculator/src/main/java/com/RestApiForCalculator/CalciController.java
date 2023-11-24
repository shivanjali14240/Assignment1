package com.RestApiForCalculator;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiForCalculator.model.MaxMinRequest;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.service.CalciServiceImpl;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/calculatorapi/v1")
public class CalciController {

	@Autowired
	CalciServiceImpl CalciService;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(CalciController.class);

	@GetMapping("/addition")
	public ResponseEntity<Response> addition(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		int addition = CalciService.add(num1, num2);
		String details = num1 + "+" + num2 + "=" + addition;
		Response res = new Response();
		res.setAnswer(addition);
		res.setDetails(details);
		logger.info("Request: Addition, Num1: {}, Num2: {}. Response: {}", num1, num2, res);
		CalciService.saveLog(num1 + ", " + num2, res.toString());
		return ResponseEntity.ok(res);

	}

	@GetMapping("/subtraction")
	public ResponseEntity<Response> subtraction(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		int subtraction = CalciService.substract(num1, num2);
		String details = num1 + "-" + num2 + "=" + subtraction;
		Response res = new Response();
		res.setAnswer(subtraction);
		res.setDetails(details);
		logger.info("Request: subtraction, Num1: {}, Num2: {}. Response: {}", num1, num2, res);
		CalciService.saveLog(num1 + ", " + num2, res.toString());
		return ResponseEntity.ok(res);

	}

	@GetMapping("/multiplication")
	public ResponseEntity<Response> multiplication(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		int multiplication = CalciService.multiply(num1, num2);
		String details = num1 + "*" + num2 + "=" + multiplication;
		Response res = new Response();
		res.setAnswer(multiplication);
		res.setDetails(details);
		logger.info("Request: multiplication, Num1: {}, Num2: {}. Response: {}", num1, num2, res);
		CalciService.saveLog(num1 + ", " + num2, res.toString());
		return ResponseEntity.ok(res);

	}

	@GetMapping("/division")
	public ResponseEntity<Response> division(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {

		Response res = new Response();
		try {
			double division = CalciService.divison(num1, num2);
			String details = num1 + "/" + num2 + "=" + division;
			res.setAnswer(division);
			res.setDetails(details);
			logger.info("Request: division, Num1: {}, Num2: {}. Response: {}", num1, num2, res);
			CalciService.saveLog(num1 + ", " + num2, res.toString());
			return ResponseEntity.ok(res);
		} catch (IllegalArgumentException ex) {
			res.setDetails(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}

	}

	@GetMapping("/square/{num}")
	public ResponseEntity<Response> square(@PathVariable("num") int num) {
		int square = CalciService.square(num);
		Response response = new Response();
		response.setAnswer(square);
		response.setDetails("square of " + num + "=" + square);
		logger.info("Request: square, num: {}. Response: {}", num, response);
		CalciService.saveLog("num", response.toString());

		return ResponseEntity.ok(response);
	}

	@GetMapping("/squareroot/{num}")
	public ResponseEntity<Response> squareRoot(@PathVariable("num") int num) {
		Response response = new Response();
		try {
			int squareRoot = CalciService.squareRoot(num);
			response.setAnswer(squareRoot);
			response.setDetails("Squareroot of " + num + "=" + squareRoot);
			logger.info("Request: squareRoot, num: {}. Response: {}", num, response);
			CalciService.saveLog("num", response.toString());
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			response.setDetails(e.getMessage());
			return ResponseEntity.ok(response);
		}

	}

	@GetMapping("/factorial/{num}")
	public ResponseEntity<Response> factorial(@PathVariable("num") int num) {
		Response response = new Response();
		try {
			long fact = CalciService.factorial(num);
			response.setAnswer(fact);
			response.setDetails("Factorial of " + num + "=" + fact);
			logger.info("Request: factorial, num: {}. Response: {}", num, response);
			CalciService.saveLog("num", response.toString());
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			response.setDetails(e.getMessage());
			logger.error("Error in factorial : {}", response);
			return ResponseEntity.ok(response);
		}

	}

	@PostMapping("/max-min")
	public Response maxMin(@RequestBody MaxMinRequest request) {
		int[] numbers = request.getNumbers();
		try {
			Response response = CalciService.maxMin(numbers);
			logger.info("Request: MaxMin, Numbers: {}. Response:{}", Arrays.toString(numbers), response);
			CalciService.saveLog(Arrays.toString(numbers), response.toString());
			return response;
		} catch (IllegalArgumentException ex) {
			Response res = new Response();
			res.setDetails(ex.getMessage());
			logger.error("Error in MaxMin calculation: {}", res);
			return res;
		}
	}
}
