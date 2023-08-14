package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Project;

public interface IProjectRepository extends JpaRepository<Project, String> {
}
