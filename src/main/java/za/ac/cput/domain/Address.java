/**
 * Address.java
 * This is the Address POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.domain;

import java.util.Objects;

public class Address {
    private String addressId;
    private String streetNumber;
    private String streetName;
    private String city;
    private String zipCode;
    private String province;

    public Address() {}


    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.province = builder.province;
    }

    // Getters
    public String getAddressId() {
        return addressId;
    }
    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getProvince() {
        return province;
    }

    public static class Builder{
        private String addressId;
        private String streetNumber;
        private String streetName;
        private String city;
        private String zipCode;
        private String province;

        // Setters
        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }
        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.city = address.city;
            this.zipCode = address.zipCode;
            this.province = address.province;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(streetNumber, address.streetNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode) && Objects.equals(province, address.province);
        }

        @Override
        public int hashCode() {
            return Objects.hash(addressId,streetNumber, streetName, city, zipCode, province);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "addressId='" + addressId + '\'' +
                    ", streetNumber='" + streetNumber + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", city='" + city + '\'' +
                    ", zipCode=" + zipCode +
                    ", province='" + province + '\'' +
                    '}';
        }
    }
}
