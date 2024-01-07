package fr.feedelio.pagode.parameters.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.parameters.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
