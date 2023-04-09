/*
CustomerAddressRepository.java
Entity for the customer address repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.CustomerAddress;

import java.util.HashSet;
import java.util.Set;

public class CustomerAddressRepository implements ICustomerAddressRepository {

        private static CustomerAddressRepository repository = null;
        private Set<CustomerAddress> customerAddressDB = null;

    private CustomerAddressRepository(){
        customerAddressDB = new HashSet<CustomerAddress>();
    }

        public static CustomerAddressRepository getRepository(){
        if(repository == null){
            repository = new CustomerAddressRepository();
        }
        return repository;
    }


        @Override
        public CustomerAddress create(CustomerAddress customerAddress) {
        boolean success = customerAddressDB.add(customerAddress);
        if(!success){
            return null;
        }
        return customerAddress;
    }

        @Override
        public CustomerAddress read(String customerAddressId) {
        // linear or sequential search
       /* for (CustomerAddress c : customerAddressDB){
            if(c.getCustomerAddressId().equalsIgnoreCase(customerAddressId)){
                return c;
            }

        }
        return null;
*/
        // Lambda expressions Java 8
        CustomerAddress customerAddress = customerAddressDB.stream().
                filter(c -> c.getCustomerAddressId()
                        .equals(customerAddressId)).
                findAny()
                .orElse(null);
        return customerAddress;
    }

        @Override
        public CustomerAddress update(CustomerAddress customerAddress) {
        CustomerAddress oldCustomerAddress = read(customerAddress.getCustomerAddressId());
        if(oldCustomerAddress != null){
            customerAddressDB.remove(oldCustomerAddress);
            customerAddressDB.add(customerAddress);
            return customerAddress;
        }
        return null;
    }

        @Override
        public boolean delete(String customerAddressId) {
        CustomerAddress customerAddressToDelete = read(customerAddressId);
        if(customerAddressToDelete == null) {
            return false;
        }
        customerAddressDB.remove(customerAddressToDelete);
        return true;
    }

        @Override
        public Set<CustomerAddress> getAll() {
        return customerAddressDB;
    }
}
