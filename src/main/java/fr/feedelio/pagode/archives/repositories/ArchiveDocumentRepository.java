package fr.feedelio.pagode.archives.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.archives.models.ArchiveDocument;

@Repository
public interface  ArchiveDocumentRepository extends JpaRepository<ArchiveDocument, Long> {
	
	@Query("SELECT new fr.feedelio.pagode.archives.models.ArchiveDocument(d.id, d.name, d.size) FROM ArchiveDocument d ORDER by d.uploadTime DESC ")
	List<ArchiveDocument> findAll();

}
