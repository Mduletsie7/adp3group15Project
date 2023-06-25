package za.ac.cput.service.impl;

import za.ac.cput.domain.Service;
import za.ac.cput.repository.impl.ServiceRepository;
import za.ac.cput.service.ServiceService;

import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private static ServiceServiceImpl service = null;

    private static ServiceRepository repository = null;

    private ServiceServiceImpl() { repository = ServiceRepository.getRepository(); }

    public static  ServiceServiceImpl getService() {
        if (service == null) {
            service = new ServiceServiceImpl();
        }
        return service;
    }

    @Override
    public Service create(Service service) {
        Service created = repository.create(service);
        return created;
    }

    public Service read(String serviceId) {
        Service readService = repository.read(serviceId);
        return readService;
    }

    public Service update(Service service) {
        Service updated = repository.update(service);
        return updated;
    }

    public boolean delete(String serviceId) {
        boolean success = repository.delete(serviceId);
        return success;
    }

    public Set<Service> getAll() {return repository.getAll();}
}
