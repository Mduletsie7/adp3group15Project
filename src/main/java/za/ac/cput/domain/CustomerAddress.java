/*
CustomerAddress.java
Entity for the customer address
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class CustomerAddress {
    private String customerAddressId;
    private String customerId;
    private String addressId;

    // Add private constructor
    public CustomerAddress() {}

    private CustomerAddress(Builder builder) {
        this.customerAddressId = builder.customerAddressId;
        this.customerId = builder.customerId;
        this.addressId = builder.addressId;
    }

    public String getCustomerAddressId() {
        return customerAddressId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public static class Builder {
        private String customerAddressId;
        private String customerId;
        private String addressId;


        public Builder setCustomerAddressId(String customerAddressId) {
            this.customerAddressId = customerAddressId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder copy(CustomerAddress customerAddress) {
            this.customerAddressId= customerAddress.customerAddressId;
            this.customerId = customerAddress.customerId;
            this.addressId = customerAddress.addressId;
            return this;
        }

        public CustomerAddress build() {
            return new CustomerAddress(this);
        }
    }

    @Override
    public boolean equals(Object ca) {
        if (this == ca) return true;
        if (ca == null || getClass() != ca.getClass()) return false;
        CustomerAddress customerAddress = (CustomerAddress) ca;
        return  Objects.equals(customerAddressId, customerAddress.customerAddressId) &&
                Objects.equals(customerId, customerAddress.customerId)
                && Objects.equals(addressId, customerAddress.addressId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerAddressId, customerId, addressId);
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "customerAddressId='" + customerAddressId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}
