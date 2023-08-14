/**
 * PaymentServiceImpl.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private IPaymentRepository repository;

    @Autowired
    private PaymentServiceImpl(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String paymentId) {
        return this.repository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if (this.repository.existsById(payment.getPaymentId()))
            return this.repository.save(payment);
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        if (this.repository.existsById(paymentId)) {
            this.repository.deleteById(paymentId);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return this.repository.findAll();
    }
}

