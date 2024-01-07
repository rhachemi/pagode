package fr.feedelio.pagode.archives.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.ArchiveDocument;
import fr.feedelio.pagode.archives.services.ArchiveDocumentService;
 
 
import java.util.Optional;


@Controller
 
public class ArchiveDocumentController {

	@Autowired private ArchiveDocumentService archiveDocumentService;

	//Get All ArchiveDocuments
	@GetMapping("/archives/archiveDocuments")
	public String findAll(Model model){
		model.addAttribute("archiveDocuments", archiveDocumentService.findAll());
		return "/archives/archiveDocuments";
	}

	@RequestMapping("/archives/archivesDocument/{id}")
	@ResponseBody
	public ArchiveDocument findById(@PathVariable Long id)
	{
		return archiveDocumentService.findById(id);
	}

	//Add ArchiveDocument
	@PostMapping(value="/archives/archiveDocuments")
	public String addNew(ArchiveDocument archiveDocument) {
		archiveDocumentService.save(archiveDocument);
		return "redirect:/archives/archiveDocuments";
	}
	
	@RequestMapping(value="/archives/archiveDocuments/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Long id, Model model) {
 
		try {
		archiveDocumentService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/archives/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/archives/archiveDocuments";
	}
	
}
