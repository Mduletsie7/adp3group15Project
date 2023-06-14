/**
 * AddressRepository.java
 * This is the AddressRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository.impl;


import za.ac.cput.domain.Address;
import za.ac.cput.repository.IAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AddressRepository implements IAddressRepository {
    private static AddressRepository addressRepositoryRepository = null;
    private Set<Address> addressDB = null;

    private AddressRepository(){
        addressDB = new HashSet<Address>();
    }

    public static AddressRepository getRepository(){
        if(addressRepositoryRepository == null) {
            addressRepositoryRepository = new AddressRepository();
        }
        return addressRepositoryRepository;
    }

    @Override
    public Address create(Address address) {
        boolean success = addressDB.add(address);
        if (!success){
            return null;
        }
        return address;
    }

    @Override
    public Address read(String addressId) {
        // Lambda expressions Java 8
        Address address = addressDB.stream()
                .filter(e -> e.getAddressId().equals(addressId))
                .findAny()
                .orElse(null);
        return address;
    }

    @Override
    public Address update(Address address) {
        Address oldAddress = read(address.getAddressId());
        if (oldAddress != null){
            addressDB.remove(oldAddress);
            addressDB.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String addressId) {
        Address addressToDelete = read(addressId);
        if (addressToDelete == null){
            return false;
        }
        addressDB.remove(addressToDelete);
        return true;
    }

    @Override
    public Set<Address> getAll() {
        return addressDB;
    }
}
