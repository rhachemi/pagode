package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveTheme;
import fr.feedelio.pagode.archives.services.ArchiveThemeService;
 
 
import java.util.Optional;


@Controller
public class ArchiveThemeController {

	@Autowired private ArchiveThemeService archiveThemeService;

	//Get All ArchiveThemes
	@GetMapping("/archives/archiveThemes")
	public String findAll(Model model){
		model.addAttribute("archiveThemes", archiveThemeService.findAll());
		return "/archives/archiveThemes";
	}

	@RequestMapping("/archives/archiveTheme/{id}")
	@ResponseBody
	public ArchiveTheme findById(@PathVariable Integer id)
	{
		return archiveThemeService.findById(id);
	}

	//Add ArchiveTheme
	@PostMapping(value="/archives/archiveThemes")
	public String addNew(ArchiveTheme archiveTheme) {
		archiveThemeService.save(archiveTheme);
		return "redirect:/archives/archiveThemes";
	}

	@RequestMapping(value="archives/archiveTheme/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		archiveThemeService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveThemes";
	}
	
}
