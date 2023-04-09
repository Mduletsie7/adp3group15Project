/*
ICustomerAddressRepository.java
Interface for invoice repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerAddress;
;
import java.util.Set;

public interface ICustomerAddressRepository extends IRepository<CustomerAddress, String> {

    public Set<CustomerAddress> getAll();

}
