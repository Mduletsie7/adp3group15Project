/*
CustomerSiteController.java
Entity for the customer site controller
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerSite;
import za.ac.cput.service.CustomerSiteService;

import java.util.Set;

@RestController
@RequestMapping("/customerSite")
public class CustomerSiteController {

    private CustomerSiteService service;

    @Autowired
    CustomerSiteController(CustomerSiteService service){
        this.service = service;
    }

    @PostMapping("/create")
    public CustomerSite create(@RequestBody CustomerSite customerSite){
        return service.create(customerSite);
    }

    @GetMapping("/read/{id}")
    public CustomerSite read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public CustomerSite update(@RequestBody CustomerSite customerSite){
        return service.update(customerSite);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<CustomerSite> getAll(){
        return service.getAll();
    }
}
