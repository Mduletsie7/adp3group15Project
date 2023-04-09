package za.ac.cput.domain;

import java.util.Objects;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Assignment 1
 * due date: 09/04/2023
 * */
public class SuppPickupAddress{
    private String suppAddressId;
    private String supplierId;
    private String addressId;
    public SuppPickupAddress() {
    }
    public SuppPickupAddress(Builder builder) {
        this.suppAddressId = builder.suppAddressId;
        this.supplierId = builder.supplierId;
        this.addressId = builder.addressId;
    }
    public String getSuppAddressId() {
        return suppAddressId;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public String getAddressId() {
        return addressId;
    }

    public static class Builder {
        private static String suppAddressId;
        private static String supplierId;
        private static String addressId;
        public SuppPickupAddress.Builder setSuppAddressId(String suppAddressId) {
            this.suppAddressId = suppAddressId;
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
        public SuppPickupAddress.Builder copy(SuppPickupAddress pickupAddress){
            this.suppAddressId = pickupAddress.suppAddressId;
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
        return Objects.equals(suppAddressId, pickupAddress.suppAddressId)&& Objects.equals(supplierId, pickupAddress.supplierId)&& Objects.equals(addressId, pickupAddress.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suppAddressId, supplierId, addressId);
    }

    @Override
    public String toString() {
        return "SuppPickupAddress{" +
                "suppAddressId='" + suppAddressId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}

