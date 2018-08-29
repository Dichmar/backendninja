package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

	public static final String VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//Redireccionar: forma 1
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}
	
	//Redireccionar: forma 2
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
//		int result = 6 / 0;
		model.addAttribute("person", new Person());
		return VIEW;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addPersona(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: -- addPerson -- PARAMS: -- '"+person+"' --");
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(VIEW);
			LOGGER.info("VIEW: -- '"+VIEW+"' -- PARAMS: -- '"+person+"' --");
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
			LOGGER.info("VIEW: -- '"+RESULT_VIEW+"' -- PARAMS: -- '"+person+"' --");
		}
		return mav;
	}
}
