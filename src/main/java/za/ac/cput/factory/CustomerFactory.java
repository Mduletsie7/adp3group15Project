/*
CustomerFactory.java
Entity for the customer factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import static org.springframework.util.ObjectUtils.isEmpty;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String emailAddress){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || isEmpty(phoneNumber) || Helper.isNullOrEmpty(emailAddress) || !Helper.isPhoneNumber(phoneNumber) || !Helper.isValidEmail(emailAddress) ){
            return null;
        }

        String customerId = Helper.generateId();

        if(!Helper.isValidEmail(emailAddress)){
            return null;
        }

        Customer customer = new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .build();

        return customer;
    }
}
