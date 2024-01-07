package fr.feedelio.pagode.loges.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.archives.models.Archive;
import fr.feedelio.pagode.loges.models.Loge;

import java.util.Date;
import java.util.List;

@Repository
public interface LogeRepository extends JpaRepository<Loge, Integer> {

	public Loge findByNom(String un);

	@Query(value = "select * from Loge e where e.nom like %:keyword%", nativeQuery = true)
	List<Loge> findByKeyword(@Param("keyword") String keyword);

	@Query(value = "SELECT obedience_id, count(*) FROM Loge GROUP BY obedience_id",
			nativeQuery = true)
	List<Object> getCountByObedience();
		
	List<Loge> findByLogeObedience(String obedience);
    List<Loge> findByLogeLocation(String location);
}
