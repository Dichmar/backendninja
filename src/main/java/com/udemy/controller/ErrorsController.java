package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorsController {
	
	public static final String ISE_VIEW = "error/500";
	public static final String ISE4_VIEW = "error/404";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerErrors() {
		return ISE_VIEW;
	}

}
