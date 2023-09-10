/*
CustomerSiteService.java
Entity for the customer site service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerSite;
import za.ac.cput.repository.ICustomerSiteRepository;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerSiteService implements ICustomerSiteService {

    private ICustomerSiteRepository repository;

    @Autowired
    private CustomerSiteService(ICustomerSiteRepository repository){
        this.repository = repository;
    }

    @Override
    public CustomerSite create(CustomerSite customerSite){
        return this.repository.save(customerSite);
    }

    @Override
    public CustomerSite read(String customerSiteId){
        return this.repository.findById(customerSiteId).orElse(null);
    }

    @Override
    public CustomerSite update(CustomerSite customerSite){
        if(this.repository.existsById(customerSite.getSiteId())){
            return this.repository.save(customerSite);
        }
        return null;
    }
    @Override
    public boolean delete(String customerSiteId){
        if(this.repository.existsById(customerSiteId)){
            this.repository.deleteById(customerSiteId);
            return true;
        }
        return false;
    }

    @Override
    public Set<CustomerSite> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}
