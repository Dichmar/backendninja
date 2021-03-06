package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";

	@GetMapping("/exampleString") 
	@RequestMapping(value="/exampleString")
	public String exampleString() {
		return "example";
	}
	
	@RequestMapping(value="exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		return new ModelAndView("example");
	}
	
	//@GetMapping("/exampleString") == @RequestMapping(value="exampleMAV", method=RequestMethod.GET)
}
