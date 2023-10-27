package com.bnt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geetapi/v1")
public class MainController {

	@GetMapping("/hello")
	public String hello() {
		return"Hello World";
	}
	
	@RequestMapping(value="/hello",params = "name")
	public String helloName(@RequestParam("name") String name) {
		return"Hello "+name;
	}
}
