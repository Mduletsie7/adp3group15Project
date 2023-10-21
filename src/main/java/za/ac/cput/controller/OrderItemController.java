package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.OrderItemService;

import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Item Controller and is responsible for communicating with the client
 * due date: 22/10/2023
 * */
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem) {
        return orderItemService.create(orderItem);
    }

    @GetMapping("/read/{id}")
    public OrderItem read(@PathVariable String id) {
        return orderItemService.read(id);
    }

    @PostMapping("/update")
    public OrderItem update(@RequestBody OrderItem orderItem) {
        return orderItemService.update(orderItem);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return orderItemService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<OrderItem> getAll() {
        return orderItemService.getAll();
    }
}
