package za.ac.cput.factory;

import za.ac.cput.domain.SuppPickupAddress;
import za.ac.cput.util.Helper;

public class SuppPickupAddressFactory {
    public static SuppPickupAddress createPickupAddress(String addressId, String supplierId){
        if (Helper.isNullOrEmpty(addressId) || Helper.isNullOrEmpty(supplierId)){}
        String suppAddress = Helper.generateId();
        SuppPickupAddress suppPickupAddress = new SuppPickupAddress.Builder()
                .setSuppAddress(suppAddress)
                .setAddressId(addressId)
                .setSupplierId(supplierId)
                .build();
        return  suppPickupAddress;
    }
}
