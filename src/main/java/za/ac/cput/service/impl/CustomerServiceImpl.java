/*
CustomerServiceImpl.java
Entity for the customer service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.ICustomerService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository repository;

    @Autowired
    private CustomerServiceImpl(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer){
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String customerId){
        return this.repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer){
        if(this.repository.existsById(customer.getCustomerId())){
            return this.repository.save(customer);
        }
        return null;
    }
    @Override
    public boolean delete(String customerId){
        if(this.repository.existsById(customerId)){
            this.repository.deleteById(customerId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Customer> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}
