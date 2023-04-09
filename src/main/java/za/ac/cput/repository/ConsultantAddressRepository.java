/**
 * ConsultantAddressRepository.java
 * This is the ConsultantAddressRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;


import za.ac.cput.domain.ConsultantAddress;

import java.util.HashSet;
import java.util.Set;

public class ConsultantAddressRepository implements IConsultantAddressRepository{
    private static ConsultantAddressRepository ConsultantAddressRepository = null;
    private Set<ConsultantAddress> consultantAddressDB = null;

    private ConsultantAddressRepository(){
        consultantAddressDB = new HashSet<ConsultantAddress>();
    }

    public static ConsultantAddressRepository getRepository(){
        if(ConsultantAddressRepository == null) {
            ConsultantAddressRepository = new ConsultantAddressRepository();
        }
        return ConsultantAddressRepository;
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
    public ConsultantAddress read(String consultantAddressId) {
        // Lambda expressions Java 8
        ConsultantAddress consultantAddress = consultantAddressDB.stream()
                .filter(p -> p.getConsultantAddressId().equals(consultantAddressId))
                .findAny()
                .orElse(null);
        return consultantAddress;
    }

    @Override
    public ConsultantAddress update(ConsultantAddress consultantAddress) {
        ConsultantAddress oldConsultantAddress = read(consultantAddress.getConsultantAddressId());
        read(consultantAddress.getConsultantAddressId());
        if (oldConsultantAddress != null){
            consultantAddressDB.remove(oldConsultantAddress);
            consultantAddressDB.add(consultantAddress);
            return consultantAddress;
        }
        return null;
    }

    @Override
    public boolean delete(String consultantAddressId) {
        ConsultantAddress consultantAddressToDelete = read(consultantAddressId);
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
