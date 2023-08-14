package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Project;

import java.util.List;

public interface PaymentService extends IService <Payment, String>{
    List<Payment> getAll();
}
