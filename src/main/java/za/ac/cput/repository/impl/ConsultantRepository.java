/**
 * ConsultantRepository.java
 * This is the ConsultantRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Consultant;
import za.ac.cput.repository.IConsultantRepository;

import java.util.HashSet;
import java.util.Set;

public class ConsultantRepository implements IConsultantRepository {
    private static ConsultantRepository consultantRepositoryRepository = null;
    private Set<Consultant> consultantDB = null;

    private ConsultantRepository(){
        consultantDB = new HashSet<Consultant>();
    }

    public static ConsultantRepository getRepository(){
        if(consultantRepositoryRepository == null) {
            consultantRepositoryRepository = new ConsultantRepository();
        }
        return consultantRepositoryRepository;
    }

    @Override
    public Consultant create(Consultant consultant) {
        boolean success = consultantDB.add(consultant);
        if (!success){
            return null;
        }
        return consultant;
    }

    @Override
    public Consultant read(String consultantId) {
        // Lambda expressions Java 8
        Consultant consultant = consultantDB.stream()
                .filter(e -> e.getConsultantId().equals(consultantId))
                .findAny()
                .orElse(null);
        return consultant;
    }

    @Override
    public Consultant update(Consultant consultant) {
        Consultant oldConsultant = read(consultant.getConsultantId());
        if (oldConsultant != null){
            consultantDB.remove(oldConsultant);
            consultantDB.add(consultant);
            return consultant;
        }
        return null;
    }

    @Override
    public boolean delete(String consultantId) {
        Consultant consultantToDelete = read(consultantId);
        if (consultantToDelete == null){
            return false;
        }
        consultantDB.remove(consultantToDelete);
        return true;
    }

    @Override
    public Set<Consultant> getAll() {
        return consultantDB;
    }
}
