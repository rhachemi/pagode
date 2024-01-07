package fr.feedelio.pagode.archives.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.archives.models.ArchiveTheme;

@Repository
public interface ArchiveThemeRepository extends JpaRepository<ArchiveTheme, Integer> {

}
