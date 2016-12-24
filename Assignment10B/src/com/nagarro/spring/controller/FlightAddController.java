package com.nagarro.spring.controller;


import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.spring.dao.FlightDao;

import com.nagarro.spring.model.Flight;

@Controller

public class FlightAddController {

	private FlightDao flightDao ;


	public FlightDao getFlightDao() {
		return flightDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	@RequestMapping(value = "/")
	public String index()
	{
		return "redirect:/index";
	}


	@RequestMapping(value="/flightadd" ,method=RequestMethod.GET)
	public ModelAndView  getFlightAddForm(Model model){
		model.addAttribute("FlightData", new Flight());

		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("FlightData");

		return mnv;
	}
	
	@RequestMapping(value="/Success" ,method=RequestMethod.POST)
	ModelAndView FlightAddForm(@Valid@ModelAttribute("FlightData") Flight flight,BindingResult result) {
		System.out.println("inside post");
		if ( result.hasErrors() )
		{	
			System.out.println("error to hi");
			ModelAndView model = new ModelAndView();
	
			model.setViewName("FlightData");
			return model;
		}
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		FlightAddController  te = (FlightAddController) context.getBean("flightAddController");
		System.out.println("coming here");
		flightDao.save(flight);
		ModelAndView model = new ModelAndView("index");
		//model.addObject("message","Chal yaha to aa gaye");
		return model;
	}
}
