package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveFormat;
import fr.feedelio.pagode.archives.services.ArchiveFormatService;
 
 
import java.util.Optional;


@Controller
public class ArchiveFormatController {

	@Autowired private ArchiveFormatService archiveFormatService;

	//Get All ArchiveFormats
	@GetMapping("/archives/archiveFormats")
	public String findAll(Model model){
		model.addAttribute("archiveFormats", archiveFormatService.findAll());
		return "/archives/archiveFormats";
	}

	@RequestMapping("/archives/archiveFormat/{id}")
	@ResponseBody
	public ArchiveFormat findById(@PathVariable Integer id)
	{
		return archiveFormatService.findById(id);
	}

	//Add ArchiveFormat
	@PostMapping(value="/archives/archiveFormats")
	public String addNew(ArchiveFormat archiveFormat) {
		archiveFormatService.save(archiveFormat);
		return "redirect:/archives/archiveFormats";
	}

	@RequestMapping(value="archives/archiveFormat/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveFormatService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveFormats";
	}
	
}
