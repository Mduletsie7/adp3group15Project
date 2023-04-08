package za.ac.cput.domain;

import java.util.Objects;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Assignment 1
 * due date: 09/04/2023
 * */
public class SuppPickupAddress {
    private String suppAddress;
    private String supplierId;
    private String addressId;
    public SuppPickupAddress() {
    }
    public SuppPickupAddress(SuppPickupAddress.Builder builder) {
        this.suppAddress = Builder.suppAddress;
        this.supplierId = Builder.supplierId;
        this.addressId = Builder.addressId;
    }
    public String getSuppAddress() {
        return suppAddress;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public String getAddressId() {
        return addressId;
    }
    public static class Builder {
        private static String suppAddress;
        private static String supplierId;
        private static String addressId;
        public SuppPickupAddress.Builder setSuppAddress(String suppAddress) {
            this.suppAddress = suppAddress;
            return this;
        }
        public SuppPickupAddress.Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }
        public SuppPickupAddress.Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }
        public  Builder copy(SuppPickupAddress pickupAddress){
            this.suppAddress = pickupAddress.suppAddress;
            this.supplierId = pickupAddress.supplierId;
            this.addressId = pickupAddress.addressId;
            return this;
        }
        public SuppPickupAddress build(){
            return new SuppPickupAddress(this);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;
        SuppPickupAddress pickupAddress = (SuppPickupAddress) obj;
        return Objects.equals(suppAddress, pickupAddress.suppAddress)&& Objects.equals(supplierId, pickupAddress.supplierId)&& Objects.equals(addressId, pickupAddress.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suppAddress, supplierId, addressId);
    }

    @Override
    public String toString() {
        return "SuppPickupAddress{" +
                "suppAddress='" + suppAddress + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}

