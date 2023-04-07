/**
 * ConsultantAddressRepository.java
 * This is the ConsultantAddressRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;


import za.ac.cput.domain.Address;
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.ConsultantAddress;

import java.util.HashSet;
import java.util.Set;

public class ConsultantAddressRepository implements IConsultantAddressRepository{
    private static ConsultantAddressRepository repository = null;
    private Set<ConsultantAddress> consultantAddressDB = null;

    private ConsultantAddressRepository(){
        consultantAddressDB = new HashSet<ConsultantAddress>();
    }

    public static ConsultantAddressRepository getRepository(){
        if(repository == null) {
            repository = new ConsultantAddressRepository();
        }
        return repository;
    }

    @Override
    public ConsultantAddress create(ConsultantAddress consultantAddress) {
        boolean success = consultantAddressDB.add(consultantAddress);
        if (!success){
            return null;
        }
        return consultantAddress;
    }

    @Override
    public ConsultantAddress read(Consultant consultantId, Address addressId) {
        // Lambda expressions Java 8
        ConsultantAddress consultantAddress = consultantAddressDB.stream()
                .filter(e -> e.getConsultantId().equals(consultantId))
                .findAny()
                .orElse(null);

        consultantAddressDB.stream()
                .filter(e -> e.getAddressId().equals(addressId))
                .findAny()
                .orElse(null);
        return consultantAddress;
    }

    @Override
    public ConsultantAddress update(ConsultantAddress consultantAddress) {
        ConsultantAddress oldConsultantAddress = read(consultantAddress.getConsultantId());
        read(consultantAddress.getAddressId());
        if (oldConsultantAddress != null){
            consultantAddressDB.remove(oldConsultantAddress);
            consultantAddressDB.add(consultantAddress);
            return consultantAddress;
        }
        return null;
    }

    @Override
    public boolean delete(Consultant consultantId, Address addressId) {
        ConsultantAddress consultantAddressToDelete = read(String.valueOf(consultantId));
        read(String.valueOf(addressId));
        if (consultantAddressToDelete == null){
            return false;
        }
        consultantAddressDB.remove(consultantAddressToDelete);
        return true;
    }

    @Override
    public Set<ConsultantAddress> getAll() {
        return consultantAddressDB;
    }
}
