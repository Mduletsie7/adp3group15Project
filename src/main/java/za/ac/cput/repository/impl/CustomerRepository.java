/*
CustomerRepository.java
Entity for the customer repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository(){
        customerDB = new HashSet<Customer>();
    }

    public static CustomerRepository getRepository(){
        if(repository == null){
            repository = new CustomerRepository();
        }
        return repository;
    }


    @Override
    public Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        if(!success){
            return null;
        }
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        // linear or sequential search
       /* for (Customer c : customerDB){
            if(c.getCustomerId().equalsIgnoreCase(customerId)){
                return c;
            }

        }
        return null;
*/
        // Lambda expressions Java 8
        Customer customer = customerDB.stream().
                filter(c -> c.getCustomerId()
                .equals(customerId)).
                findAny()
                .orElse(null);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Customer oldCustomer = read(customer.getCustomerId());
        if(oldCustomer != null){
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        Customer customerToDelete = read(customerId);
        if(customerToDelete == null) {
            return false;
        }
        customerDB.remove(customerToDelete);
        return true;
    }

    @Override
    public Set<Customer> getAll() {
        return customerDB;
    }
}
