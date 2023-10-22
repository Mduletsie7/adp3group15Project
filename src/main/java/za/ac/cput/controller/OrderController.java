package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.service.OrderService;
import za.ac.cput.service.impl.OrderServiceImpl;

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
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Orders create(@RequestBody Orders order) {
        return orderService.create(order);
    }

    @GetMapping("/read/{id}")
    public Orders read(@PathVariable String id) {
        return orderService.read(id);
    }

    @PostMapping("/update")
    public Orders update(@RequestBody Orders order) {
        return orderService.update(order);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return orderService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Orders> getAll() {
        return orderService.getAll();
    }
}
