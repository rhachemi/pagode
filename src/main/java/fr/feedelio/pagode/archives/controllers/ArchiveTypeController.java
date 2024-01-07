package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveType;
import fr.feedelio.pagode.archives.services.ArchiveTypeService;
 
 
import java.util.Optional;


@Controller
public class ArchiveTypeController {

	@Autowired private ArchiveTypeService archiveTypeService;

	//Get All ArchiveTypes
	@GetMapping("/archives/archiveTypes")
	public String findAll(Model model){
		model.addAttribute("archiveTypes", archiveTypeService.findAll());
		return "/archives/archiveTypes";
	}

	@RequestMapping("/archives/archiveType/{id}")
	@ResponseBody
	public Optional<ArchiveType> findById(@PathVariable Integer id)
	{
		return archiveTypeService.findById(id);
	}

	//Add ArchiveType
	@PostMapping(value="/archives/archiveTypes")
	public String addNew(ArchiveType archiveType) {
		archiveTypeService.save(archiveType);
		return "redirect:/archives/archiveTypes";
	}

	@RequestMapping(value="archives/archiveType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveTypeService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveTypes";
	}
	
}
