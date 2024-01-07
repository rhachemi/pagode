package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveTheme;
import fr.feedelio.pagode.archives.repositories.ArchiveThemeRepository;

import java.util.List;

@Service
public class ArchiveThemeService {
	
	@Autowired
	private ArchiveThemeRepository archiveThemeRepository;
	
	//Get All ArchiveTheme
	public List<ArchiveTheme> findAll(){
		return archiveThemeRepository.findAll();
	}	
	
	//Get ArchiveTheme By Id
	public ArchiveTheme findById(int id) {
		return archiveThemeRepository.findById(id).orElse(null);
	}	
	
	//Delete ArchiveTheme
	public void delete(int id) {
		archiveThemeRepository.deleteById(id);
	}
	
	//Update ArchiveTheme
	public void save(ArchiveTheme archiveTheme) {
		archiveThemeRepository.save(archiveTheme);
	}

}
