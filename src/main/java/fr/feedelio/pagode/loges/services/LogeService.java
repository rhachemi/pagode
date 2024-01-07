package fr.feedelio.pagode.loges.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.loges.models.Loge;
import fr.feedelio.pagode.loges.repositories.LogeRepository;

import java.util.List;

@Service
public class LogeService {
		
	@Autowired
	private LogeRepository logeRepository;
	
	//Get All Loges
	public List<Loge> findAll(){
		return logeRepository.findAll();
	}	
	
	//Get Loge By Id
	public Loge findById(int id) {
		return logeRepository.findById(id).orElse(null);
	}	
	
	//Delete Loge
	public void delete(int id) {
		logeRepository.deleteById(id);
	}
	
	//Update Loge
	public void save( Loge loge) {
		logeRepository.save(loge);
	}
	
	//Get Loge by nom
	public Loge findByNom(String un) {
		return logeRepository.findByNom(un);
	}

	//Get loge by Keyword
	public List<Loge> findByKeyword(String keyword) {
		return logeRepository.findByKeyword(keyword);
	}


}
