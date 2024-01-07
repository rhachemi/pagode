package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.Archive;
import fr.feedelio.pagode.archives.repositories.ArchiveRepository;

import java.util.Date;
import java.util.List;

@Service
public class ArchiveService {
	
	@Autowired
	private ArchiveRepository archiveRepository;
	
	//Get All Archives
	public List<Archive> findAll(){
		return archiveRepository.findAll();
	}	
	
	//Get Archive By Id
	public Archive findById(int id) {
		return archiveRepository.findById(id).orElse(null);
	}	
	
	//Delete Archive
	public void delete(int id) {
		archiveRepository.deleteById(id);
	}
	
	//Update Archive
	public void save(Archive archive) {
		archiveRepository.save(archive);
	}
	
	 // Nouvelle méthode pour récupérer le nombre total d'archives
    public long getArchiveCount() {
        return archiveRepository.count();
    }
 
	 public List<Archive> findAllWithFilters(Date filterDate, String filterTheme) {
	        List<Archive> archives = null;

			 
				if (filterDate != null) {
					archives = archiveRepository.findByEnregistrementDate(filterDate);
				} else if (filterTheme != null && !filterTheme.isEmpty()) {
					archives = archiveRepository.findByArchiveTheme_Description(filterTheme);
				} else {
					archives = archiveRepository.findAll();
				}
			 
	        
			 
			 
	        
	        
	         

	        return archives;
	    }

	 

}
