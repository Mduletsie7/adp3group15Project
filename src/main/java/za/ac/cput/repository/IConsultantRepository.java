/**
 * IConsultantRepository.java
 * This is the IConsultantRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Consultant;

import java.util.Set;

public interface IConsultantRepository extends IRepository<Consultant, String>{
    // create, read, update, delete
    public Set<Consultant> getAll();
}
