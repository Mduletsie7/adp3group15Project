package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.OrderService;
import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Service implementation in business logic
 * due date: 22/10/2023
 * */
@Service
public class OrderServiceImpl implements OrderService {
    private final IOrderRepository repository;
    @Autowired
    private OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Orders create(Orders order) {
        return this.repository.save(order);
    }

    @Override
    public Orders read(String orderId) {
        return this.repository.findById(orderId).orElse(null);
    }

    @Override
    public Orders update(Orders order) {
        if (this.repository.existsById(order.getOrderId())){
            System.out.println("Order updated!");
            return this.repository.save(order);
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        if(this.repository.existsById(orderId)){
            this.repository.deleteById(orderId);
        }
        return true;
    }

//    @Override
    public List<Orders> getAll() {
        return this.repository.findAll();
    }
}
