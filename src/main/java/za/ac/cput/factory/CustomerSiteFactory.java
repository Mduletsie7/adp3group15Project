/*
CustomerSiteFactory.java
Entity for the customer site factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.factory;


import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerSite;
import za.ac.cput.util.Helper;

import static java.util.Objects.isNull;

public class CustomerSiteFactory {
    public static CustomerSite createCustomerSite(Customer customerId, String type, String street, String city, String province, int postalCode){
        if(isNull(customerId) || Helper.isNullOrEmpty(type) || Helper.isNullOrEmpty(street) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || (postalCode == 0) || !Helper.isZipCode(postalCode) || !Helper.isWithinRange(postalCode)){
            return null;
        }

        String customerSiteId = Helper.generateId();

        CustomerSite customerSite = new CustomerSite.Builder()
                .setSiteId(customerSiteId)
                .setCustomerId(customerId)
                .setType(type)
                .setStreet(street)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postalCode)
                .build();

        return customerSite;
    }
}
