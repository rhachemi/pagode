package fr.feedelio.pagode.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

 
import fr.feedelio.pagode.loges.repositories.LogeRepository;

@Controller
public class ReportsController {
 

    @Autowired
    private LogeRepository archiveRepository;

    @GetMapping("/infocentre/archives")
    public String archives() {
        return "/infocentre/archives";
    }

    
 
 

  
}
