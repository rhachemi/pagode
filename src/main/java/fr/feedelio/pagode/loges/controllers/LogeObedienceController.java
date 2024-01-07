package fr.feedelio.pagode.loges.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.loges.models.LogeObedience;
import fr.feedelio.pagode.loges.services.LogeObedienceService;

import java.util.List;

@Controller
public class LogeObedienceController {

    @Autowired
    private LogeObedienceService logeObedienceService;

    @GetMapping("/loges/logeObediences")
    public String parameters(Model model){
        List<LogeObedience> logeObedience = logeObedienceService.findAll();
        model.addAttribute("logeObedience", logeObedience);
        return "/loges/logeObediences";
    }

    //Get Obedience by id
    @GetMapping("/loges/logeObediences/{id}")
    @ResponseBody
    public LogeObedience getById(@PathVariable Integer id){
        return logeObedienceService.findById(id).orElse(null);
    }

    @PostMapping("/loges/logeObediences")
    public String save(LogeObedience logeObedience){
    	logeObedienceService.save(logeObedience);
        return "redirect:/loges/logeObediences";
    }

    @RequestMapping(value="loges/logeObediences/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id, Model model) {
 
		try {
		logeObedienceService.delete(id);
	 } catch (DataIntegrityViolationException e) {
         // Capture l'exception de contrainte d'intégrité
         String errorMessage = "Erreur de contrainte d'intégrité : " + e.getMessage();
         model.addAttribute("errorMessage", errorMessage);
         return "/loges/error"; // Créez une vue spéciale pour afficher les erreurs si nécessaire
     }
		return "redirect:/loges/logeObediences";
	}
}
