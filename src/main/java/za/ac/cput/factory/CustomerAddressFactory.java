package za.ac.cput.factory;


import za.ac.cput.domain.CustomerAddress;
import za.ac.cput.util.Helper;

public class CustomerAddressFactory {
    public static CustomerAddress createCustomerAddress(String customerId, String addressId){
        if(Helper.isNullOrEmpty(customerId) || Helper.isNullOrEmpty(addressId) ){
            return null;
        }

        String customerAddressId = Helper.generateId();

        CustomerAddress customerAddress = new CustomerAddress.Builder()
                .setCustomerAddressId(customerAddressId)
                .setCustomerId(customerId)
                .setAddressId(addressId)
                .build();

        return customerAddress;
    }
}
