package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveHistoire;
import fr.feedelio.pagode.archives.services.ArchiveHistoireService;
 
 
import java.util.Optional;


@Controller
public class ArchiveHistoireController {

	@Autowired private ArchiveHistoireService archiveHistoireService;

	//Get All ArchiveHistoires
	@GetMapping("/archives/archiveHistoires")
	public String findAll(Model model){
		model.addAttribute("archiveHistoires", archiveHistoireService.findAll());
		return "/archives/archiveHistoires";
	}

	@RequestMapping("/archives/archiveHistoire/{id}")
	@ResponseBody
	public ArchiveHistoire findById(@PathVariable Integer id)
	{
		return archiveHistoireService.findById(id);
	}

	//Add ArchiveHistoire
	@PostMapping(value="/archives/archiveHistoires")
	public String addNew(ArchiveHistoire archiveHistoire) {
		archiveHistoireService.save(archiveHistoire);
		return "redirect:/archives/archiveHistoires";
	}

	@RequestMapping(value="archives/archiveHistoire/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveHistoireService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveHistoires";
	}
	
}
