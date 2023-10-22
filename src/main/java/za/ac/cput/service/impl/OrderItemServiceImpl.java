package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderItemRepository;
import za.ac.cput.service.OrderItemService;
import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the OrderItem Service implementation in business logic
 * due date: 22/10/2023
 * */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final IOrderItemRepository repository;
    @Autowired
    private OrderItemServiceImpl(IOrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return this.repository.save(orderItem);
    }

    @Override
    public OrderItem read(String orderItemId) {
        return this.repository.findById(orderItemId).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        if(this.repository.existsById(orderItem.getOrderItemId())){
            return this.repository.save(orderItem);
        }
        return null;
    }

    @Override
    public boolean delete(String orderItemId) {
        if(this.repository.existsById(orderItemId)){
            this.repository.deleteById(orderItemId);
        }
        return true;
    }

    @Override
    public List<OrderItem> getAll() {
        return this.repository.findAll();
    }
}
