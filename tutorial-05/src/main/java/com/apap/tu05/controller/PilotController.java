package com.apap.tu05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.PilotService;

/**
 * PilotController
 */
@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home(Model model) {
		String pageTitle = "APAP";
		model.addAttribute("pageTitle", pageTitle);
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value="/pilot/view", method = RequestMethod.GET)
	private String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		String pageTitle = "View Pilot";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("pilot", pilot);
		model.addAttribute("pilotFlight", pilot.getPilotFlight());
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/delete/{licenseNumber}")
	private String delete(@PathVariable(value = "licenseNumber") String licenseNumber) {
		pilotService.deletePilot(licenseNumber);
		return "delete";
	}
	
	@RequestMapping(value= "/pilot/edit/{licenseNumber}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", archive);
	    return "editPilot";
	}
	
	@RequestMapping(value = "/pilot/edit", method = RequestMethod.POST)
	private String editPilotSubmit(@ModelAttribute PilotModel pilot, Long id) {
		pilotService.addPilot(pilot);
		return "update";
	}
}
