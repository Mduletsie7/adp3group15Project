/**
 * IConsultantAddressRepository.java
 * This is the IConsultantAddressRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.ConsultantAddress;

import java.util.Set;

public interface IConsultantAddressRepository extends IRepository<ConsultantAddress, String>{
    // create, read, update, delete
    public Set<ConsultantAddress> getAll();
}
