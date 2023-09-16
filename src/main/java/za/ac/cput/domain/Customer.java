/*
Customer.java
Entity for the customer
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public Customer() {}

    // Add private constructor

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
        }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class Builder {
        private String customerId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private  String emailAddress;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.emailAddress = customer.emailAddress;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object c) {
        if (this == c) return true;
        if (c == null || getClass() != c.getClass()) return false;
        Customer customer = (Customer) c;
        return  Objects.equals(customerId, customer.customerId) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName)
                && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(emailAddress, customer.emailAddress);
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, phoneNumber, emailAddress);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

