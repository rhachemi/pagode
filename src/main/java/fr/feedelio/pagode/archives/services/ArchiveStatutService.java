package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveStatut;
import fr.feedelio.pagode.archives.repositories.ArchiveStatutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveStatutService {
	
	@Autowired
	private ArchiveStatutRepository archiveStatutRepository;
	
	//Get All ArchiveStatuts
	public List<ArchiveStatut> findAll(){
		return archiveStatutRepository.findAll();
	}	
	
	//Get ArchiveStatut By Id
	public  ArchiveStatut findById(int id) {
		return archiveStatutRepository.findById(id).orElse(null);
	}	
	
	//Delete ArchiveStatut
	public void delete(int id) {
		archiveStatutRepository.deleteById(id);
	}
	
	//Update ArchiveStatut
	public void save(ArchiveStatut archiveStatut) {
		archiveStatutRepository.save(archiveStatut);
	}

}
