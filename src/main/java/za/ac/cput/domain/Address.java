/**
 * Address.java
 * This is the Address POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.domain;

import java.util.Objects;

public class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String zipCode;
    private String province;
    private String addressId;

    public Address() {}

    // Add private constructor

    private Address(Address.Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.addressId = builder.addressId;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.province = builder.province;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }
    public String getAddressId() {
        return addressId;
    }

    public String getCity() {
        return city;
    }
    public String getZipCode()  {return zipCode; }
    public String getProvince() {
        return province;
    }

    public static class Builder {
        private String streetNumber;
        private String streetName;
        private String city;
        private String zipCode;
        private String province;
        private String addressId;


        // SETTERS
        public Address.Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Address.Builder setStreetNane(String streetName) {
            this.streetName = streetName;
            return this;
        }
        public Address.Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Address.Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Address.Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address.Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Address.Builder copy(Address address) {
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.addressId = address.addressId;
            this.city = address.city;
            this.zipCode = address.zipCode;
            this.province = address.province;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetNumber, address.streetNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode) && Objects.equals(province, address.province) && Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, city, zipCode, province, addressId);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", province='" + province + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}
