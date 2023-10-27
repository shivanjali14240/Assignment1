package com.RestApiForCalculator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class Response {

	private Object answer;
	private String details;
	private int max;
	private int min;

	public Response(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

}
