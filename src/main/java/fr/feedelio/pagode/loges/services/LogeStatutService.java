package fr.feedelio.pagode.loges.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.feedelio.pagode.loges.models.LogeStatut;
import fr.feedelio.pagode.loges.repositories.LogeStatutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LogeStatutService {

    @Autowired
    private LogeStatutRepository logeStatutRepository;

    //Get All LogeStatuts
    public List<LogeStatut> findAll(){
        return logeStatutRepository.findAll();
    }

    //Get LogeStatut By Id
    public Optional<LogeStatut> findById(int id) {
        return logeStatutRepository.findById(id);
    }

    //Delete LogeStatut
    public void delete(int id) {
        logeStatutRepository.deleteById(id);
    }

    //Update LogeStatut
    public void save( LogeStatut logeStatut) {
        logeStatutRepository.save(logeStatut);
    }
}
