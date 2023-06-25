package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;
import za.ac.cput.service.ServiceService;

import java.util.Set;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @PostMapping("/createService")
    public Service create(@RequestBody Service service) {
        Service serviceCreated = ServiceFactory.createService(
                service.getServiceName());
        return serviceService.create(serviceCreated);
    }

    @RequestMapping({"/getAllService"})
    public Set<Service> getAll() {
        return serviceService.getAll();
    }
}