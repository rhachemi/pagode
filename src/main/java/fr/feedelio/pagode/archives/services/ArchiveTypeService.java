package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveType;
import fr.feedelio.pagode.archives.repositories.ArchiveTypeRepository;
 
import java.util.List;
import java.util.Optional;

@Service
public class ArchiveTypeService {
	
	@Autowired
	private ArchiveTypeRepository archiveTypeRepository;
	
	//Get All ArchiveTypes
	public List<ArchiveType> findAll(){
		return archiveTypeRepository.findAll();
	}	
	
	//Get ArchiveType By Id
	public Optional<ArchiveType> findById(int id) {
		return archiveTypeRepository.findById(id);
	}	
	
	//Delete ArchiveType
	public void delete(int id) {
		archiveTypeRepository.deleteById(id);
	}
	
	//Update ArchiveType
	public void save(ArchiveType archiveType) {
		archiveTypeRepository.save(archiveType);
	}

}
