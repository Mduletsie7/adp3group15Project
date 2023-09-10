/**
 * PaymentService.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Project;

import java.util.List;

public interface PaymentService extends IService <Payment, String>{
    List<Payment> getAll();
}
