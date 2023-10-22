/*
 * Author: Mdumisi Kelvin Letsie
 * Student No: 220120137
 * Subject: Applications development practice 3
 * */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Painter {

    @Id
    private String painterId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    private String description;

    public Painter() {}

    // Add private constructor

    private Painter(Builder builder) {
        this.painterId = builder.painterId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.streetAddress = builder.streetAddress;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.description = builder.description;
    }

    // GETTERS

    public String getPainterId() {
        return painterId;
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
    public String getEmail()  {return email; }
    public String getStreetAddress()  {return streetAddress; }
    public String getCity()  {return city; }
    public String getProvince()  {return province; }
    public String getPostalCode()  {return postalCode; }

    public String getDescription(){
        return description;
    }


    public static class Builder {
        private String painterId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String streetAddress;
        private String city;
        private String province;
        private String postalCode;

        private String description;


        // SETTERS
        public Builder setPainterId(String painterId) {
            this.painterId = painterId;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }


        public Builder copy(Painter painter) {
            this.painterId = painter.painterId;
            this.firstName = painter.firstName;
            this.lastName = painter.lastName;
            this.phoneNumber = painter.phoneNumber;
            this.email = painter.email;
            this.streetAddress = painter.streetAddress;
            this.city = painter.city;
            this.province = painter.province;
            this.postalCode = painter.postalCode;
            this.description = painter.description;
            return this;
        }

        public Painter build() {
            return new Painter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Painter painter)) return false;
        return Objects.equals(getPainterId(), painter.getPainterId()) && Objects.equals(getFirstName(), painter.getFirstName()) && Objects.equals(getLastName(), painter.getLastName()) && Objects.equals(getPhoneNumber(), painter.getPhoneNumber()) && Objects.equals(getEmail(), painter.getEmail()) && Objects.equals(getStreetAddress(), painter.getStreetAddress()) && Objects.equals(getCity(), painter.getCity()) && Objects.equals(getProvince(), painter.getProvince()) && Objects.equals(getPostalCode(), painter.getPostalCode()) && Objects.equals(getDescription(), painter.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPainterId(), getFirstName(), getLastName(), getPhoneNumber(), getEmail(), getStreetAddress(), getCity(), getProvince(), getPostalCode(), getDescription());
    }

    @Override
    public String toString() {
        return "Painter{" +
                "painterId='" + painterId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


