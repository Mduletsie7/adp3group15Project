package za.ac.cput.factory;
/**
 * AddressFactory.java
 * This is the AddressFactory POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */
import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createAddress(String streetNumber,String streetName, String city, String zipCode, String province) {
        String addressId = Helper.generateId();
        if (Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(zipCode) || Helper.isNullOrEmpty(province)) {
            return null;
        }

        Address address = new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setCity(city)
                .setZipCode(zipCode)
                .setProvince(province)
                .build();

        return address;
    }
}
