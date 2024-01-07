package fr.feedelio.pagode.loges.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.loges.models.LogeStatut;
import fr.feedelio.pagode.loges.services.LogeStatutService;

import java.util.List;

@Controller
public class LogeStatutController {

    @Autowired
    private LogeStatutService logeStatutService;

    @GetMapping("/loges/logeStatuts")
    public String parameters(Model model){
        List<LogeStatut> logeStatut = logeStatutService.findAll();
        model.addAttribute("logeStatut", logeStatut);
        return "/loges/logeStatuts";
    }

    //Get Job Title by id
    @GetMapping("/loges/logeStatut/{id}")
    @ResponseBody
    public LogeStatut getById(@PathVariable Integer id){
        return logeStatutService.findById(id).orElse(null);
    }

    @PostMapping("/loges/logeStatuts")
    public String save(LogeStatut logeStatut){
        logeStatutService.save(logeStatut);
        return "redirect:/loges/logeStatuts";
    }

    @RequestMapping(value="loges/logeStatuts/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		logeStatutService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/loges/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/loges/logeStatuts";
	}
    
}
