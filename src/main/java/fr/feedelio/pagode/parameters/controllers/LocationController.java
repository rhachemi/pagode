package fr.feedelio.pagode.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.parameters.models.Location;

import fr.feedelio.pagode.parameters.services.LocationService;


@Controller
public class LocationController {

	@Autowired	private LocationService locationService;
	
	public Model addModelAttributes(Model model){
		model.addAttribute("locations", locationService.findAll());
	
		return model;
	}

	@GetMapping("/parametres/locations")
	public String findAll(Model model){
		addModelAttributes(model);
		return "/parametres/locations";
	}

	@GetMapping("/parametres/locationAdd")
	public String addLocation(Model model){
		
		return "parameters/locationAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/parametres/location/{op}/{id}")
	public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
		Location location = locationService.findById(id);
		model.addAttribute("location", location);
		addModelAttributes(model);
		return "/parametres/location"+ op; //returns locationEdit or locationDetails
	}

	@PostMapping("/parametres/locations")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/parametres/locations";
	}

	@RequestMapping(value="/parametres/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteById(@PathVariable Integer id) {
		locationService.deleteById(id);
		return "redirect:/parametres/locations";
	}
	
}
