/*
ICustomerService.java
Interface for the customer service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICustomerService extends IService<Customer, String>{

    public Set<Customer> getAll();

}
