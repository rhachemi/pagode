package fr.feedelio.pagode.archives.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.archives.models.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Integer> {
	
    List<Archive> findByEnregistrementDate(Date filterDate);

	
    List<Archive> findByArchiveTheme_Details(String details);
    List<Archive> findByArchiveTheme_Description(String description);


 

 


}
