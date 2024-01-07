package fr.feedelio.pagode.archives.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.archives.models.ArchiveFormat;
import fr.feedelio.pagode.archives.repositories.ArchiveFormatRepository;

import java.util.List;

@Service
public class ArchiveFormatService {

	@Autowired
	private ArchiveFormatRepository archiveFormatRepository;
	
	//Get All ArchiveFormats
	public List<ArchiveFormat> findAll(){
		return archiveFormatRepository.findAll();
	}	
	
	//Get ArchiveFormat By Id
	public ArchiveFormat findById(int id) {
		return archiveFormatRepository.findById(id).orElse(null);
	}	
	
	//Delete ArchiveFormat
	public void delete(int id) {
		archiveFormatRepository.deleteById(id);
	}
	
	//Update ArchiveFormat
	public void save(ArchiveFormat archiveFormat) {
		archiveFormatRepository.save(archiveFormat);
	}
}
