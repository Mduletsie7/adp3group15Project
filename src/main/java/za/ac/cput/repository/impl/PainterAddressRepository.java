/**
 * PainterAddressRepository.java
 * This is the PainterAddressRepository Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.*;
import za.ac.cput.repository.IPainterAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class PainterAddressRepository implements IPainterAddressRepository {
    private static PainterAddressRepository painterAddressRepository = null;
    private Set<PainterAddress> painterAddressDB = null;

    private PainterAddressRepository(){
        painterAddressDB = new HashSet<PainterAddress>();
    }

    public static PainterAddressRepository getRepository(){
        if(painterAddressRepository == null) {
            painterAddressRepository = new PainterAddressRepository();
        }
        return painterAddressRepository;
    }

    @Override
    public PainterAddress create(PainterAddress painterAddress) {
        boolean success = painterAddressDB.add(painterAddress);
        if (!success){
            return null;
        }
        return painterAddress;
    }

    @Override
    public PainterAddress read(String painterAddressId) {
        // Lambda expressions Java 8
        PainterAddress painterAddress = painterAddressDB.stream()
                .filter(p -> p.getPainterAddressId().equals(painterAddressId))
                .findAny()
                .orElse(null);
        return painterAddress;
    }

    @Override
    public PainterAddress update(PainterAddress painterAddress) {
        PainterAddress oldPainterAddress = read(painterAddress.getPainterAddressId());
        read(painterAddress.getPainterAddressId());
        if (oldPainterAddress != null){
            painterAddressDB.remove(oldPainterAddress);
            painterAddressDB.add(painterAddress);
            return painterAddress;
        }
        return null;
    }

    @Override
    public boolean delete(String painterAddressId) {
        PainterAddress addressToDelete = read(painterAddressId);
        if (addressToDelete == null){
            return false;
        }
        painterAddressDB.remove(addressToDelete);
        return true;
    }

    @Override
    public Set<PainterAddress> getAll() {
        return painterAddressDB;
    }
}
