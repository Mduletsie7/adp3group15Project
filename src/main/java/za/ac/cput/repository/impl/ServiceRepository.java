/**
 * ServiceRepository.java
 * This is the ServiceRepository Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Service;
import za.ac.cput.repository.IServiceRepository;

import java.util.HashSet;
import java.util.Set;

public class ServiceRepository implements IServiceRepository {
    private static ServiceRepository serviceRepository = null;
    private Set<Service> serviceDB = null;

    private ServiceRepository(){
        serviceDB = new HashSet<Service>();
    }

    public static ServiceRepository getRepository(){
        if(serviceRepository == null) {
            serviceRepository = new ServiceRepository();
        }
        return serviceRepository;
    }

    @Override
    public Service create(Service service) {
        boolean success = serviceDB.add(service);
        if (!success){
            return null;
        }
        return service;
    }

    @Override
    public Service read(String serviceId) {
        // Lambda expressions Java 8
        Service service = serviceDB.stream()
                .filter(s -> s.getServiceId().equals(serviceId))
                .findAny()
                .orElse(null);
        return service;
    }

    @Override
    public Service update(Service service) {
        Service oldService = read(service.getServiceId());
        if (oldService != null){
            serviceDB.remove(oldService);
            serviceDB.add(service);
            return service;
        }
        return null;
    }

    @Override
    public boolean delete(String serviceId) {
        Service serviceToDelete = read(serviceId);
        if (serviceToDelete == null){
            return false;
        }
        serviceDB.remove(serviceToDelete);
        return true;
    }

    @Override
    public Set<Service> getAll() {
        return serviceDB;
    }
}
