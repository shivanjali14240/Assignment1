package com.RestApiForCalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxMinRequest {
	@JsonProperty("numbers")
	private int[] numbers;
}
