package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSE_VIEW = "courses";
	private static final String CHOOSE_COURSE_VIEW = "choose-course";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServicesImpl")
	private CourseService courseServices;
	
	@GetMapping("listcourse")
	public ModelAndView listAllCourse() {
		LOG.info("Call: listAllCourse()");
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		mav.addObject("courses", courseServices.listAllCourse());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: addCourse() -- Param: " + course.toString());
		courseServices.addCourse(course);
		return "redirect:/courses/listcourse";
	}
	
	@GetMapping("/choosecourse")
	public ModelAndView chooseCourse() {
		LOG.info("Call: chooseCourse()");
		ModelAndView mav = new ModelAndView(CHOOSE_COURSE_VIEW);
		mav.addObject("courses", courseServices.listAllCourse());
		return mav;
	}
}
