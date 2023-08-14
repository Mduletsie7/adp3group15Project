package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Job;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.JobService;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable String id) {
        return paymentService.read(id);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return paymentService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
}
