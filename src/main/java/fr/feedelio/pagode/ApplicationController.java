package fr.feedelio.pagode;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.feedelio.pagode.archives.models.ArchiveDocument;
import fr.feedelio.pagode.archives.repositories.ArchiveDocumentRepository;

@Controller
public class ApplicationController {

	@Autowired
	ArchiveDocumentRepository repo;
	

	@GetMapping("/assets/404")
	public String go404() {
		return "/assets/404";
	}
	@GetMapping("/index")
	public String goHome() {
		return "index";
	}

	@GetMapping("loges")
	public String loges() {
		return "/loges/index";
	}

	@GetMapping("archives")
	public String archives() {
		return "/archives/index";
	}

	@GetMapping("parametres")
	public String parametres() {
		return "/parametres/index";
	}

	@GetMapping("infocentre")
	public String infocentre() {
		return "/infocentre/index";
	}

	@GetMapping("securite")
	public String securite() {
		return "/securite/index";
	}

	@PostMapping("/upload")
    public String uploadFile(@RequestParam("document") MultipartFile multipartFile,
                             RedirectAttributes ra) {
		 
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            ArchiveDocument document = new ArchiveDocument();
            document.setName(fileName);
            document.setContent(multipartFile.getBytes());
            document.setSize(multipartFile.getSize());
            document.setUploadTime(new Date());

            repo.save(document);

            ra.addFlashAttribute("message", "The file has been uploaded successfully");
            
            System.out.println("Original filename: " + multipartFile.getOriginalFilename());
            String testfileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            System.out.println("Cleaned filename: " + testfileName);

            return "redirect:/archives/archiveDocuments";
        
        }  catch (DataIntegrityViolationException | IOException e) {
            // La violation de contrainte d'unicité a été détectée (fichier déjà existant)
            ra.addFlashAttribute("message", "Erreur : Ce fichier existe déjà : " + multipartFile.getOriginalFilename() + "///"+ e.getMessage());
            return "redirect:/archives/archiveDocuments"; }   
      
    }

	@GetMapping("/download")
    public void downloadFile(@Param("id") Long id, HttpServletResponse response) throws Exception {
		

         Optional<ArchiveDocument> result = repo.findById(id); 
	if (!result.isPresent()) {
		throw new Exception("Could not find document with ID :" + id);
		
      }
	ArchiveDocument document = result.get();
	
	response.setContentType("application/octet-stream");
	String headerKey = "Content-Disposition";
	String headerValue ="attachment; filename=" + document.getName();
	
	response.setHeader(headerKey, headerValue);
	ServletOutputStream outputStream = response.getOutputStream();
	outputStream.write(document.getContent());
	outputStream.close();

	}

}
