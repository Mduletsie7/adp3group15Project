package za.ac.cput.factory;
/**
 * AddressFactory.java
 * This is the AddressFactory POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Consultant;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createAddress(String streetNumber, String streetName, String city, String zipCode, String province) {
        if (Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(province)) {
            return null;
        }

        String addressId = Helper.generateId();


        Address address = new Address.Builder()
                .setStreetNumber(streetNumber)
                .setStreetNane(streetName)
                .setAddressId(addressId)
                .setCity(city)
                .setZipCode(zipCode)
                .setProvince(province)
                .build();

        return address;
    }
}
