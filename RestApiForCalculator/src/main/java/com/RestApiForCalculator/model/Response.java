package com.RestApiForCalculator.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object answer;
	private String details;
	private int max;
	private int min;

	public Response(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(" [");

        if (answer != null) {
            stringBuilder.append("answer=").append(answer).append(", ");
        }

        if (details != null) {
            stringBuilder.append("details=").append(details).append(", ");
        }

        if (max != 0) {
            stringBuilder.append("max=").append(max).append(", ");
        }

        if (min != 0) {
            stringBuilder.append("min=").append(min);
        }

        if (stringBuilder.charAt(stringBuilder.length() - 2) == ',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
