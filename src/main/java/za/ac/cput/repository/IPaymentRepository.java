/**
 * IPaymentRepository.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, String> {

}
