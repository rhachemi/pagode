package fr.feedelio.pagode.loges.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.loges.models.LogeType;
import fr.feedelio.pagode.loges.repositories.LogeTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LogeTypeService {
	
	@Autowired
	private LogeTypeRepository logeTypeRepository;
	
	//Get All LogeTypes
	public List<LogeType> findAll(){
		return logeTypeRepository.findAll();
	}	
	
	//Get LogeType By Id
	public Optional<LogeType> findById(int id) {
		return logeTypeRepository.findById(id);
	}	
	
	//Delete LogeType
	public void delete(int id) {
		logeTypeRepository.deleteById(id);
	}
	
	//Update LogeType
	public void save( LogeType logeType) {
		logeTypeRepository.save(logeType);
	}

}
