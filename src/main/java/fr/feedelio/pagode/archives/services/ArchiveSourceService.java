package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveSource;
import fr.feedelio.pagode.archives.repositories.ArchiveSourceRepository;

import java.util.List;

@Service
public class ArchiveSourceService {
	
	@Autowired
	private ArchiveSourceRepository archiveSourceRepository;
	
	//Get All ArchiveSource
	public List<ArchiveSource> findAll(){
		return archiveSourceRepository.findAll();
	}	
	
	//Get ArchiveSource By Id
	public ArchiveSource findById(int id) {
		return archiveSourceRepository.findById(id).orElse(null);
	}	
	
	//Delete ArchiveSource
	public void delete(int id) {
		archiveSourceRepository.deleteById(id);
	}
	
	//Update ArchiveSource
	public void save(ArchiveSource archiveSource) {
		archiveSourceRepository.save(archiveSource);
	}

}
