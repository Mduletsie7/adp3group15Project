/*
ICustomerSiteService.java
Interface for the customer site service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.service;


import za.ac.cput.domain.CustomerSite;

import java.util.Set;

public interface ICustomerSiteService extends IService<CustomerSite, String>{

    public Set<CustomerSite> getAll();

}
