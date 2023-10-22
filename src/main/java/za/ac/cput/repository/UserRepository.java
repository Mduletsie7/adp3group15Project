package za.ac.cput.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);
}
