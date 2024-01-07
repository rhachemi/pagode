package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveSource;
import fr.feedelio.pagode.archives.services.ArchiveSourceService;
 
 
import java.util.Optional;


@Controller
public class ArchiveSourceController {

	@Autowired private ArchiveSourceService archiveSourceService;

	//Get All ArchiveSources
	@GetMapping("/archives/archiveSources")
	public String findAll(Model model){
		model.addAttribute("archiveSources", archiveSourceService.findAll());
		return "/archives/archiveSources";
	}

	@RequestMapping("/archives/archiveSource/{id}")
	@ResponseBody
	public ArchiveSource findById(@PathVariable Integer id)
	{
		return archiveSourceService.findById(id);
	}

	//Add ArchiveSource
	@PostMapping(value="/archives/archiveSources")
	public String addNew(ArchiveSource archiveSource) {
		archiveSourceService.save(archiveSource);
		return "redirect:/archives/archiveSources";
	}

	@RequestMapping(value="archives/archiveSource/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveSourceService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveSources";
	}
	
}
