/**
 * IJobRepository.java
 * This is the JobRepository Interface
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Job;

@Repository
public interface IJobRepository extends JpaRepository<Job, String> {

}
