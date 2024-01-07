package fr.feedelio.pagode.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.feedelio.pagode.security.models.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

 
}
