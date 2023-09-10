package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String emailAddress, String addressId){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(addressId)){
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
                .setAddressId(addressId)
                .build();

        return customer;
    }
}
