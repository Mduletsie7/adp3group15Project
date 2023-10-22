/*
CustomerController.java
Entity for the customer controller
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.impl.CustomerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerServiceImpl service;

    @Autowired
    CustomerController(CustomerServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return service.create(customer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Customer> getAll(){
        return service.getAll();
    }


}
