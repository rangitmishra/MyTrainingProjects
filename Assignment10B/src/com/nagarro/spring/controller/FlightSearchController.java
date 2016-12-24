package com.nagarro.spring.controller;

import java.util.List;

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
import com.nagarro.spring.model.SearchingDetails;

@Controller
public class FlightSearchController {
	private FlightDao flightDao ;


	public FlightDao getFlightDao() {
		return flightDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	private List<Flight> flightList;
	
	@RequestMapping(value="/search" ,method=RequestMethod.GET)
	public ModelAndView  getFlightSearchForm(Model model){
		model.addAttribute("FlightSearch", new SearchingDetails());

		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("FlightSearch");

		return mnv;
	}
	
	
	@RequestMapping(value="/searching" ,method=RequestMethod.POST)
	ModelAndView FlightSearchForm(@Valid@ModelAttribute("FlightSearch") SearchingDetails searchingDetails,BindingResult result) {
		System.out.println("inside post");
		if ( result.hasErrors() )
		{	
			System.out.println("error to hi");
			ModelAndView model = new ModelAndView();
	
			model.setViewName("FlightSearch");
			return model;
		}
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		FlightSearchController  te = (FlightSearchController) context.getBean("flightSearchController");

		flightList=flightDao.search(searchingDetails);
		
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("flightResult");

		if(flightList.isEmpty())
		{
			mnv.addObject("errorMsg", "No Flights Found!");
		}
		mnv.addObject("resultList", flightList);
		return mnv;
	}

}