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
            return this;
        }

        public Painter build() {
            return new Painter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painter painter = (Painter) o;
        return Objects.equals(painterId, painter.painterId) && Objects.equals(firstName, painter.firstName) && Objects.equals(lastName, painter.lastName) && Objects.equals(phoneNumber, painter.phoneNumber) && Objects.equals(email, painter.email) && Objects.equals(streetAddress, painter.streetAddress) && Objects.equals(city, painter.city) && Objects.equals(province, painter.province) && Objects.equals(postalCode, painter.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(painterId, firstName, lastName, phoneNumber, email, streetAddress, city, province, postalCode);
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
                '}';
    }
}


