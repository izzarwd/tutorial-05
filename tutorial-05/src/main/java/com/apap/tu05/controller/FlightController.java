package com.apap.tu05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

/**
 * FlightController
 */
@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	@RequestMapping(value="/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
		return "delete";
	}
	
	@RequestMapping(value= "/flight/edit/{flightNumber}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel archive = flightService.getFlightDetailByflightNumber(flightNumber);
		model.addAttribute("flight", archive);
	    return "editFlight";
	}
	
	@RequestMapping(value = "/flight/edit", method = RequestMethod.POST)
	private String editFlightSubmit(@ModelAttribute FlightModel flight, Long id) {
		flightService.addFlight(flight);
		return "update";
	}
	
	@RequestMapping(value = "/flight/all", method = RequestMethod.GET)
	private String all(Model model) {
		List <FlightModel> archive = flightService.listAll();
		model.addAttribute("flight", archive);
		return "view-flight";
	}
	
}
