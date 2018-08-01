package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/datos")
public class MostrarDatosController {
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	//Plantilla html
	public static final String VIEW_MOSTRAR_DATOS = "mostrar-datos";
	public static final String VIEW_MOSTRAR_DATOS_PERSON = "mostrar-datos-person";
	public static final String VIEW_PEOPLE = "mostrar-people";
	
	//primera forma
	@GetMapping("/mostrarDatosString")
	public String mostrarDatosString(Model model) {
		model.addAttribute("name", "Jon");
		return VIEW_MOSTRAR_DATOS;
	}
	
	@RequestMapping(value="mostrarDatosMAV", method=RequestMethod.GET)
	public ModelAndView mostrarDatosMAV() {
		ModelAndView mav = new ModelAndView(VIEW_MOSTRAR_DATOS);
		mav.addObject("name", "Michel");
		return mav;
	}
	
	//primera forma pasandole un modelo Person
	@GetMapping("/mostrarDatosPerson")
	public String mostrarDatosPerson(Model model) {
		model.addAttribute("person", new Person("Jon", 22));
		return VIEW_MOSTRAR_DATOS_PERSON;
	}
	
	@RequestMapping(value="mostrarDatosPersonMAV", method=RequestMethod.GET)
	public ModelAndView mostrarDatosPersonMAV() {
		ModelAndView mav = new ModelAndView(VIEW_MOSTRAR_DATOS_PERSON);
		mav.addObject("person", new Person("Michel", 24));
		return mav;
	}
	
	@RequestMapping(value="mostrarPeople", method=RequestMethod.GET)
	public ModelAndView mostrarPeople() {
		exampleComponent.sayHello();
		ModelAndView mav = new ModelAndView(VIEW_PEOPLE);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
}
