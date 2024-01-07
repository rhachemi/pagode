package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveStatut;
import fr.feedelio.pagode.archives.services.ArchiveStatutService;
 
 
import java.util.Optional;


@Controller
public class ArchiveStatutController {

	@Autowired private ArchiveStatutService archiveStatutService;

	//Get All ArchiveStatuts
	@GetMapping("/archives/archiveStatuts")
	public String findAll(Model model){
		model.addAttribute("archiveStatuts", archiveStatutService.findAll());
		return "/archives/archiveStatuts";
	}

	@RequestMapping("/archives/archiveStatut/{id}")
	@ResponseBody
	public ArchiveStatut findById(@PathVariable Integer id)
	{
		return archiveStatutService.findById(id);
	}

	//Add ArchiveStatut
	@PostMapping(value="/archives/archiveStatuts")
	public String addNew(ArchiveStatut archiveStatut) {
		archiveStatutService.save(archiveStatut);
		return "redirect:/archives/archiveStatuts";
	}

	@RequestMapping(value="archives/archiveStatut/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveStatutService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveStatuts";
	}
	
}
