package za.ac.cput.domain;

import java.util.Objects;
/*
* Author: Ayanda Mcengwa
* Student No: 218335989
* Subject: Applications development practice 3
* Assignment 1
* due date: 09/04/2023
* */

public class Supplier {
    private static String supplierId;
    private static String companyName;
    private static String phoneNumber;
    private static String emailAddress;
    private static String pickupAddress;

    public Supplier() {
    }
    public Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.companyName = builder.companyName;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
        this.pickupAddress = builder.pickupAddress;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getPickupAddress() {
        return pickupAddress;
    }
    public static class Builder {
        private String supplierId;
        private String companyName;
        private String phoneNumber;
        private String emailAddress;
        private String pickupAddress;

        public Supplier.Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }
        public Supplier.Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
        public Supplier.Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Supplier.Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        public Supplier.Builder setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
            return this;
        }
        public Builder copy(Supplier supplier) {
            this.supplierId = supplier.supplierId;
            this.companyName = supplier.companyName;
            this.phoneNumber = supplier.phoneNumber;
            this.emailAddress = supplier.emailAddress;
            this.pickupAddress = supplier.pickupAddress;
            return this;
        }
        public Supplier build(){
            return  new Supplier(this);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;
        Supplier supplier = (Supplier) obj;
        return Objects.equals(supplierId, supplier.supplierId)&& Objects.equals(companyName, supplier.companyName)&& Objects.equals(phoneNumber, supplier.phoneNumber)&& Objects.equals(emailAddress, supplier.emailAddress) && Objects.equals(pickupAddress, supplier.pickupAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, companyName, phoneNumber, emailAddress, pickupAddress);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", pickupAddress='" + pickupAddress + '\'' +
                '}';
    }
}
