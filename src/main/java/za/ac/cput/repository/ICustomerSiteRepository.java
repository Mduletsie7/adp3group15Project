/*
ICustomerAddressRepository.java
Interface for invoice repository
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CustomerSite;

@Repository
public interface ICustomerSiteRepository extends JpaRepository<CustomerSite, String> {

}
