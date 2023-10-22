/**
 * IAddressRepository.java
 * This is the IAddressRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;


import za.ac.cput.domain.Address;

import java.util.Set;

public interface IAddressRepository extends IRepository<Address, String>{
    // create, read, update, delete
    public Set<Address> getAll();
}
