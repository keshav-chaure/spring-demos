package org.kc.web.controller;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	/*
	@RequestMapping(path= {"/"},method=RequestMethod.GET)		
	public String sayHello(Model model) {
		model.addAttribute("message","Hello Spring MVC");
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		//LocalDate date=LocalDate.now();
		String   date=ZonedDateTime.now().format(dateTimeFormatter);
		model.addAttribute("date",date);
		return "index";		
	}
	
	@RequestMapping(path= {"/admin"},method=RequestMethod.GET)
   public String sayHelloByAdmin(Model model) {
	   model.addAttribute("message","Hello Spring MVC by admin");
	   return "secured_page";	   
   }
	*/
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");

		return model;

	}

}
