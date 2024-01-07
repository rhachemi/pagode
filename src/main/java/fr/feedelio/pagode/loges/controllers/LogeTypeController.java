package fr.feedelio.pagode.loges.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.loges.models.LogeType;
import fr.feedelio.pagode.loges.repositories.LogeTypeRepository;
import fr.feedelio.pagode.loges.services.LogeTypeService;

import java.util.List;

@Controller
public class LogeTypeController {

	@Autowired
	private LogeTypeRepository logeTypeRepository;

	@Autowired
	private LogeTypeService logeTypeService;

	@GetMapping("/loges/logeTypes")
	public String parameters(Model model){
		List<LogeType> logeTypes = logeTypeRepository.findAll();
		model.addAttribute("logeTypes", logeTypes);
		return "/loges/logeTypes";
	}

	//Get Job Title by id
	@GetMapping("/loges/logeTypes/{id}")
	@ResponseBody
	public LogeType getById(@PathVariable Integer id){
		return logeTypeService.findById(id).orElse(null);
	}

	@PostMapping("/loges/logeTypes")
	public String save(LogeType logeType){
		logeTypeService.save(logeType);
		return "redirect:/loges/logeTypes";
	}

	 @RequestMapping(value="loges/logeTypes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	    public String delete(@PathVariable Integer id, Model model) {
	 
			try {
			logeTypeService.delete(id);
		 } catch (DataIntegrityViolationException e) {
	         // Capture l'exception de contrainte d'intégrité
	         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
	         model.addAttribute("errorMessage", errorMessage);
	         return "/loges/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
	     }
			return "redirect:/loges/logeTypes";
		}

}
