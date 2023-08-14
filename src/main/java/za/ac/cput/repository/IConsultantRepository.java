/**
 * IConsultantRepository.java
 * This is the IConsultantRepository POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.Payment;

import java.util.Set;

public interface IConsultantRepository extends JpaRepository<Consultant, String> {
    // create, read, update, delete
}
