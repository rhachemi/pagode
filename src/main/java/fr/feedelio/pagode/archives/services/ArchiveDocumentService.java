package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveDocument;
import fr.feedelio.pagode.archives.repositories.ArchiveDocumentRepository;

import java.util.List;

@Service
public class ArchiveDocumentService {

	@Autowired
	private ArchiveDocumentRepository archiveDocumentRepository;
	
	//Get All ArchiveDocuments
	public List<ArchiveDocument> findAll(){
		return archiveDocumentRepository.findAll();
	}	
	
	//Get ArchiveDocument By Id
	public ArchiveDocument findById(Long id) {
		return archiveDocumentRepository.findById(id).orElse(null);
	}	
	
	//Delete ArchiveDocument
	public void delete(Long id) {
		archiveDocumentRepository.deleteById(id);
	}
	
	//Update ArchiveDocument
	public void save(ArchiveDocument archiveDocument) {
		archiveDocumentRepository.save(archiveDocument);
	}
}
