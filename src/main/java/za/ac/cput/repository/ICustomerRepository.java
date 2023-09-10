/*
ICustomerRepository.java
Interface for customer repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String> {

    public Set<Customer> getAll();


}
