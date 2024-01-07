package fr.feedelio.pagode.archives.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.archives.models.Archive;
import fr.feedelio.pagode.archives.models.ArchiveDocument;
import fr.feedelio.pagode.archives.repositories.ArchiveDocumentRepository;
import fr.feedelio.pagode.archives.services.*;
import fr.feedelio.pagode.loges.services.LogeService;
import fr.feedelio.pagode.parameters.services.LocationService;

import fr.feedelio.pagode.security.services.UserService;




@Controller
public class ArchiveController {
	
	@Autowired private ArchiveService archiveService;
	@Autowired private ArchiveTypeService archiveTypeService;
	@Autowired private ArchiveFormatService archiveFormatService;
	@Autowired private ArchiveHistoireService archiveHistoireService;
	@Autowired private ArchiveSourceService archiveSourceService;
	@Autowired private ArchiveThemeService archiveThemeService;
	@Autowired private ArchiveStatutService archiveStatutService;
	@Autowired private ArchiveDocumentService archiveDocumentService;
	
	
	
	@Autowired private LocationService archiveLocationService;
	@Autowired private LogeService archivelogeService ;
	@Autowired private UserService archiveUserService;

 
	public Model addModelAttributes(Model model){
		model.addAttribute("archives", archiveService.findAll());
		model.addAttribute("archiveTypes", archiveTypeService.findAll());
		model.addAttribute("archiveSource", archiveSourceService.findAll());
		model.addAttribute("archiveFormat", archiveFormatService.findAll());
		model.addAttribute("archiveHistoire", archiveHistoireService.findAll());
		model.addAttribute("archiveTheme", archiveThemeService.findAll());
		model.addAttribute("archiveStatut", archiveStatutService.findAll());
		model.addAttribute("archiveDocument", archiveDocumentService.findAll());
		

		model.addAttribute("archiveLocation", archiveLocationService.findAll());
		model.addAttribute("archiveLoge", archivelogeService.findAll());
		model.addAttribute("archiveUser", archiveUserService.findAll());

	
		return model;
	}
	
	
	//Get All Archives

	@GetMapping("/archives/archives")
	public String findAll(@RequestParam(value = "filterDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date filterDate,
	                     @RequestParam(value = "filterTheme", required = false) String filterTheme,
	                     Model model) {    
	  List<Archive> filteredArchives = archiveService.findAllWithFilters(filterDate, filterTheme);
	   addModelAttributes(model);
	  model.addAttribute("archives", filteredArchives);
	  
	  
	  // Ajouter le nombre total d'archives à l'objet model
	    long totalArchives = archiveService.getArchiveCount();
	    model.addAttribute("totalArchives", totalArchives);   
	    return "/archives/archives";
}


	
	//@GetMapping("/archives/archives")
	//public String findAll(@RequestParam(value = "filterDate", required = false) Date filterDate,
	//                      @RequestParam(value = "filterTheme", required = false) String filterTheme,
	         //             Model model) {	
	//    List<Archive> filteredArchives = archiveService.findAllWithFilters(filterDate, filterTheme);
	 //   addModelAttributes(model);
	 //   model.addAttribute("archives", filteredArchives);
	//    return "/archives/archives";
//	}


	@GetMapping("/archives/archiveAdd")
	public String addArchive(Model model){
		addModelAttributes(model);
		return "archives/archiveAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/archives/archive/{op}/{id}")
	public String editArchive(@PathVariable Integer id, @PathVariable String op, Model model){
		Archive archive = archiveService.findById(id);
		model.addAttribute("archive", archive);
		addModelAttributes(model);
		return "/archives/archive"+ op; //returns archiveEdit or archiveDetails
	}
	
 
	//Add Archive
	@PostMapping("/archives/archives")
    public String addNew(Archive archive) {
	archiveService.save(archive);
		return "redirect:/archives/archives";
	}	
	
	 

	@RequestMapping(value="/archives/archive/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		archiveService.delete(id);
		return "redirect:/archives/archives";
	}
	
	
	
	
	
}
