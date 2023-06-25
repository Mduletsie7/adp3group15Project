package za.ac.cput.repository.impl;
import za.ac.cput.domain.SuppPickupAddress;
import za.ac.cput.repository.ISuppPickupAddress;

import java.util.HashSet;
import java.util.Set;

 public class SuppPickupAddressRepository implements ISuppPickupAddress {
     private static SuppPickupAddressRepository suppPickupAddressRepository = null;
     private Set<SuppPickupAddress> suppPickupAddressDB = null;

     private SuppPickupAddressRepository() {
         suppPickupAddressDB = new HashSet<>();
     }

     public static SuppPickupAddressRepository getSuppPickupAddressRepository() {
         if (suppPickupAddressRepository == null) {
             suppPickupAddressRepository = new SuppPickupAddressRepository();
         }
         return suppPickupAddressRepository;
     }

     @Override
     public SuppPickupAddress create(SuppPickupAddress suppPickupAddress) {
         boolean success = suppPickupAddressDB.add(suppPickupAddress);
         if (!success) {
             return null;
         }
         return suppPickupAddress;
     }

     @Override
     public SuppPickupAddress read(String suppPickupAddressId) {
         SuppPickupAddress pickupAddress = suppPickupAddressDB.stream()
                 .filter(suppPickupAddress1 -> suppPickupAddress1.getSuppAddressId().equals(suppPickupAddressId))
                 .findAny()
                 .orElse(null);
         return pickupAddress;
     }

     @Override
     public SuppPickupAddress update(SuppPickupAddress suppPickupAddress) {
         SuppPickupAddress oldAddress = read(suppPickupAddress.getSuppAddressId());
         if (oldAddress != null) {
             suppPickupAddressDB.remove(oldAddress);
             suppPickupAddressDB.add(suppPickupAddress);
             return suppPickupAddress;
         }
         return suppPickupAddress;
     }

     @Override
     public boolean delete(String suppPickupAddressId) {
         SuppPickupAddress pickupAddressToDelete = read(suppPickupAddressId);
         if (pickupAddressToDelete == null) {
             return false;
         }
         suppPickupAddressDB.remove(pickupAddressToDelete);
         return true;
     }
     @Override
     public Set<SuppPickupAddress> getAll() {
         return suppPickupAddressDB;
     }
 }



