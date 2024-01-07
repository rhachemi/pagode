package fr.feedelio.pagode.loges.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import fr.feedelio.pagode.loges.models.Loge;
import fr.feedelio.pagode.loges.services.LogeService;
import fr.feedelio.pagode.loges.services.LogeStatutService;
import fr.feedelio.pagode.loges.services.LogeTypeService;
import fr.feedelio.pagode.parameters.services.LocationService;
import fr.feedelio.pagode.loges.services.LogeObedienceService;
 
 

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

@Controller
public class LogeController {
	
	@Autowired private LogeService logeService;	 
	@Autowired private LogeObedienceService logeObedienceService;
	@Autowired private LogeTypeService logeTypeService;
	@Autowired private LogeStatutService logeStatutService;
	@Autowired private LocationService logeLocationService;


	public Model addModelAttributes(Model model){
		 
		model.addAttribute("loges", logeService.findAll());
		model.addAttribute("logeObedience", logeObedienceService.findAll());
		model.addAttribute("logeType", logeTypeService.findAll());
		model.addAttribute("logeStatut", logeStatutService.findAll());
		model.addAttribute("logeLocation", logeLocationService.findAll());

		

		
		return model;
	}

	//Get All Loges
	@GetMapping("/loges/loges")
	public String findAll(Model model){
		addModelAttributes(model);
		return "/loges/loges";
	}	

	@GetMapping("/loges/logeAdd")
	public String addLoge(Model model){
		addModelAttributes(model);
		return "/loges/logeAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/loges/loge/{op}/{id}")
	public String editLoge(@PathVariable Integer id, @PathVariable String op, Model model){
		Loge loge = logeService.findById(id);
		model.addAttribute("loge", loge);
		addModelAttributes(model);
		return "/loges/loge"+ op; //returns logeEdit or logeDetails
	}

	//Add Loge
	@PostMapping("/loges/loges")
	public String addNew(Loge loge) {
		logeService.save(loge);
		return "redirect:/loges/loges";
	}	

	@RequestMapping(value="/loges/loge/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		logeService.delete(id);
		return "redirect:/loges/loges";
	}	

 

 
}
