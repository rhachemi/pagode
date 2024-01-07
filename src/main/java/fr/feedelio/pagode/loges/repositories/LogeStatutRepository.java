package fr.feedelio.pagode.loges.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.loges.models.LogeStatut;

@Repository
public interface LogeStatutRepository extends JpaRepository<LogeStatut, Integer> {
}
