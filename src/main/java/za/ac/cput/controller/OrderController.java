package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Controller class and is responsible for communicating with the client
 * due date: 22/10/2023
 * */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable String id) {
        return orderService.read(id);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return orderService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
