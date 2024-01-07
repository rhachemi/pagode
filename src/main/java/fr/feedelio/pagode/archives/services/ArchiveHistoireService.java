package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveFormat;
import fr.feedelio.pagode.archives.models.ArchiveHistoire;
 
import fr.feedelio.pagode.archives.repositories.ArchiveHistoireRepository;
 

import java.util.List;
import java.util.Optional;

@Service 
public class ArchiveHistoireService {
	
	@Autowired
	private ArchiveHistoireRepository archiveHistoireRepository;
	
	//Get All ArchiveModels
	public List<ArchiveHistoire> findAll(){
		return archiveHistoireRepository.findAll();
	}	
	
	//Get ArchiveModel By Id
	public ArchiveHistoire findById(int id) {
		return archiveHistoireRepository.findById(id).orElse(null);
	}	
	 
	
	//Delete ArchiveModel
	public void delete(int id) {
		archiveHistoireRepository.deleteById(id);
	}
	
	//Update ArchiveModel
	public void save(ArchiveHistoire archiveHistoire) {
		archiveHistoireRepository.save(archiveHistoire);
	}

}
