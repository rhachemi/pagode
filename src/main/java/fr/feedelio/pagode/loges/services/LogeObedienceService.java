package fr.feedelio.pagode.loges.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.loges.models.LogeObedience;
import fr.feedelio.pagode.loges.repositories.LogeObedienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LogeObedienceService {

	@Autowired
	private LogeObedienceRepository logeObedienceRepository;
	
	//Get All obédience
	public List<LogeObedience> findAll(){
		return logeObedienceRepository.findAll();
	}	
	
	//Get obédience By Id
	public Optional<LogeObedience> findById(int id) {
		return logeObedienceRepository.findById(id);
	}	
	
	//Delete obédience
	public void delete(int id) {
		logeObedienceRepository.deleteById(id);
	}
	
	//Update obédience
	public void save(LogeObedience obedience) {
		logeObedienceRepository.save(obedience);
	}
}
